package com.TrainReservationApp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TrainReservationApp.dtos.CoachDto;
import com.TrainReservationApp.dtos.SeatDto;
import com.TrainReservationApp.exceptions.CoachException;
import com.TrainReservationApp.models.Coach;
import com.TrainReservationApp.models.Seat;
import com.TrainReservationApp.repositories.CoachRepo;
import com.TrainReservationApp.repositories.SeatRepo;
import com.TrainReservationApp.repositories.TicketRepo;

@Service
public class CoachServicesImpl implements CoachServices {

	@Autowired
	private CoachRepo coachRepo;

	@Autowired
	private SeatRepo seatRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TicketRepo ticketRepo;

	/**
	 * Retrieves the coach details.
	 *
	 * @return The coach details.
	 */
	@Override
	public CoachDto getCoach() {
		// Find the coach with the highest number of available seats
		Coach coach = coachRepo.findFirstByOrderByAvailableSeatsDesc();
		coach.getSeats();
		// If no coach found or all seats are booked, create a new coach
		if (coach == null || coach.getAvailableSeats() == 0) {
			return this.createNewCoach();
		}

		return this.modelMapper.map(coach, CoachDto.class);
	}

	@Override
	public CoachDto getCoachById(Integer coachId) {
		Coach coach = coachRepo.findById(coachId)
				.orElseThrow(() -> new CoachException("Coach not found with coach ID: " + coachId));

		return modelMapper.map(coach, CoachDto.class);
	}

	/**
	 * Creates a new coach with default seat configuration.
	 *
	 * @return The newly created coach details.
	 */
	@Override
	public CoachDto createNewCoach() {
		Coach coach = new Coach();
		coach.setAvailableSeats(80);
		coach.setTotalSeats(80);
		coach = coachRepo.save(coach);	
		// Create seats and assign them to the coach
		for (int i = 0; i < 80; i++) {
			Seat newSeat = new Seat();
			newSeat.setIsBooked(false);
			newSeat.setSeatNumber(i + 1);
			newSeat.setCoach(coach);
			coach.getSeats().add(seatRepo.save(newSeat));
		}

		// Save the coach
		coach = coachRepo.save(coach);

		// Map seats to SeatDto objects
		List<SeatDto> seatDtos = coach.getSeats().stream().map((seat) -> this.modelMapper.map(seat, SeatDto.class))
				.collect(Collectors.toList());

		// Map coach to CoachDto
		CoachDto coachDto = this.modelMapper.map(coach, CoachDto.class);
		coachDto.setSeats(seatDtos);

		return coachDto;
	}
	

	// ...

	@Transactional
	@Override
	public CoachDto resetCoach(Integer coachId) {
	    Coach coach = coachRepo.findById(coachId)
	            .orElseThrow(() -> new CoachException("Coach not found with coach ID: " + coachId));

	    ticketRepo.deleteAllByCoach(coach);

	    for (Seat seat : coach.getSeats()) {
	        seat.setIsBooked(false);
	        seatRepo.save(seat);
	        coach.setAvailableSeats(coach.getAvailableSeats()+1);
	    }

	    return modelMapper.map(coachRepo.save(coach), CoachDto.class);
	}


}
