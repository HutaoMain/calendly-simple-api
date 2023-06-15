package com.calendar.appointment.dto;

import com.calendar.appointment.model.Event;
import lombok.Data;

@Data
public class RatingDto {

    private Long id;

    private Float rate;

    private String review;

    private Event event;
}
