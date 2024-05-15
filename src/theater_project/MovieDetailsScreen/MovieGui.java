package theater_project;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class MovieGui extends JFrame implements ActionListener    {
    JButton button;
     MovieGui(){
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(new Color(0x333333));
        
        ImageIcon icon = new ImageIcon("src\\theater_project\\images.jpg");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(icon);
        imageLabel.setBounds(50, 150, 195, 275);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name: ");// concatenate OR REPLACE the name of the movie with the "Name" inside setText
        nameLabel.setForeground(new Color(0xFFFFFF));
        nameLabel.setBounds(300, 150, 100, 10);

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description: ");
        descriptionLabel.setBounds(300, 230, 100, 10);
        descriptionLabel.setForeground(new Color(0xFFFFFF));
        
        JLabel directorLabel = new JLabel();
        directorLabel.setText("Director: ");
        directorLabel.setBounds(300, 310, 100, 10);
        directorLabel.setForeground(new Color(0xFFFFFF));

        JLabel actorLabel = new JLabel();
        actorLabel.setText("Actors: ");
        actorLabel.setBounds(300, 390, 100, 10);
        actorLabel.setForeground(new Color(0xFFFFFF));
        
        JButton button = new JButton();
        button.setBounds(800, 385, 120, 40);
        button.setText("Book Ticket");
        button.setBackground(new Color(0x1D99D1));
        button.setFocusable(false);
        button.setFont(new FontUIResource("Helvetica", Font.BOLD, 13));
        button.setBorder(null);
        //this.setLayout(new GridLayout(9,1, 5, 5));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 600);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        panel.add(nameLabel);
        panel.add(descriptionLabel);
        panel.add(directorLabel);
        panel.add(actorLabel);
        panel.add(imageLabel);
        panel.add(button);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            
        }
    }

   
}
