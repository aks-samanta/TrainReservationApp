package com.TrainReservationApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * The Seat entity represents a seat in a train coach in the Train Reservation Application.
 */
@Entity
@Data
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seatId;

	private Boolean isBooked;

	private Integer seatNumber;

	@ManyToOne
	private Coach coach;

}
