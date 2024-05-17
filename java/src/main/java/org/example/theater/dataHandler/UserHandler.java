package org.example.theater.dataHandler;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.theater.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            } catch (IOException e) {
                e.printStackTrace();
                users = new ArrayList<>();
            }
        } else {
            users = new ArrayList<>();
        }
        // Set nextUid to the highest uid + 1
        nextUid = users.stream().mapToInt(User::getUid).max().orElse(0) + 1;
    }

    public void signUp(User user) {
        if (user != null && user.getEmail() != null && !user.getEmail().isEmpty() &&
                user.getPassword() != null && !user.getPassword().isEmpty()) { // Perform null and empty checks
            // Check if a user with the same email already exists
            if (getUserByEmail(user.getEmail()) == null) {
                user.setUid(nextUid++);
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
}
