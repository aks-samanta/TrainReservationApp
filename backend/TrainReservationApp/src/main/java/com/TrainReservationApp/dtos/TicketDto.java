package com.TrainReservationApp.dtos;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class TicketDto {

    /**
     * Represents the ID of the ticket.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Integer ticketId;

    /**
     * Represents the list of reserved seats for the ticket.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private List<SeatDto> reservedSeats;

    /**
     * Represents the booking date of the ticket.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Date bookingDate;

    /**
     * Represents the coach associated with the ticket.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private CoachDto coach;
}
