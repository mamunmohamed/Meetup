package com.mamunmohamed.meetup.controller;

import com.mamunmohamed.meetup.model.Meetup;
import com.mamunmohamed.meetup.service.MeetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/meetups")
@RestController
public class MeetupController {

    private final MeetupService meetupService;

    @Autowired
    public MeetupController(MeetupService meetupService) {
        this.meetupService = meetupService;
    }

    @PostMapping(value = "/insert",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMeetup(@RequestBody Meetup meetup){
        meetupService.addMeetup(meetup);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meetup> getAllMeetups(){
        return meetupService.getAllMeetups();
    }

    @GetMapping(value = "/getMeetupById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Meetup getMeetupById(@PathVariable("id") UUID id){
        return meetupService.getMeetupById(id)
                .orElse(null);
    }

    @DeleteMapping(value = "/deleteMeetupById/{id}")
    public void deleteMeetupById(@PathVariable("id") UUID id){
        meetupService.deleteMeetup(id);
    }

    @PutMapping(value = "/updateMeetupById/{id}")
    public void updateMeetupById(@PathVariable UUID id,@RequestBody Meetup meetup){
        meetupService.updateMeetup(id,meetup);
    }


}
