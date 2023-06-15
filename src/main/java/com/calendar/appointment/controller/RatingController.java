package com.calendar.appointment.controller;

import com.calendar.appointment.dto.RatingDto;
import com.calendar.appointment.model.Event;
import com.calendar.appointment.model.Rating;
import com.calendar.appointment.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
@CrossOrigin("*")
public class RatingController {

    @Autowired
    RatingService ratingService;


    @PostMapping("/{eventId}/create")
    private ResponseEntity<Rating> createRating(@RequestBody Rating rating, @PathVariable Long eventId) {
        Rating createdRating = ratingService.createRating(rating, eventId);
        return ResponseEntity.ok(createdRating);
    }

    @GetMapping("/list")
    private ResponseEntity<List<Rating>> getRatingList() {
        List<Rating> ratingList = ratingService.getRatingList();
        return ResponseEntity.ok(ratingList);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
        Rating rating = ratingService.getRatingById(id);
        return ResponseEntity.ok(rating);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Rating> updateRatingById(@RequestBody RatingDto ratingDto, @PathVariable Long id) {
        Rating rating = ratingService.updateRating(ratingDto, id);
        return ResponseEntity.ok(rating);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteRatingById(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.ok("Deleted Rating with ID: " + id);
    }
}
