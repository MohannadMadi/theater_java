package org.example.theater.model;


public class User {
    static int uid=0;
    String name;
    String email;
    String password;
    Seat[] ownedSeats;
    
    User(){
        uid++;
    }


    
}
