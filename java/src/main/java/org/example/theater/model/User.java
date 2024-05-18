package org.example.theater.model;


import java.util.ArrayList;
import java.util.List;

public class User {
    private   int uid;
    private String name;
    private String email;
    private String password;
    List<Session> selectedSessionsData;

User(){}

    public User( String name, String email, String password, List<Session> selectedSessionsData) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.selectedSessionsData = selectedSessionsData;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public List<Session> getSelectedSessionsData() {
        return selectedSessionsData;
    }

    public void setSelectedSessionsData(List<Session> selectedSessionsData) {
        this.selectedSessionsData = selectedSessionsData;
    }

    public Session getSessionById(Session session) {
        // Iterate through the sessions array
        for (Session s : selectedSessionsData) {
            // Check if the session ID matches the specified session ID
            if (s.getId() == session.getId()&&s.getMovieId()== session.getMovieId()) {
                return s; // Return the session if found
            }
        }
        return null; // Return null if session with the specified ID is not found
    }
    public void editSessions(Session newSession,List<Integer> newSeats) {
        // Iterate through the list of selected sessions
        int index=0;
        for (int i = 0; i < selectedSessionsData.size(); i++) {
            Session session = selectedSessionsData.get(i);
            // Check if the session exists based on movieId and sessionId
            if (session.getMovieId() == newSession.getMovieId() && session.getId() == newSession.getId()) {
                // Replace the existing session with the new session

                selectedSessionsData.get(i).setTakenSeatIds(newSeats);

            break;
            }
        }


        // If the session does not exist, add the new sessionnew

//
//        newSession.setTakenSeatIds(new ArrayList<>(110));
//        selectedSessionsData.add(newSession);
    }
}
