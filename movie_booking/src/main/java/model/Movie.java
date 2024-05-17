package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.ImageIcon;

class Session{
    LocalDateTime dateTimes;
    Seat[] seats=new Seat[110];

    public Session(LocalDateTime dateTimes) {
        this.dateTimes = dateTimes;
    }
}

public class Movie {
    private static int id;
    private String name;
    private String details;
    private ImageIcon poster;
    private Session[] sessions;

    public Movie(String name, String details, ImageIcon poster, Session[] sessions) {
        this.name = name;
        this.details = details;
        this.poster = poster;
        this.sessions = sessions;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Movie.id = id;
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

    public ImageIcon getPoster() {
        return poster;
    }

    public void setPoster(ImageIcon poster) {
        this.poster = poster;
    }

    public Session[] getSessions() {
        return sessions;
    }

    public void setSessions(Session[] sessions) {
        this.sessions = sessions;
    }
Movie[] movies={new Movie("\"src\\\\theater_project\\\\assets\\\\\\\\Media\\\\\\\\ghost_busters.jpg\"", "Adventure | Comedy | Sci-Fi", new ImageIcon("src\\\\theater_project\\\\assets\\\\\\\\Media\\\\\\\\ghost_busters.jpg"), new Session[]{new Session(LocalDateTime.of(2024, 8, 1, 8, 0, 0))})};

}

