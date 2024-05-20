package org.example.theater.view.MoviesPage;

import org.example.theater.model.Movie;
import org.example.theater.model.Session;
import org.example.theater.model.User;
import org.example.theater.view.seatsPage.CinemaSeating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingPage extends JFrame {
    private String moviePoster;
    private String movieName;
    Movie movie;
    User user;

    public BookingPage(Movie movie, User user) {
        this.movie=movie;
        this.user=user;

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                ((JComponent) me.getSource()).setForeground(Color.YELLOW);
            }

            public void mouseExited(MouseEvent me) {
                ((JComponent) me.getSource()).setForeground(Color.WHITE);
            }
        };

        setTitle("Booking - " + movieName);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.DARK_GRAY);
        ImageIcon imageIcon = new ImageIcon(movie.getPosterUrl());
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel posterLabel = new JLabel(imageIcon);
        add(posterLabel, BorderLayout.WEST);

        // Title panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.BLACK);
        JLabel nameLabel = new JLabel("Movie: " + movie.getName(), SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE);
        titlePanel.add(nameLabel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        // Date and Time panel
        JPanel selectionPanel = new JPanel(new GridLayout(3, 1));
        selectionPanel.setBackground(Color.DARK_GRAY);

        // Date dropdown list
        JPanel datePanel = new JPanel();
        datePanel.setBackground(Color.DARK_GRAY);
        JLabel dateLabel = new JLabel("Select Date:");
        dateLabel.setForeground(Color.WHITE);
        String[] dates=new String[movie.getSessions().size()];
        for (int i = 0; i < movie.getSessions().size(); i++) {
            dates[i]=movie.getSessions().get(i).getDateTime();
        }

        JComboBox<String> dateComboBox = new JComboBox<>(dates);
        dateComboBox.setBackground(Color.DARK_GRAY);
        dateComboBox.setForeground(Color.WHITE);
        dateComboBox.setBorder(null);
        datePanel.add(dateLabel);
        datePanel.add(dateComboBox);
        selectionPanel.add(datePanel);

        // Time dropdown list


        // Confirmation button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.DARK_GRAY);
        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.setBackground(Color.darkGray);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setBorder(null);
        confirmButton.addMouseListener(mouseListener);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date=(String)dateComboBox.getSelectedItem();
                System.err.println(date);
                Session session=new Session();
                for (Session obj : movie.getSessions()) {
                    if (obj.getDateTime() == date) {
                        session=obj;
                    }
                }
                new CinemaSeating(movie, user, session);

                dispose();
            }
        });

        buttonPanel.add(confirmButton);
        buttonPanel.setPreferredSize(new Dimension(200, 100));
        selectionPanel.add(buttonPanel);
        add(selectionPanel, BorderLayout.CENTER);

        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.BLACK);
        JLabel footerLabel = new JLabel("© 2024 All Rights Reserved", SwingConstants.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

     }

