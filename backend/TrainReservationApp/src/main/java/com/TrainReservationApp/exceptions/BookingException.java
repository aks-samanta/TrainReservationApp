package com.TrainReservationApp.exceptions;

/**
 * A custom runtime exception class for handling booking-related exceptions.
 */
public class BookingException extends RuntimeException {

    /**
     * Constructs a new instance of the BookingException class.
     */
    public BookingException() {    }

    /**
     * Constructs a new instance of the BookingException class with the specified error message.
     * @param message The error message associated with the exception.
     */
    public BookingException(String message) {
        super(message);
    }
}
