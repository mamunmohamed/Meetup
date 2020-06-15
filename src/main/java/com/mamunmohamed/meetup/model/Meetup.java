package com.mamunmohamed.meetup.model;

import java.util.UUID;

public class Meetup {
    private UUID id;
    private String title;
    private String description;
    private String place;

    public Meetup(UUID id, String title, String description, String place) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.place = place;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Meetup{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
