package com.TrainReservationApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrainReservationApp.models.Ticket;

/**
 * The TicketRepo interface provides database access and operations for the Ticket entity.
 * It extends the JpaRepository interface, which provides basic CRUD operations for the entity.
 */
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
}
