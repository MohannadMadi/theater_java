package org.example.theater.model;

import java.time.LocalDateTime;
import java.util.List;

public class Session {
    private LocalDateTime dateTime;
    private List<Integer> takenSeatIds;

    public Session() {
    }

    public Session(LocalDateTime dateTime, List<Integer> takenSeatIds) {
        this.dateTime = dateTime;
        this.takenSeatIds = takenSeatIds;
    }

    // Getters and setters
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Integer> getTakenSeatIds() {
        return takenSeatIds;
    }

    public void setTakenSeatIds(List<Integer> takenSeatIds) {
        this.takenSeatIds = takenSeatIds;
    }
}
