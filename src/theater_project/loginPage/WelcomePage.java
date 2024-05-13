package theater_project.loginPage;

import java.awt.*;
import javax.swing.*;

public class WelcomePage {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");

    WelcomePage(String userID){

        welcomeLabel.setBounds(0,0,400,35);
        welcomeLabel.setFont(new Font(null,Font.BOLD,20));
        welcomeLabel.setText("Welcome ya  "+userID);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
//dummy page insert the next pages here with the same logic