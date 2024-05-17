package org.example.theater.model;

import java.util.List;

public class Session {
    private String dateTime;
    private List<Integer> takenSeatIds;

    public Session() {
    }

    public Session(String dateTime, List<Integer> takenSeatIds) {
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
}
