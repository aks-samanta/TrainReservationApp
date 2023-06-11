package com.TrainReservationApp.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class CoachDto {

    /**
     * Represents the ID of the coach.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Integer coachId;

    /**
     * Represents the total number of seats in the coach.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Integer totalSeats;

    /**
     * Represents the number of available seats in the coach.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private Integer availableSeats;

    /**
     * Represents the list of SeatDto objects associated with the coach.
     * This property is marked as read-only and will not be included during serialization/deserialization.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private List<SeatDto> seats;
}
