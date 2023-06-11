package com.TrainReservationApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class SeatDto {

    /**
     * Represents the ID of the seat.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Integer seatId;

    /**
     * Represents the seat number.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Integer seatNumber;

    /**
     * Represents the availability status of the seat (booked or not).
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Boolean isBooked;
}
