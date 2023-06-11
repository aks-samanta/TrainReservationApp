package com.TrainReservationApp.controllers;

import com.TrainReservationApp.dtos.CoachDto;
import com.TrainReservationApp.services.CoachServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coaches")
@CrossOrigin(origins = "*")

public class CoachController {

    @Autowired
    private CoachServices coachServices;

    /**
     * GET endpoint to retrieve coach information.
     * Returns ResponseEntity with the CoachDto containing coach details.
     */
    @GetMapping
    public ResponseEntity<CoachDto> getCoach() {
        CoachDto coachDto = coachServices.getCoach();
        return ResponseEntity.ok(coachDto);
    }
    
    /**
     * GET endpoint to retrieve coach information by coachId.
     * Accepts the coachId as a path variable.
     * Returns ResponseEntity with the CoachDto containing coach details.
     */
    @GetMapping("/{coachId}")
    public ResponseEntity<CoachDto> getCoachById(@PathVariable Integer coachId) {
        CoachDto coachDto = coachServices.getCoachById(coachId);
        return ResponseEntity.ok(coachDto);
    }

    /**
     * POST endpoint to create a new coach.
     * Returns ResponseEntity with the CoachDto of the newly created coach.
     */
    @PostMapping
    public ResponseEntity<CoachDto> createNewCoach() {
        CoachDto coachDto = coachServices.createNewCoach();
        return ResponseEntity.ok(coachDto);
    }
}
