package com.TrainReservationApp.services;

import com.TrainReservationApp.dtos.BookingDto;
import com.TrainReservationApp.dtos.TicketDto;

public interface TicketServices {

	/**
	 * Books a ticket based on the provided booking details.
	 *
	 * @param bookingDto The booking details.
	 * @return The ticket information.
	 */
	TicketDto bookTicket(BookingDto bookingDto);
}
