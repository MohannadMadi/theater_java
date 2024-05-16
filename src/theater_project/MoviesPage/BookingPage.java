package theater_project.MoviesPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookingPage extends JFrame {
    private ImageIcon moviePoster;
    private String movieName;

    public BookingPage(ImageIcon moviePoster, String movieName) {
        this.moviePoster = moviePoster;
        this.movieName = movieName;

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                ((JComponent) me.getSource()).setForeground(Color.YELLOW);
            }

            public void mouseExited(MouseEvent me) {
                ((JComponent) me.getSource()).setForeground(Color.WHITE);
            }
        };

        setTitle("Booking - " + movieName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.DARK_GRAY);

        JLabel posterLabel = new JLabel(moviePoster);
        add(posterLabel, BorderLayout.WEST);

        // Title panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.BLACK);
        JLabel nameLabel = new JLabel("Movie: " + movieName, SwingConstants.CENTER);
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
        JComboBox<String> dateComboBox = new JComboBox<>(new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
        dateComboBox.setBackground(Color.DARK_GRAY);
        dateComboBox.setForeground(Color.WHITE);
        dateComboBox.setBorder(null);
        datePanel.add(dateLabel);
        datePanel.add(dateComboBox);
        selectionPanel.add(datePanel);

        // Time dropdown list
        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.DARK_GRAY);
        JLabel timeLabel = new JLabel("Select Time:");
        timeLabel.setForeground(Color.WHITE);
        JComboBox<String> timeComboBox = new JComboBox<>(new String[]{"6:00 AM", "8:00 PM", "10:00 PM", "12:00 AM"});
        timeComboBox.setBackground(Color.DARK_GRAY);
        timeComboBox.setForeground(Color.WHITE);
        timeComboBox.setBorder(null);
        timePanel.add(timeLabel);
        timePanel.add(timeComboBox);
        selectionPanel.add(timePanel);

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
                // TODO: save booking details to database
                JOptionPane.showMessageDialog(null, "Booking confirmed for " + movieName + " on " + dateComboBox.getSelectedItem() + " at " + timeComboBox.getSelectedItem());
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookingPage(new ImageIcon("moviePoster.jpg"), "Movie Name");
            }
        });
    }
}
