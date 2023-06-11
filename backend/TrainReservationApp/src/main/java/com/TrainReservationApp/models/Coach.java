package com.TrainReservationApp.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * The Coach entity represents a train coach in the Train Reservation Application.
 */
@Entity
@Data
public class Coach {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer coachId;

	private Integer totalSeats;

	private Integer availableSeats;

	@OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
	private List<Seat> seats = new ArrayList<Seat>();
}
