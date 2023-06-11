package com.TrainReservationApp.services;

import java.util.List;

import com.TrainReservationApp.models.Seat;

/**
 * The SeatServices interface defines the contract for the Seat-related services in the Train Reservation Application.
 * It specifies the methods for retrieving and manipulating Seat objects.
 */
public interface SeatServices {

	/**
	 * Retrieves the list of vacant seats from the given list of seats.
	 *
	 * @param allSeats The list of seats to check for vacancy.
	 * @return The list of vacant seats.
	 */
	List<Seat> getVacantSeats(List<Seat> allSeats);

	/**
	 * Retrieves the list of vacant seats in the specified row number from the given list of seats.
	 *
	 * @param rowNumber The row number to filter the seats.
	 * @param allSeats The list of seats to check for vacancy.
	 * @return The list of vacant seats in the specified row number.
	 */
	List<Seat> getVacantSeatsInRow(Integer rowNumber, List<Seat> allSeats);
}
