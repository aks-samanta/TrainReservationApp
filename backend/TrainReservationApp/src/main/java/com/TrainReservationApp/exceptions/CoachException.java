package com.TrainReservationApp.exceptions;

/**
 * A custom runtime exception class for handling coach-related exceptions.
 */
public class CoachException extends RuntimeException {

    /**
     * Constructs a new instance of the CoachException class.
     */
    public CoachException() {    }

    /**
     * Constructs a new instance of the CoachException class with the specified error message.
     * @param message The error message associated with the exception.
     */
    public CoachException(String message) {
        super(message);
    }
}
