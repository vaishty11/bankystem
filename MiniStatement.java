package bannk_management;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("PNB Statement");
        setLayout(null);

        JLabel bank = new JLabel("PUNJAB NATIONAL BANK ");
        bank.setBounds(70, 25, 400, 20);
        bank.setFont(new Font("System", Font.BOLD, 18));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(10, 95, 400, 20);
        card.setFont(new Font("System", Font.BOLD, 14));
        add(card);

        JLabel mini = new JLabel();
        mini.setFont(new Font("System", Font.BOLD, 14));
        mini.setBounds(10, 50, 500, 500);
        add(mini);

        JLabel displaybalance = new JLabel();
        displaybalance.setFont(new Font("System", Font.BOLD, 14));
        displaybalance.setBounds(10, 190, 500, 500);
        add(displaybalance);

        try {
            connn c = new connn();
            ResultSet rs = c.s.executeQuery("select * from loginn where PIN = '" + pinnumber + "'");

            while (rs.next()) {
                card.setText("Card No: " + rs.getString("CARD").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("CARD").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            connn c = new connn();

            ResultSet rs = c.s.executeQuery("select * from bank where PIN = '" + pinnumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>" + "<html> ");
            }

            ResultSet rs1 = c.s.executeQuery("select SUM(CASE WHEN Type = 'Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE PIN = '" + pinnumber + "'");

            if (rs1.next()) {
                int balance = rs1.getInt("balance");
                displaybalance.setText("Available Balance: ₹ " + balance);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        getContentPane().setBackground(new Color(220, 230, 240));

        setSize(400, 600);
        setLocation(550, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
