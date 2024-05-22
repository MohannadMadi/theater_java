package org.example.theater.view.loginPage;

import org.apache.commons.lang.SystemUtils;
import org.example.theater.dataHandler.UserHandler;
import org.example.theater.model.Movie;
import org.example.theater.model.Session;
import org.example.theater.model.User;
import org.example.theater.view.seatsPage.CinemaSeating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LoginPage implements ActionListener{

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton SignupButton = new JButton("Sign up");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Email:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel();
    JButton exitButton = new JButton("Exit");
    JLabel titleLabel = new JLabel("Login Page");

Movie movie;
Session session;
    public LoginPage(Movie movie,Session session){
        this.movie = movie; // Assigning movie parameter to class variable
        this.session = session;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        titleLabel.setBounds(180, 10, 150, 25);
        titleLabel.setFont(new Font(null, Font.BOLD, 20));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        SignupButton.setBounds(225,200,100,25);
        SignupButton.setFocusable(false);
        SignupButton.addActionListener(this);

        exitButton.setBounds(350, 10, 60, 25);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);


        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(SignupButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(exitButton);
        frame.add(titleLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== SignupButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if (!userID.isEmpty()&&!password.isEmpty()){
                UserHandler userHandler=new UserHandler();
            List<Session> forms= Arrays.asList();
                User user=new User("",userID,password,Arrays.asList(new Session(session.getId(), movie.getId(), session.getDateTime(),new ArrayList<>(110))));
                userHandler.signUp(user);
                new CinemaSeating(movie,user,session );
                frame.dispose();
            }else {
                JOptionPane.showMessageDialog(this.frame, "error signing up, please fill in your data"   ,"", JOptionPane.ERROR_MESSAGE);

            }
        }

        if(e.getSource()==loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            UserHandler userHandler=new UserHandler();
            
            User user=userHandler.signIn(userID,password);
             if (user!=null){
                if (user.getSessionById(session)==null) {
                    user.getSelectedSessionsData().add(new Session(session.getId(),session.getMovieId(),session.getDateTime(),new ArrayList<>(110)));
                    System.err.println(user.getSessionById(session).getId());
                }
                new CinemaSeating(movie,user,session);
                frame.dispose();

            }
            else {
                JOptionPane.showMessageDialog(this.frame, "error logging in, please use correct credentials"   ,"", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource()==exitButton) {

                frame.dispose();

        }
    }
}
