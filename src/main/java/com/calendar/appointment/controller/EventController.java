package com.calendar.appointment.controller;

import com.calendar.appointment.dto.EventDto;
import com.calendar.appointment.model.Event;
import com.calendar.appointment.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@CrossOrigin("*")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/{userId}/create")
    private ResponseEntity<Event> createEvent(@RequestBody Event event, @PathVariable Long userId){
        Event createdEvent = eventService.createEvent(event, userId);
        return ResponseEntity.ok(createdEvent);
    }

    @GetMapping("/list")
    private ResponseEntity<List<Event>> getListEvents(){
        List<Event> eventList = eventService.getListEvent();
        return ResponseEntity.ok(eventList);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Event> getEventById(@PathVariable Long id){
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Event> updateEventById(@PathVariable Long id, @RequestBody EventDto eventDto){
        Event event = eventService.updateEvent(eventDto, id);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteEventById(@PathVariable Long id){
       eventService.deleteEvent(id);
        return ResponseEntity.ok("Event is deleted. ID: " + id);
    }
}
