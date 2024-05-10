package theater_project;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MovieGui extends JFrame implements ActionListener    {
    JButton button;
     MovieGui(){
        ImageIcon icon = new ImageIcon("icon.png");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(icon);
        imageLabel.setBounds(500, 500, 50, 50);

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
        button.setBounds(300, 460, 70, 30);
        button.setText("Click");
        button.setBackground(new Color(0x0099ed));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));        
        this.getContentPane().setBackground(new Color(0x333333));
        //this.setLayout(new GridLayout(9,1, 5, 5));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 600);
        this.add(nameLabel);
        this.add(descriptionLabel);
        this.add(directorLabel);
        this.add(actorLabel);
        this.add(imageLabel);
        this.add(button);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            
        }
    }

   
}
