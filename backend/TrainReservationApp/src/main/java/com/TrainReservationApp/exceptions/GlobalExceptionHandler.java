package com.TrainReservationApp.exceptions;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Exception handler for CoachException.
	 * Handles the CoachException and returns a ResponseEntity with the corresponding ProblemDetail.
	 */
	@ExceptionHandler(CoachException.class)
	public ResponseEntity<ProblemDetail> coachExceptionHandler(CoachException coachException, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, coachException.getMessage());
		problemDetail.setType(URI.create(request.getContextPath()));
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.of(Optional.of(problemDetail));
	}
	
	/**
	 * Exception handler for BookingException.
	 * Handles the BookingException and returns a ResponseEntity with the corresponding ProblemDetail.
	 */
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<ProblemDetail> bookingExceptionHandler(BookingException bookingException, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, bookingException.getMessage());
		problemDetail.setType(URI.create(request.getContextPath()));
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.of(Optional.of(problemDetail));
	}
	
	/**
	 * Exception handler for SeatException.
	 * Handles the SeatException and returns a ResponseEntity with the corresponding ProblemDetail.
	 */
	@ExceptionHandler(SeatException.class)
	public ResponseEntity<ProblemDetail> seatExceptionHandler(SeatException seatException, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, seatException.getMessage());
		problemDetail.setType(URI.create(request.getContextPath()));
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.of(Optional.of(problemDetail));
	}

	/**
	 * Generic exception handler.
	 * Handles any other exceptions that are not specifically handled by other exception handlers.
	 * Returns a ResponseEntity with the corresponding ProblemDetail.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ProblemDetail> anyExceptionHandler(Exception anyException, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, anyException.getMessage());
		problemDetail.setType(URI.create(request.getContextPath()));
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.of(Optional.of(problemDetail));
	}

	/**
	 * Exception handler for MethodArgumentNotValidException.
	 * Handles the MethodArgumentNotValidException and returns a ResponseEntity with the validation errors as a Map.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
		Map<String, String> response = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String field = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			response.put(field, message);
		});
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Exception handler for NoHandlerFoundException.
	 * Handles the NoHandlerFoundException and returns a ResponseEntity with the corresponding ProblemDetail.
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ProblemDetail> notFoundHandler(NoHandlerFoundException noHandlerFoundException, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, noHandlerFoundException.getMessage());
		problemDetail.setType(URI.create(request.getContextPath()));
		problemDetail.setInstance(URI.create(request.getContextPath()));
		return ResponseEntity.of(Optional.of(problemDetail));
	}

}
