package main.java.com.theater.model;


import java.time.LocalDateTime;

import model.Seat;

public class Session {
       LocalDateTime dateTimes;
    Seat[] seats=new Seat[110];

    public Session(LocalDateTime dateTimes) {
        this.dateTimes = dateTimes;
    }
}
