package com.mamunmohamed.meetup.dao;

import com.mamunmohamed.meetup.model.Meetup;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MeetupDao {

     int insertPerson(UUID id, Meetup meetup);

     default int insertPerson(Meetup meetup){
         UUID id = UUID.randomUUID();
         return insertPerson(id,meetup);
     }

     List<Meetup> getMeetups();

     Optional<Meetup> getMeetupById(UUID id);

     int deleteMeetupById(UUID id);

     int updateMeetUpById(UUID id, Meetup meetup);
}
