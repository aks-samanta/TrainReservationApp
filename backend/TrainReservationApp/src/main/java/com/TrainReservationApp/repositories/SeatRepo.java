package com.TrainReservationApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrainReservationApp.models.Seat;

/**
 * The SeatRepo interface provides database access and operations for the Seat entity.
 * It extends the JpaRepository interface, which provides basic CRUD operations for the entity.
 */
public interface SeatRepo extends JpaRepository<Seat, Integer> {
}
