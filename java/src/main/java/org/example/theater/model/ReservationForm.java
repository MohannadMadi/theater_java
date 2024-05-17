package org.example.theater.model;


import java.time.LocalDateTime;
import java.util.List;

public class ReservationForm {
    int movieId;
    List<Session> selectedSessionsData;


    public ReservationForm(int movieId, List<Session> selectedSessionsData) {
        this.movieId = movieId;
        this.selectedSessionsData = selectedSessionsData;
    }
ReservationForm(){}
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public List<Session> getSelectedSessionsData() {
        return selectedSessionsData;
    }

    public void setSelectedSessionsData(List<Session> selectedSessionsData) {
        this.selectedSessionsData = selectedSessionsData;
    }
}
