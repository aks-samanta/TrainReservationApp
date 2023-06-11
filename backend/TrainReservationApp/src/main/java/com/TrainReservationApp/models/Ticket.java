package com.TrainReservationApp.models;

import java.util.Date;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * The Ticket entity represents a ticket in the Train Reservation Application.
 */
@Entity
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Seat> reservedSeats;

	private Date bookingDate;
	
	@ManyToOne
	private Coach coach;
}
