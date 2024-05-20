package org.example.theater.view.checkout;

import org.example.theater.dataHandler.MovieHandler;
import org.example.theater.dataHandler.UserHandler;
import org.example.theater.model.Movie;
import org.example.theater.model.Session;
import org.example.theater.model.User;
import org.example.theater.view.MoviesPage.MoviePosterGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Checkout extends JFrame {
    private JLabel priceLabel;
    private JLabel firstClassLabel;
    private JLabel secondClassLabel;
    private JLabel thirdClassLabel;
    private JButton checkoutButton;

    public static double calculateCost(int firstClassSeats, int secondClassSeats, int thirdClassSeats) {
        final double FIRST_CLASS_COST = 50.0;
        final double SECOND_CLASS_COST = 15.0;
        final double THIRD_CLASS_COST = 10.0;

        double totalPrice = (firstClassSeats * FIRST_CLASS_COST) +
                (secondClassSeats * SECOND_CLASS_COST) +
                (thirdClassSeats * THIRD_CLASS_COST);

        return totalPrice;
    }

    MouseListener mouseListener = new MouseAdapter() {
        public void mouseEntered(MouseEvent me) {
            ((JComponent) me.getSource()).setForeground(Color.YELLOW);
        }

        public void mouseExited(MouseEvent me) {
            ((JComponent) me.getSource()).setForeground(Color.WHITE);
        }
    };

    public Checkout(double totalPrice, int firstClassSeats, int secondClassSeats, int thirdClassSeats, Movie movie, User user, Session session, List<Integer> newSeats,List<Integer> cancelled) {
        setTitle("Checkout Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents(totalPrice, firstClassSeats, secondClassSeats, thirdClassSeats, movie, user, session, newSeats,cancelled);
    }

    private void initComponents(double totalPrice, int firstClassSeats, int secondClassSeats, int thirdClassSeats, Movie movie, User user, Session session, List<Integer> newSeats, List<Integer> cancelled) {
        priceLabel = new JLabel("Total Price: $" + totalPrice);
        priceLabel.setForeground(Color.WHITE);
        firstClassLabel = new JLabel("First Class Seats: " + firstClassSeats);
        firstClassLabel.setForeground(Color.WHITE);
        secondClassLabel = new JLabel("Second Class Seats: " + secondClassSeats);
        secondClassLabel.setForeground(Color.WHITE);
        thirdClassLabel = new JLabel("Third Class Seats: " + thirdClassSeats);
        thirdClassLabel.setForeground(Color.WHITE);
        checkoutButton = new JButton("Checkout");
        checkoutButton.setBackground(Color.DARK_GRAY);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBorder(null);
        checkoutButton.addMouseListener(mouseListener);

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserHandler userHandler = new UserHandler();


                Set<Integer> set = new HashSet<>(newSeats);
                List<Integer> listWithoutDuplicates = new ArrayList<>(set);
                newSeats.clear();
                newSeats.addAll(listWithoutDuplicates);
                user.editSessions(session,newSeats);
                userHandler.editUser(user.getUid(), user.getName(), user.getEmail(), user.getPassword(), user.getSelectedSessionsData());

                MovieHandler movieHandler = new MovieHandler();
 
                session.getTakenSeatIds().addAll(newSeats);
                session.getTakenSeatIds().removeAll(cancelled);


                Set<Integer> set2= new HashSet<>(session.getTakenSeatIds());
                List<Integer> listWithoutDuplicates2 = new ArrayList<>(set2);
                session.getTakenSeatIds().clear();
                session.getTakenSeatIds().addAll(listWithoutDuplicates2);
                movieHandler.editSessionInMovie(session);

                new MoviePosterGrid(user);
                dispose();
            }
        });

        setLayout(new GridLayout(5, 1));
        add(firstClassLabel);
        add(secondClassLabel);
        add(thirdClassLabel);
        add(priceLabel);
        add(checkoutButton);

        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
    }
}
