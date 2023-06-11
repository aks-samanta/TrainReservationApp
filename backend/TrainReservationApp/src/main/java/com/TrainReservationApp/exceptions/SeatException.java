package com.TrainReservationApp.exceptions;

/**
 * A custom runtime exception class for handling seat-related exceptions.
 */
public class SeatException extends RuntimeException {

    /**
     * Constructs a new instance of the SeatException class.
     */
    public SeatException() {    }

    /**
     * Constructs a new instance of the SeatException class with the specified error message.
     * @param message The error message associated with the exception.
     */
    public SeatException(String message) {
        super(message);
    }
}
