package com.TrainReservationApp.services;

import com.TrainReservationApp.dtos.CoachDto;

/**
 * The CoachServices interface defines the contract for the Coach-related services in the Train Reservation Application.
 * It specifies the methods for retrieving and manipulating CoachDto objects.
 */
public interface CoachServices {

	/**
	 * Retrieves the CoachDto representing the coach.
	 *
	 * @return The CoachDto representing the coach.
	 */
	CoachDto getCoach();

	/**
	 * Creates a new CoachDto and returns it.
	 *
	 * @return The newly created CoachDto.
	 */
	CoachDto createNewCoach();

	/**
	 * Retrieves the CoachDto with the specified coachId.
	 *
	 * @param coachId The ID of the coach to retrieve.
	 * @return The CoachDto with the specified coachId.
	 */
	CoachDto getCoachById(Integer coachId);

	CoachDto resetCoach(Integer coachId);
}
