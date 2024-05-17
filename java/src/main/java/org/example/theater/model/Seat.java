package org.example.theater.model;


import java.time.LocalDateTime;

public class Seat {
    int id=0;
    
    User owner;
    Movie movie;
    boolean available;
    double price;
    LocalDateTime sLocalDateTime;
    Seat(){
        id++;
    }
}
