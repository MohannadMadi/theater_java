package org.example.theater.model;

public class Seat {
    private int id;
    private boolean taken;

    public Seat(int id, boolean taken) {
        this.id = id;
        this.taken = taken;
    }

    public int getId() {
        return id;
    }

    public boolean isTaken() {
        return taken;
    }
}
