package org.example.theater.view.MoviesPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoviePosterGrid {
    public MoviePosterGrid() {}

    public static void main(String[] args) {
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
                ImageIcon moviePoster = (ImageIcon) clickedLabel.getIcon();
                String movieName = (String) clickedLabel.getClientProperty("title");
                new BookingPage(moviePoster, movieName);
            }
        };

        // Movie 1
        addMovie(moviePostersPanel, "src\\theater_project\\assets\\\\Media\\\\ghost_busters.jpg", "Ghost Busters", "Adventure | Comedy | Sci-Fi", width, height, movieClickListener);
        // Movie 2
        addMovie(moviePostersPanel, "src\\theater_project\\assets\\\\images\\\\GODZILLA_X_KONG.jpg", "Godzilla vs Kong", "Action | Sci-Fi | Thriller", width, height, movieClickListener);
        // Movie 3
        addMovie(moviePostersPanel, "src\\theater_project\\assets\\Media\\kingdom_of_planets_of_apes.jpg", "Planet of the Apes", "Action | Adventure | Sci-Fi", width, height, movieClickListener);
        // Movie 4
        addMovie(moviePostersPanel, "src\\theater_project\\assets\\\\Media\\\\LAND_OF_BAD.jpg", "Land of Bad", "Action | Thriller", width, height, movieClickListener);
        // Movie 5
        addMovie(moviePostersPanel,"src\\theater_project\\assets\\\\Media\\\\Escape.jpg","Escape","Thriller",width,height,movieClickListener);
        // Movie 6
        addMovie(moviePostersPanel,"src\\theater_project\\assets\\\\Media\\\\The_first_omen.jpg","The First Omen","Horror",width,height,movieClickListener);
        // Movie 7
        addMovie(moviePostersPanel,"src\\theater_project\\assets\\\\Media\\\\Kung_Fu_panda_4.jpg","Kung Fu Panda 4","Animation",width,height,movieClickListener);
        // Movie 8
        addMovie(moviePostersPanel,"src\\theater_project\\assets\\\\Media\\\\3almashi.jpg","3ALMASHI","Thriller",width,height,movieClickListener);


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

    private static void addMovie(JPanel panel, String imagePath, String title, String genre, int width, int height, MouseListener listener) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(imageIcon);
        label.addMouseListener(listener);
        label.putClientProperty("title", title);
        JPanel moviePanel = new JPanel(new BorderLayout());
        moviePanel.add(label, BorderLayout.NORTH);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel(title);
        JLabel genreLabel = new JLabel(genre);
        textPanel.add(titleLabel);
        textPanel.add(genreLabel);
        moviePanel.add(textPanel, BorderLayout.CENTER);

        panel.add(moviePanel);
    }
}
