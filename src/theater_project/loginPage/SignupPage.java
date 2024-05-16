package theater_project.loginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SignupPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");
    JButton SignupButton = new JButton("Sign up");
    JButton backButton = new JButton("Back");
    JTextField emailField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel emailLabel = new JLabel("Email:");
    JLabel passwordLabel = new JLabel("Password:");
    JButton exitButton = new JButton("Exit");
    JLabel messageLabel = new JLabel();
    HashMap<String,String> logininfo;

    SignupPage(HashMap<String,String> loginInfoOriginal) {
        logininfo = loginInfoOriginal;

        emailLabel.setBounds(50, 100, 75, 25);
        passwordLabel.setBounds(50, 150, 75, 25);

        exitButton.setBounds(350, 10, 60, 25);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        emailField.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 150, 200, 25);

        SignupButton.setBounds(125, 200, 100, 25);
        SignupButton.setFocusable(false);
        SignupButton.addActionListener(this);

        backButton.setBounds(225, 200, 100, 25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.add(emailLabel);
        frame.add(passwordLabel);
        frame.add(messageLabel);
        frame.add(emailField);
        frame.add(passwordField);
        frame.add(SignupButton);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SignupButton) {
            // Add your signup logic here
            // If signup is successful
            messageLabel.setForeground(Color.green);
            messageLabel.setText("Signup successful");
            // If signup is not successful
            // messageLabel.setForeground(Color.red);
            // messageLabel.setText("Signup not successful");
        }

        if (e.getSource() == backButton) {
            frame.dispose();


            LoginPage loginPage = new LoginPage(logininfo);
        }
    }
}
