package org.example.theater.view.MoviesPage;

import org.example.theater.dataHandler.MovieHandler;
import org.example.theater.model.Movie;
import org.example.theater.model.User;

import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;

public class MoviePosterGrid {
    public MoviePosterGrid(User user) {
        JFrame frame = new JFrame();
        frame.setTitle("Movies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.black);
        mainPanel.setBorder(null);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.black);
        headerPanel.setBorder(null);
        JLabel titleLabel = new JLabel("Movies");
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Movie panel
        JPanel moviePostersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        moviePostersPanel.setBackground(Color.darkGray);
        moviePostersPanel.setBorder(null);

        // Scroll bar
        JScrollPane scrollPane = new JScrollPane(moviePostersPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        int width = 240;
        int height = 343;

        MouseListener movieClickListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel clickedLabel = (JLabel)e.getSource();
                Integer movieId = (Integer) clickedLabel.getClientProperty("id");
                MovieHandler movieHandler=new MovieHandler();
                Movie movie=movieHandler.getMovieById(movieId);
                System.out.println(movie.getId());
                new BookingPage(movie,user);
            }
        };
        addMovies(moviePostersPanel,width,height,movieClickListener);
        // Movie 1a
        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.black);
        footerPanel.setBorder(null);
        JLabel footerLabel = new JLabel("© 2024 All Rights Reserved");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
    }

    private static void addMovies(JPanel panel, int width, int height, MouseListener listener) {
        MovieHandler movieHandler=new MovieHandler();
        for (int i = 0; i <movieHandler.getMovies().size() ; i++) {
            Movie currentMovie=movieHandler.getMovies().get(i);
            ImageIcon imageIcon = new ImageIcon(currentMovie.getPosterUrl());
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            label.addMouseListener(listener);
            label.putClientProperty("title", currentMovie.getName());
            label.putClientProperty("id",currentMovie.getId());

            JPanel moviePanel = new JPanel(new BorderLayout());
            moviePanel.add(label, BorderLayout.NORTH);

            JPanel textPanel = new JPanel(new GridLayout(2, 1));
            JLabel titleLabel = new JLabel(currentMovie.getName());
            JLabel genreLabel = new JLabel(currentMovie.getDetails());
            textPanel.add(titleLabel);
            textPanel.add(genreLabel);
            moviePanel.add(textPanel, BorderLayout.CENTER);
            panel.add(moviePanel);
        }

    }

}
