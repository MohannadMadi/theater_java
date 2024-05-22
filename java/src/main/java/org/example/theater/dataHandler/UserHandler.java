package org.example.theater.dataHandler;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.theater.model.Session;
import org.example.theater.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserHandler {
    private static final String JSON_FILE = "C:\\Users\\mohan\\eclipse-workspace\\theater_project\\java\\src\\main\\java\\org\\example\\theater\\Users.json";
    private List<User> users;
    private int nextUid;

    public UserHandler() {
        loadUsers();
    }

    private void loadUsers() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(JSON_FILE);
        if (file.exists()) {
            try {
                users = mapper.readValue(file, new TypeReference<List<User>>() {});
           if (users.size()>0){
               nextUid=users.getLast().getUid()+1;
           }
           else {
               nextUid=1;
           }
            } catch (IOException e) {
                e.printStackTrace();
                users = new ArrayList<>();
            }
        } else {
            users = new ArrayList<>();
        }
        // Set nextUid to the highest uid + 1
     }

    public void signUp(User user) {
        if (user != null && user.getEmail() != null && !user.getEmail().isEmpty() &&
                user.getPassword() != null && !user.getPassword().isEmpty()) { // Perform null and empty checks
            // Check if a user with the same email already exists
            if (getUserByEmail(user.getEmail()) == null) {

                user.setUid(nextUid);
                
                users.add(user);

                saveUsers();
            } else {
                System.out.println("User with the same email already exists. Unable to sign up.");
            }
        } else {
            System.out.println("User object, email, or password is null or empty. Unable to sign up.");
        }
    }

    private User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null; // User with the specified email not found
    }


    public User signIn(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // User not found or password incorrect
    }

    private void saveUsers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(JSON_FILE), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void editUser(int userId, String name, String email, String password, List<Session> sessions) {
        Optional<User> optionalUser = users.stream().filter(user -> user.getUid() == userId).findFirst();
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setSelectedSessionsData(sessions);
            saveUsers(); // Save changes to the JSON file
        } else {
            System.out.println("User not found with userId: " + userId);
        }
    }
}
