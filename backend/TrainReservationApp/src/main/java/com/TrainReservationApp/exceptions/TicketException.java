package com.TrainReservationApp.exceptions;

/**
 * A custom runtime exception class for handling ticket-related exceptions.
 */
public class TicketException extends RuntimeException {

    /**
     * Constructs a new instance of the TicketException class.
     */
    public TicketException() {    }

    /**
     * Constructs a new instance of the TicketException class with the specified error message.
     * @param message The error message associated with the exception.
     */
    public TicketException(String message) {
        super(message);
    }
}
