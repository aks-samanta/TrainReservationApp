package com.TrainReservationApp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainReservationApp.dtos.BookingDto;
import com.TrainReservationApp.dtos.SeatDto;
import com.TrainReservationApp.dtos.TicketDto;
import com.TrainReservationApp.exceptions.BookingException;
import com.TrainReservationApp.exceptions.CoachException;
import com.TrainReservationApp.models.Coach;
import com.TrainReservationApp.models.Seat;
import com.TrainReservationApp.models.Ticket;
import com.TrainReservationApp.repositories.CoachRepo;
import com.TrainReservationApp.repositories.TicketRepo;

@Service
public class TicketServicesImpl implements TicketServices {

	@Autowired
	private CoachRepo coachRepo;

	@Autowired
	private SeatServices seatServices;

	@Autowired
	private TicketRepo ticketRepo;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Books a ticket based on the provided booking details.
	 *
	 * @param bookingDto The booking details.
	 * @return The booked ticket details.
	 * @throws BookingException If there are not enough available seats or other
	 *                          booking related issues.
	 * @throws CoachException   If the coach with the specified coach ID is not
	 *                          found.
	 */
	@Override
	public TicketDto bookTicket(BookingDto bookingDto) {
		Coach coach = coachRepo.findById(bookingDto.getCoachId())
				.orElseThrow(() -> new CoachException("Coach not found with coach Id: " + bookingDto.getCoachId()));

		List<Seat> allVacantSeats = seatServices.getVacantSeats(coach.getSeats());

		if (allVacantSeats.size() >= bookingDto.getNoOfSeats()) {
			// Check for vacant seats in each row
			int rowNumber = 1;
			while (rowNumber < 13) {
				List<Seat> vacantSeatsinRow = seatServices.getVacantSeatsInRow(rowNumber, allVacantSeats);
				if (vacantSeatsinRow.size() >= bookingDto.getNoOfSeats()) {
					// Book seats in the row
					TicketDto ticketDto = bookSeats(coach, vacantSeatsinRow, bookingDto.getNoOfSeats());
					
					return ticketDto;
				} else {
					rowNumber++;
				}
			}

			// Unable to find a row of seats with the required number
			// Try booking the nearest seats using the sliding window technique
			TicketDto ticketDto = bookNearestSeats(coach, allVacantSeats, bookingDto.getNoOfSeats());
			return ticketDto;
		} else {
			// Not enough seats are available in this coach
			throw new BookingException("Not enough seats are available in this coach.");
		}
	}

	/**
	 * Books seats in a row based on the provided vacant seats.
	 *
	 * @param coach            The coach object.
	 * @param vacantSeatsinRow The list of vacant seats in the row.
	 * @param noOfSeats        The number of seats to be booked.
	 * @return The booked ticket details.
	 */
	private TicketDto bookSeats(Coach coach, List<Seat> vacantSeatsinRow, int noOfSeats) {
		Ticket ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setCoach(coach);
		ticket.setReservedSeats(new ArrayList<>());

		// Reserve the required number of seats
		for (int i = 0; i < noOfSeats; i++) {
			Seat seat = vacantSeatsinRow.get(i);
	        seat.setIsBooked(true);  // Update the is_booked field to true
	        ticket.getReservedSeats().add(seat);
		}

		// Save the ticket and update the seats in the database
	    ticket = ticketRepo.save(ticket);
	    coach.setAvailableSeats(coach.getAvailableSeats() - noOfSeats);
	    coachRepo.save(coach);  // Update the seats in the coach

		// Map reserved seats to SeatDto objects
		List<SeatDto> reservedSeatDtos = ticket.getReservedSeats().stream()
				.map((seat) -> this.modelMapper.map(seat, SeatDto.class)).collect(Collectors.toList());

		// Map ticket to TicketDto
		TicketDto ticketDto = this.modelMapper.map(ticket, TicketDto.class);
		ticketDto.setReservedSeats(reservedSeatDtos);

		return ticketDto;
	}

	/**
	 * Books the nearest seats using the sliding window technique.
	 *
	 * @param coach          The coach object.
	 * @param allVacantSeats The list of all vacant seats.
	 * @param noOfSeats      The number of seats to be booked.
	 * @return The booked ticket details.
	 * @throws BookingException If unable to find a window of seats with the
	 *                          required number.
	 */
	private TicketDto bookNearestSeats(Coach coach, List<Seat> allVacantSeats, int noOfSeats) {
		int windowSize = noOfSeats;
		int startIndex = 0;
		int endIndex = windowSize - 1;
		int minDistance = Integer.MAX_VALUE;
		int minStartIndex = -1;

		while (endIndex < allVacantSeats.size()) {
			int distance = allVacantSeats.get(endIndex).getSeatNumber() - allVacantSeats.get(startIndex).getSeatNumber();
			if (distance < minDistance) {
				minDistance = distance;
				minStartIndex = startIndex;
			}
			startIndex++;
			endIndex++;
		}

		if (minStartIndex != -1) {
			// Get the nearest seats within the window
			List<Seat> nearestSeats = allVacantSeats.subList(minStartIndex, minStartIndex + noOfSeats);
			nearestSeats.forEach(seat -> seat.setIsBooked(true));
			
			
			Ticket ticket = new Ticket();
			ticket.setBookingDate(new Date());
			ticket.setCoach(coach);
			ticket.setReservedSeats(new ArrayList<>(nearestSeats));

			ticket = ticketRepo.save(ticket);
		    coach.setAvailableSeats(coach.getAvailableSeats() - noOfSeats);
		    coachRepo.save(coach);  // Update the seats in the coach

			// Map reserved seats to SeatDto objects
			List<SeatDto> reservedSeatDtos = ticket.getReservedSeats().stream()
					.map((seat) -> this.modelMapper.map(seat, SeatDto.class)).collect(Collectors.toList());

			// Map ticket to TicketDto
			TicketDto ticketDto = this.modelMapper.map(ticket, TicketDto.class);
			ticketDto.setReservedSeats(reservedSeatDtos);

			return ticketDto;
		} else {
			throw new BookingException("Unable to find a window of seats with the required number.");
		}
	}
}
