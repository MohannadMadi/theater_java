package org.example.theater.view.seatsPage;

import org.example.theater.model.Movie;
import org.example.theater.model.Session;
import org.example.theater.model.User;
import org.example.theater.view.loginPage.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    public CinemaSeating(Movie movie, User user, Session session) {
        setTitle("Cinema Seating");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
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
        JPanel firstClassPanel = createClassPanel("First Class", FIRST_CLASS_ROWS, FIRST_CLASS_COLS,movie);
        mainSeatsPanel.add(firstClassPanel);

        // Second Class Panel
        JPanel secondClassPanel = createClassPanel("Second Class", SECOND_CLASS_ROWS, SECOND_CLASS_COLS,movie);
        mainSeatsPanel.add(Box.createVerticalStrut(20));
        mainSeatsPanel.add(secondClassPanel);

        // Third Class Panel
        JPanel thirdClassPanel = createClassPanel("Third Class", THIRD_CLASS_ROWS, THIRD_CLASS_COLS,movie);
        mainSeatsPanel.add(Box.createVerticalStrut(20));
        mainSeatsPanel.add(thirdClassPanel);

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

    private JPanel createClassPanel(String className, int rows, int cols,Movie movie) {
        JPanel classPanel = new JPanel(new BorderLayout());
        JLabel classLabel = new JLabel(className);
        classLabel.setHorizontalAlignment(SwingConstants.CENTER);
        classLabel.setForeground(Color.WHITE);
        classPanel.add(classLabel, BorderLayout.NORTH);

        JPanel classSeatsPanel = new JPanel(new GridLayout(rows, 1, 2, 1));
        classSeatsPanel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < rows; i++) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 1));
            rowPanel.setBackground(Color.DARK_GRAY);

            for (int j = 0; j < cols; j++) {
                int seatNumber = (i * cols) + j + 1;
                SeatButton seatButton = new SeatButton(seatNumber);
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (user==null){
                            System.out
                                    .println(movie.getName());
                            new LoginPage(movie,session);
                        }
                    }
                });

                seatButton.setBackground(Color.WHITE);
                seatButton.putClientProperty("originalColor", Color.WHITE);

                rowPanel.add(seatButton);
            }
            classSeatsPanel.add(rowPanel);
        }
        classPanel.add(classSeatsPanel, BorderLayout.CENTER);
        classPanel.setBackground(Color.DARK_GRAY);

        return classPanel;
    }

    private MouseListener createMouseListener() {
        return new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                ((JComponent) me.getSource()).setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                JComponent button = (JComponent) me.getSource();
                Color originalColor = (Color) button.getClientProperty("originalColor");
                button.setBackground(originalColor);
            }
        };
    }

    // Custom Seat Buttons
    class SeatButton extends JButton {

        private static final int SIZE = 30;
        private final int seatNumber;
        Color color=Color.CYAN;

        public SeatButton(int seatNumber) {
            this.seatNumber = seatNumber;
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