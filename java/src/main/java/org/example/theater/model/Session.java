package org.example.theater.model;


import java.time.LocalDateTime;


public class Session {
    static int id=0;
    LocalDateTime dateTimes;
    Seat[] seats=new Seat[110];
    public Session(){
        id++;
    }
    public Session(LocalDateTime dateTimes) {
        this.dateTimes = dateTimes;
        id++;
    }
}
