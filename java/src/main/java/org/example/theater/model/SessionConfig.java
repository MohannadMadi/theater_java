package org.example.theater.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SessionConfig {
    private static final String DB_URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\Users\\mohan\\eclipse-workspace\\theater_project\\main\\src\\main\\java\\com\\theater\\model\\db.accdb";
    public static boolean signUp(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String checkUserQuery = "SELECT COUNT(*) FROM users WHERE Username = ?";
            PreparedStatement checkUserStmt = conn.prepareStatement(checkUserQuery);
            checkUserStmt.setString(1, username);
            ResultSet rs = checkUserStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                return false; // Username already exists
            }

            String insertUserQuery = "INSERT INTO Users (Username, Password) VALUES (?, ?)";
            PreparedStatement insertUserStmt = conn.prepareStatement(insertUserQuery);
            insertUserStmt.setString(1, username);
            insertUserStmt.setString(2, password);
            insertUserStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean signIn(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String query = "SELECT COUNT(*) FROM Users WHERE Username = ? AND Password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        // Connection URL
        String url = "jdbc:h2:~/test"; // This will create a database named "test" in the user's home directory
        String user = "sa"; // Default user
        String password = ""; // Default password is empty

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // Create table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS USERS (id INT PRIMARY KEY, name VARCHAR(255))";
            statement.execute(createTableSQL);

            // Insert data
            String insertSQL = "INSERT INTO USERS (id, name) VALUES (1, 'John Doe')";
            statement.execute(insertSQL);

            // Query data
            String selectSQL = "SELECT * FROM USERS";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
