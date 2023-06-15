package com.calendar.appointment.service;

import com.calendar.appointment.dto.EventDto;
import com.calendar.appointment.model.Event;
import com.calendar.appointment.model.User;
import com.calendar.appointment.repository.EventRepository;
import com.calendar.appointment.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    public Event createEvent(Event event, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            event.setUser(user);
            eventRepository.save(event);
        } else {
            log.warn("there is no user with this ID: {}", userId);
        }
        return event;
    }

    public List<Event> getListEvent() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event updateEvent(EventDto eventDto, Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            if (eventDto.getEventName() != null) {
                event.setEventName(eventDto.getEventName());
            }

            if (eventDto.getEventLocation() != null) {
                event.setEventLocation(eventDto.getEventLocation());
            }

            if (eventDto.getEventDetails() != null) {
                event.setEventDetails(eventDto.getEventDetails());
            }

            if (eventDto.getEventDate() != null) {
                event.setEventDate(eventDto.getEventDate());
            }

            if (eventDto.getAttendeeEmails() != null) {
                event.setAttendeeEmails(eventDto.getAttendeeEmails());
            }

            if (eventDto.getEventMessage() != null) {
                event.setEventMessage(eventDto.getEventMessage());
            }

            eventRepository.save(event);
        }
        return event;
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
