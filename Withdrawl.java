package bannk_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JButton back, withdrawButton;
    JTextField amount;
    String pinnumber;
    
    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the Amount you want to Withdraw ");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(136, 245, 400, 20);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(147, 290, 320, 25);
        amount.setFont(new Font("System", Font.BOLD, 21));
        image.add(amount);
        
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(325, 424, 140, 30);
        withdrawButton.addActionListener(this);
        image.add(withdrawButton);
        
        back = new JButton("Back");
        back.setBounds(325, 459, 140, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(850, 814);
        setLocation(320, 1);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == withdrawButton) {
            
            String withdrawType = "Withdraw"; 
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to Withdraw \u26A0!!");
            } else {
                try {
                    connn c = new connn();
                    String query = "insert into bank values ('"+pinnumber+"','" + date + "','" + withdrawType + "','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "₹ " + number + " Withdraw Successfully.\uD83D\uDECC");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
