package com.TrainReservationApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrainReservationApp.models.Coach;

/**
 * The CoachRepo interface provides database access and operations for the Coach entity.
 * It extends the JpaRepository interface, which provides basic CRUD operations for the entity.
 */
public interface CoachRepo extends JpaRepository<Coach, Integer> {

	/**
	 * Retrieves the coach with the highest number of available seats.
	 * 
	 * @return The coach with the highest number of available seats.
	 */
	Coach findFirstByOrderByAvailableSeatsDesc();
}
