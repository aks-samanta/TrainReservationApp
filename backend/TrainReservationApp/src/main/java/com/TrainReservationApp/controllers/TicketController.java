package com.TrainReservationApp.controllers;

import com.TrainReservationApp.dtos.BookingDto;
import com.TrainReservationApp.dtos.TicketDto;
import com.TrainReservationApp.services.TicketServices;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "*")

public class TicketController {

    @Autowired
    private TicketServices ticketServices;

    /**
     * Endpoint to book a ticket.
     *
     * @param bookingDto The booking details provided in the request body.
     * @return ResponseEntity containing the TicketDto if the ticket is booked successfully.
     */
    @PostMapping("/book")
    public ResponseEntity<TicketDto> bookTicket(@Valid @RequestBody BookingDto bookingDto) {
        // Delegate the ticket booking operation to the TicketServices
        TicketDto ticketDto = ticketServices.bookTicket(bookingDto);
        return ResponseEntity.ok(ticketDto);
    }
}
