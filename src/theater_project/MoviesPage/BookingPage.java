import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookingPage extends JFrame
{
    private ImageIcon moviePoster;
    private String movieName;

    public BookingPage(ImageIcon moviePoster, String movieName) {
        this.moviePoster = moviePoster;
        this.movieName = movieName;

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                ((JButton) me.getSource()).setBackground(Color.GRAY);
            }

            public void mouseExited(MouseEvent me) {
                ((JButton) me.getSource()).setBackground(Color.cyan);
            }
        };

        setTitle("Booking - " + movieName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel posterLabel = new JLabel(moviePoster);
        add(posterLabel, BorderLayout.WEST);


        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("Movie: " + movieName, SwingConstants.CENTER);
        titlePanel.add(nameLabel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);


        JPanel selectionPanel = new JPanel(new GridLayout(3, 1));


        JPanel datePanel = new JPanel();
        JLabel dateLabel = new JLabel("Select Date:");
        JComboBox<String> dateComboBox = new JComboBox<>(new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
        dateComboBox.setBackground(Color.cyan);
        datePanel.add(dateLabel);
        datePanel.add(dateComboBox);
        selectionPanel.add(datePanel);


        JPanel timePanel = new JPanel();
        JLabel timeLabel = new JLabel("Select Time:");
        JComboBox<String> timeComboBox = new JComboBox<>(new String[]{"6:00 AM", "8:00 PM", "10:00 PM", "12:00 AM"});
        timeComboBox.setBackground(Color.cyan);
        timePanel.add(timeLabel);
        timePanel.add(timeComboBox);
        selectionPanel.add(timePanel);

        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.setBackground(Color.cyan);
        confirmButton.setForeground(Color.black);
        confirmButton.addMouseListener(mouseListener);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: save booking details to database
                JOptionPane.showMessageDialog(null, "Booking confirmed for " + movieName + " on " + dateComboBox.getSelectedItem() + " at " + timeComboBox.getSelectedItem());
            }
        });

        selectionPanel.add(confirmButton);

        add(selectionPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run() {
                new BookingPage(moviePoster, movieName);
            }
        });
    }
}
