package org.example.theater.view.checkout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Checout extends JFrame {
    private JLabel priceLabel;
    private JLabel firstClassLabel;
    private JLabel secondClassLabel;
    private JLabel thirdClassLabel;
    private JButton checkoutButton;

    public static double calculateCost(int firstClassSeats, int secondClassSeats, int thirdClassSeats) {
        final double FIRST_CLASS_COST = 50.0;
        final double SECOND_CLASS_COST = 15.0;
        final double THIRD_CLASS_COST = 10.0;

        double totalPrice = (firstClassSeats * FIRST_CLASS_COST) +
                (secondClassSeats * SECOND_CLASS_COST) +
                (thirdClassSeats * THIRD_CLASS_COST);

        return totalPrice;
    }

    MouseListener mouseListener = new MouseAdapter() {
        public void mouseEntered(MouseEvent me) {
            ((JComponent) me.getSource()).setForeground(Color.YELLOW);
        }

        public void mouseExited(MouseEvent me) {
            ((JComponent) me.getSource()).setForeground(Color.white);
        }
    };

    public Checout(double totalPrice, int firstClassSeats, int secondClassSeats, int thirdClassSeats) {
        setTitle("Checkout Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        setLocationRelativeTo(null);

        initComponents(totalPrice, firstClassSeats, secondClassSeats, thirdClassSeats);
    }

    private void initComponents(double totalPrice, int firstClassSeats, int secondClassSeats, int thirdClassSeats) {
        priceLabel = new JLabel("Total Price: $" + totalPrice);
        priceLabel.setForeground(Color.WHITE);
        firstClassLabel = new JLabel("First Class Seats: " + firstClassSeats);
        firstClassLabel.setForeground(Color.WHITE);
        secondClassLabel = new JLabel("Second Class Seats: " + secondClassSeats);
        secondClassLabel.setForeground(Color.WHITE);
        thirdClassLabel = new JLabel("Third Class Seats: " + thirdClassSeats);
        thirdClassLabel.setForeground(Color.WHITE);
        checkoutButton = new JButton("Checkout");
        checkoutButton.setBackground(Color.DARK_GRAY);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBorder(null);
        checkoutButton.addMouseListener(mouseListener);


        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Todo: Add Logic
            }
        });

        setLayout(new GridLayout(5, 1));
        add(firstClassLabel);
        add(secondClassLabel);
        add(thirdClassLabel);
        add(priceLabel);
        add(checkoutButton);

        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
    }


}