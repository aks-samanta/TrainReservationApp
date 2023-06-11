package com.TrainReservationApp.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class BookingDto {

    private Integer coachId;

    /**
     * Represents the number of seats to be booked.
     * Must be between 1 and 7 (inclusive).
     */
    @Max(value = 7, message = "Sorry, you can't book more than 7 tickets at a time!!")
    @Min(value = 1, message = "Please choose a valid number of tickets to book !!")
    private Integer noOfSeats;
}
