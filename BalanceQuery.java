package bannk_management;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceQuery extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;

    BalanceQuery(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(335, 480, 140, 30);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;
        connn c = new connn();
        try {
            ResultSet rs = c.s.executeQuery("SELECT SUM(CASE WHEN Type = 'Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE PIN = '" + pinnumber + "'");
            if (rs.next()) {
                balance = rs.getInt("balance");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }

        JLabel text = new JLabel("Your Current Account Balance is : ₹ " + balance);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(150, 295, 500, 45);
        text.setForeground(Color.WHITE);
        image.add(text);

        setSize(850, 814);
        setLocation(320, 1);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceQuery("").setVisible(true);
    }
}
