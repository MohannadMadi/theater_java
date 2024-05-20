package org.example.theater.model;

import java.util.List;

public class Session {
    int id;
    int movieId;
    private String dateTime;
    private List<Integer> takenSeatIds;

    


    public Session() {
    }

    public Session(int id, int movieId, String dateTime, List<Integer> takenSeatIds) {
        this.id = id;
        this.movieId = movieId;
        this.dateTime = dateTime;
        this.takenSeatIds = takenSeatIds;
    }


    // Getters and setters
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<Integer> getTakenSeatIds() {
 
        return takenSeatIds;
    }

    public void setTakenSeatIds(List<Integer> takenSeatIds) {
        this.takenSeatIds = takenSeatIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
