package com.TrainReservationApp.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.TrainReservationApp.exceptions.CoachException;
import com.TrainReservationApp.models.Seat;

@Service
public class SeatServicesImpl implements SeatServices {

	/**
	 * Retrieves the list of vacant seats from the given list of seats.
	 *
	 * @param allSeats The list of all seats.
	 * @return The list of vacant seats.
	 */
	@Override
	public List<Seat> getVacantSeats(List<Seat> allSeats) {
		return allSeats.stream().filter(seat -> !seat.getIsBooked()) // Filter out booked seats
				.sorted(Comparator.comparingInt(Seat::getSeatNumber)) // Sort seats by seat number
				.collect(Collectors.toList()); // Collect the result as a list
	}

	/**
	 * Retrieves the list of vacant seats in a specific row from the given list of
	 * seats.
	 *
	 * @param rowNumber The row number.
	 * @param allSeats  The list of all seats.
	 * @return The list of vacant seats in the specified row.
	 * @throws CoachException if the row number is invalid.
	 */
	@Override
	public List<Seat> getVacantSeatsInRow(Integer rowNumber, List<Seat> allSeats) {
		if (rowNumber < 13 && rowNumber > 0) {
			int currSeatNo = ((rowNumber - 1) * 7) + 1; // Calculate the current seat number for the row
			int lastSeatNo = (rowNumber == 12) ? 80 : rowNumber * 7; // Calculate the last seat number for the row

			return allSeats.stream()
					.filter((seat) -> (!seat.getIsBooked() && seat.getSeatNumber() >= currSeatNo
							&& seat.getSeatNumber() <= lastSeatNo)) // Filter seats within the row range
					.collect(Collectors.toList()); // Collect the result as a list
		} else {
			throw new CoachException("Invalid Row Number: " + rowNumber); // Throw an exception for invalid row number
		}
	}
}
