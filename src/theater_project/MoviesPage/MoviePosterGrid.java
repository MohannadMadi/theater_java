import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class MoviePosterGrid {
    public MoviePosterGrid() {}

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Movies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2));
        frame.getContentPane().setBackground(new Color(123456));
        frame.setLocationRelativeTo(null);

        int width = 240;
        int height = 343;

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                ((JButton) me.getSource()).setBackground(Color.GRAY);
            }

            public void mouseExited(MouseEvent me) {
                ((JButton) me.getSource()).setBackground(Color.cyan);
            }
        };

        ActionListener bookNowAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();

                String movieName = (String) button.getClientProperty("title");
                ImageIcon moviePoster = (ImageIcon) button.getClientProperty("poster");

                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new BookingPage(moviePoster, movieName);
                    }
                });
            }
        };

        // Movie 1
        addMovie(frame, "ghost_busters.jpg", "Ghost Busters", "Adventure | Comedy | Sci-Fi", mouseListener, bookNowAction, width, height);
        // Movie 2
        addMovie(frame, "GODZILLA_X_KONG.jpg", "Godzilla vs Kong", "Action | Sci-Fi | Thriller", mouseListener, bookNowAction, width, height);
        // Movie 3
        addMovie(frame, "kingdom_of_planets_of_apes.jpg", "Planet of the Apes", "Action | Adventure | Sci-Fi", mouseListener, bookNowAction, width, height);
        // Movie 4
        addMovie(frame, "LAND_OF_BAD.jpg", "Land of Bad", "Action | Thriller", mouseListener, bookNowAction, width, height);

        frame.pack();
        frame.setVisible(true);
    }

    private static void addMovie(JFrame frame, String imagePath, String title, String genre, MouseListener mouseListener, ActionListener actionListener, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(imageIcon);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel(title);
        JLabel genreLabel = new JLabel(genre);
        textPanel.add(titleLabel);
        textPanel.add(genreLabel);
        panel.add(textPanel, BorderLayout.CENTER);

        JButton button = new JButton("Book Now");
        button.putClientProperty("title", title);
        button.putClientProperty("poster", imageIcon);
        button.setBackground(Color.cyan);
        button.setForeground(Color.black);
        button.addMouseListener(mouseListener);
        button.addActionListener(actionListener);
        panel.add(button, BorderLayout.SOUTH);
        panel.setBounds(0,0,20,100);

        frame.add(panel);
    }
}