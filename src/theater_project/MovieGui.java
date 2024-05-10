package theater_project;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class MovieGui extends JFrame    {
     MovieGui(){

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name: ");// concatenate the name of the movie with the "Name" inside setText
        nameLabel.setForeground(new Color(0xFFFFFF));
        nameLabel.setBounds(20, 100, 100, 10);

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description: ");
        descriptionLabel.setBounds(20, 120, 100, 10);
        descriptionLabel.setForeground(new Color(0xFFFFFF));

        JLabel directorLabel = new JLabel();
        directorLabel.setText("Director: ");
        directorLabel.setBounds(20, 140, 100, 10);
        directorLabel.setForeground(new Color(0xFFFFFF));

        JLabel actorLabel = new JLabel();
        actorLabel.setText("Actors: ");
        actorLabel.setBounds(20, 160, 100, 10);
        actorLabel.setForeground(new Color(0xFFFFFF));
        
        this.getContentPane().setBackground(new Color(0x333333));
        this.setLayout(new GridLayout(9,1, 5, 5));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 600);
        this.add(nameLabel);
        this.add(descriptionLabel);
        this.add(directorLabel);
        this.add(actorLabel);
        this.setVisible(true);
        

    }    
   
}
