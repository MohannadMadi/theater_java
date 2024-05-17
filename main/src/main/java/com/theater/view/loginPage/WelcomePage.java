package view.loginPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class WelcomePage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");
    JButton backButton = new JButton("Back");
    JButton exitButton = new JButton("Exit");
    HashMap<String,String> logininfo;

    WelcomePage(String userID, HashMap<String,String> loginInfoOriginal){
        logininfo = loginInfoOriginal;

        welcomeLabel.setBounds(0,0,400,35);
        welcomeLabel.setFont(new Font(null,Font.BOLD,20));
        welcomeLabel.setText("Welcome ya  "+userID);

        backButton.setBounds(225, 200, 100, 25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        exitButton.setBounds(350, 10, 60, 25);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.dispose();
            LoginPage loginPage = new LoginPage(logininfo);
        }
    }
}
