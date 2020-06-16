package com.mamunmohamed.meetup.service;

import com.mamunmohamed.meetup.dao.MeetupDao;
import com.mamunmohamed.meetup.model.Meetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MeetupService {
    private final MeetupDao meetupDao;

    @Autowired
    public MeetupService(@Qualifier("fakeDao") MeetupDao meetupDao) {
        this.meetupDao = meetupDao;
    }


    public int addMeetup(Meetup meetup){
        return meetupDao.insertPerson(meetup);
    }

    public List<Meetup> getAllMeetups(){
        return meetupDao.getMeetups();
    }

    public Optional<Meetup> getMeetupById(UUID id){
        return meetupDao.getMeetupById(id);
    }

    public int deleteMeetup(UUID id){
        return meetupDao.deleteMeetupById(id);
    }

    public int updateMeetup(UUID id, Meetup meetup){
        return meetupDao.updateMeetUpById(id,meetup);
    }

}
