package com.calendar.appointment.dto;

import com.calendar.appointment.model.Rating;
import com.calendar.appointment.model.User;
import lombok.Data;

import java.util.List;

@Data
public class EventDto {


    private Long id;

    private String eventName;

    private String eventLocation;

    private String eventDetails;

    private String eventDate;

    private String attendeeEmails;

    private String eventMessage;

    List<Rating> ratingList;

    private User user;
}
