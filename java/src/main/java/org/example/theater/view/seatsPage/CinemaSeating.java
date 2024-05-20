package org.example.theater.view.seatsPage;

import org.example.theater.model.Movie;
import org.example.theater.model.Session;
import org.example.theater.model.User;
import org.example.theater.view.MoviesPage.MoviePosterGrid;
import org.example.theater.view.checkout.Checkout;
import org.example.theater.view.loginPage.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.theater.view.checkout.Checkout.calculateCost;

public class CinemaSeating extends JFrame {

    private static final int FIRST_CLASS_ROWS = 4;
    private static final int FIRST_CLASS_COLS = 5;
    private static final int SECOND_CLASS_ROWS = 8;
    private static final int SECOND_CLASS_COLS = 5;
    private static final int THIRD_CLASS_ROWS = 10;
    private static final int THIRD_CLASS_COLS = 5;

    User user;
    Movie movie;
    Session session;

    List<Integer> pickedSeats = new ArrayList<>(110);
    List<Integer> canceledSeats = new ArrayList<>(110);

    public CinemaSeating(Movie movie, User user, Session session) {
        this.session = session;
        this.movie = movie;
        this.user = user;

        if (user != null) {
            System.err.println("in if "+user.getSessionById(session).getDateTime());
            pickedSeats =  user.getSessionById(session).getTakenSeatIds();

        }

        setTitle("Cinema Seating");
        setSize(800, 1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // setResizable(false);` // Disable resizing
        setMinimumSize(new Dimension(400, 1100));
        setVisible(true);

        // Screen Panel
        JPanel screenPanel = new JPanel(new GridBagLayout());
        screenPanel.setBackground(Color.CYAN);
        screenPanel.setPreferredSize(new Dimension(800, 50));
        JLabel screenLabel = new JLabel("SCREEN");
        screenLabel.setForeground(Color.BLACK);
        screenPanel.add(screenLabel);

        // Main Seats Panel
        JPanel mainSeatsPanel = new JPanel();
        mainSeatsPanel.setLayout(new BoxLayout(mainSeatsPanel, BoxLayout.Y_AXIS));
        mainSeatsPanel.setBackground(Color.DARK_GRAY);

        // First Class Panel
        JPanel firstClassPanel = createClassPanel("First Class", FIRST_CLASS_ROWS, FIRST_CLASS_COLS);
        mainSeatsPanel.add(firstClassPanel);

        // Second Class Panel
        JPanel secondClassPanel = createClassPanel("Second Class", SECOND_CLASS_ROWS, SECOND_CLASS_COLS);
        mainSeatsPanel.add(Box.createVerticalStrut(20));
        mainSeatsPanel.add(secondClassPanel);

        // Third Class Panel
        JPanel thirdClassPanel = createClassPanel("Third Class", THIRD_CLASS_ROWS, THIRD_CLASS_COLS);
        mainSeatsPanel.add(Box.createVerticalStrut(20));
        mainSeatsPanel.add(thirdClassPanel);

        // Reset and Checkout Buttons
        JButton resetButton = new JButton("Reset");
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setPreferredSize(new Dimension(100, 30));
        checkoutButton.addActionListener(e -> {
            if (user != null) {
                int firstClassSeats = 0;
                int secondClassSeats = 0;
                int thirdClassSeats = 0;

                for (int seatId : pickedSeats) {
                    if (seatId < 21) {
                        firstClassSeats++;
                    } else if (seatId < 61) {
                        secondClassSeats++;
                    } else {
                        thirdClassSeats++;
                    }
                }pickedSeats.addAll(user
                        .getSessionById(session).getTakenSeatIds());
                pickedSeats.removeAll(canceledSeats);
                if(!user.getSessionById(session).getTakenSeatIds().containsAll(pickedSeats)){
                    new MoviePosterGrid(user);
                    dispose();
                }else{               
                     new Checkout(
                    calculateCost(firstClassSeats, secondClassSeats, thirdClassSeats),
                    firstClassSeats, secondClassSeats, thirdClassSeats, movie, user, session, pickedSeats,canceledSeats
            );
            dispose();

        }

            }
        });

        resetButton.setPreferredSize(new Dimension(100, 30));
        resetButton.addActionListener(e -> {
            if (user != null) {
                pickedSeats = new ArrayList<>(110);
                user.getSessionById(session).setTakenSeatIds(new ArrayList<>(110));
                movie.getSessionById(session.getId()).setTakenSeatIds(new ArrayList<>(110));;
                new CinemaSeating(movie, user, session);
                dispose();
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(resetButton);
        bottomPanel.add(checkoutButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Padding around the seats panel
        JPanel paddedSeatsPanel = new JPanel(new BorderLayout());
        paddedSeatsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        paddedSeatsPanel.add(mainSeatsPanel, BorderLayout.CENTER);
        paddedSeatsPanel.setBackground(Color.DARK_GRAY);

        // Adjust the width of the screenPanel
        screenPanel.setPreferredSize(new Dimension(paddedSeatsPanel.getPreferredSize().width, 50));

        // Add panels to frame
        add(screenPanel, BorderLayout.NORTH);
        add(paddedSeatsPanel, BorderLayout.CENTER);
    }

    private JPanel createClassPanel(String className, int rows, int cols) {
        JPanel classPanel = new JPanel(new BorderLayout());
        JLabel classLabel = new JLabel(className);
        classLabel.setHorizontalAlignment(SwingConstants.CENTER);
        classLabel.setForeground(Color.WHITE);
        classPanel.add(classLabel, BorderLayout.NORTH);

        JPanel classSeatsPanel = new JPanel(new GridLayout(rows, 1, 2, 1));
        classSeatsPanel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < rows; i++) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 1));
            rowPanel.setBackground(Color.DARK_GRAY);

            for (int j = 0; j < cols; j++) {
//                int seatNumber = (i * cols) + j + 1;
                SeatButton seatButton = new SeatButton();

                seatButton.addActionListener(e -> {
                    if (user == null) {
                        new LoginPage(movie, session);
                        dispose();
                    }
                    else{
//                    if(user != null && user.getSessionById(session).getTakenSeatIds().contains(seatButton.seatNumber)){
//
////                        JOptionPane.showConfirmDialog();
//                    }
//                        else
                            if (pickedSeats.contains(seatButton.seatNumber)) {
                            pickedSeats.remove((Integer) seatButton.seatNumber);
                            canceledSeats.add(seatButton.seatNumber);
                            seatButton.setBackground(Color.WHITE);
                        } else if (!session.getTakenSeatIds().contains(seatButton.seatNumber)) {
                            pickedSeats.add(seatButton.seatNumber);
                                canceledSeats.remove((Integer) seatButton.seatNumber);

                            seatButton.setBackground(new Color(123456));
                        }
                    }
                });

                if (user != null && user.getSessionById(session).getTakenSeatIds().contains(seatButton.seatNumber)) {
                    seatButton.setBackground(Color.YELLOW);
                } else if (session.getTakenSeatIds().contains(seatButton.seatNumber)) {
                    seatButton.setBackground(Color.GRAY);
                    seatButton.setEnabled(false);
                } else if (pickedSeats.contains(seatButton.seatNumber)) {
                    seatButton.setBackground(Color.MAGENTA);
                } else {
                    seatButton.setBackground(Color.WHITE);
                }

                seatButton.putClientProperty("originalColor", seatButton.getBackground());
                rowPanel.add(seatButton);
            }
            classSeatsPanel.add(rowPanel);
        }
        classPanel.add(classSeatsPanel, BorderLayout.CENTER);
        classPanel.setBackground(Color.DARK_GRAY);

        return classPanel;
    }

    // Custom Seat Buttons
    class SeatButton extends JButton {

        private static final int SIZE = 30;
        private final int seatNumber;
        static int global=1;

        public SeatButton() {
            if (global==111){
                global=1;
            }
            this.seatNumber = global++;

            setPreferredSize(new Dimension(SIZE, SIZE));
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(getBackground());
            g2.fillRect(0, 0, SIZE, SIZE);

            g2.setColor(Color.CYAN);
            g2.drawRect(0, 0, SIZE - 1, SIZE - 1);

            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.PLAIN, 11));
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(String.valueOf(seatNumber));
            int textHeight = fm.getAscent();
            g2.drawString(String.valueOf(seatNumber), (SIZE - textWidth) / 2, (SIZE + textHeight) / 2 - 2);

            g2.dispose();
            super.paintComponent(g);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(SIZE, SIZE);
        }
    }
}
