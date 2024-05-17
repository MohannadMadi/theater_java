package org.example.theater.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.ImageIcon;

 
 
public class Movie {


    private  int id;
    private String name;
    private String details;
    private String posterUrl;
    private Session[] sessions;

    public Movie(){
        id++;
    }
    public Movie(String name, String details, String poster, Session[] sessions) {
        this.name = name;
        this.details = details;
        this.posterUrl = poster;
        this.sessions = sessions;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPoster(String poster) {
        this.posterUrl = poster;
    }

    public Session[] getSessions() {
        return sessions;
    }

    public void setSessions(Session[] sessions) {
        this.sessions = sessions;
}

}
