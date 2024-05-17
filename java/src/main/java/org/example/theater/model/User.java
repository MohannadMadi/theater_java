package org.example.theater.model;


public class User {
    private static int uid;
    private String name;
    private String email;
    private String password;
    private Session[] ownedSeats;
User(){}
    public User(String name, String email, String password, Session[] ownedSeats) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ownedSeats = ownedSeats;
    }


    public  int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        User.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Session[] getOwnedSeats() {
        return ownedSeats;
    }

    public void setOwnedSeats(Session[] ownedSeats) {
        this.ownedSeats = ownedSeats;
    }
}
