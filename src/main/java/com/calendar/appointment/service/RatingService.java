package com.calendar.appointment.service;

import com.calendar.appointment.dto.RatingDto;
import com.calendar.appointment.model.Event;
import com.calendar.appointment.model.Rating;
import com.calendar.appointment.repository.EventRepository;
import com.calendar.appointment.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    EventRepository eventRepository;

    public Rating createRating(Rating rating, Long eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            rating.setEvent(event);
            ratingRepository.save(rating);
        } else {
            log.warn("there is no user with this ID: {}", eventId);
        }
        return rating;
    }

    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    public List<Rating> getRatingList() {
        return ratingRepository.findAll();
    }

    public Rating updateRating(RatingDto ratingDto, Long id) {
        Rating rating = ratingRepository.findById(id).orElse(null);
        if (rating != null) {
            if (ratingDto.getRate() != null) {
                rating.setRate(ratingDto.getRate());
            }

            if (ratingDto.getEvent() != null) {
                rating.setEvent(ratingDto.getEvent());
            }

            if (ratingDto.getReview() != null) {
                rating.setReview(ratingDto.getReview());
            }

            ratingRepository.save(rating);
        }
        return rating;
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
