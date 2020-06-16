package com.mamunmohamed.meetup.dao;

import com.mamunmohamed.meetup.model.Meetup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccess implements MeetupDao {

    private static List<Meetup> meetups = new ArrayList<>();


    @Override
    public int insertPerson(UUID id, Meetup meetup) {
        meetups.add(new Meetup(id,meetup.getTitle(),meetup.getDescription(),meetup.getPlace()));
        return 1;
    }

    @Override
    public List<Meetup> getMeetups() {
        return meetups;
    }

    @Override
    public Optional<Meetup> getMeetupById(UUID id) {
        return meetups.stream()
                .filter(meetup -> meetup.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteMeetupById(UUID id) {
        Optional<Meetup> meetupMaybe = getMeetupById(id);
        if (!meetupMaybe.isPresent()){
            return 0;
        }

        meetups.remove(meetupMaybe.get());
        return 1;
    }

    @Override
    public int updateMeetUpById(UUID id, Meetup updateMeetup) {
        return getMeetupById(id)
                .map(meetup -> {
                    int indexOfMeetupToUpdate = meetups.indexOf(meetup);
                    if (indexOfMeetupToUpdate >= 0){
                        meetups.set(indexOfMeetupToUpdate,new Meetup(id,
                                updateMeetup.getTitle(),
                                updateMeetup.getDescription(),
                                updateMeetup.getPlace()));
                        return 1;
                    }

                    return 0;
                }).orElse(0);


    }
}
