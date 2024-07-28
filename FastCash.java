package bannk_management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton for100, for2000, for1000, for500, for5000, for10000, back;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount ");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(175, 245, 500, 45);
        text.setForeground(Color.WHITE);
        image.add(text);

        for100 = new JButton("₹ 100 ");
        for100.setBounds(135, 373, 140, 30);
        for100.addActionListener(this);
        image.add(for100);

        for500 = new JButton("₹ 500 ");
		for500.setBounds(335,373,140,30);
		for500.addActionListener(this);
		image.add(for500);
		
		for1000 = new JButton("₹ 1000 ");
		for1000.setBounds(135,410,140,30);
		for1000.addActionListener(this);
		image.add(for1000);
		
		for2000 = new JButton("₹ 2000 ");
		for2000.setBounds(335,410,140,30);
		for2000.addActionListener(this);
		image.add(for2000);
		
		for5000 = new JButton("₹ 5000 ");
		for5000.setBounds(135,447,140,30);
		for5000.addActionListener(this);
		image.add(for5000);
		
		for10000 = new JButton("₹ 10000 ");
		for10000.setBounds(335,447,140,30);
		for10000.addActionListener(this);
		image.add(for10000);

        back = new JButton("Back");
        back.setBounds(335, 480, 140, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(850, 814);
        setLocation(320, 1);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String depositType = "Withdrawal";
            String amount = ((JButton) ae.getSource()).getText().substring(2).trim();
            connn c = new connn();
            try {
                ResultSet rs = c.s.executeQuery("SELECT SUM(CASE WHEN Type = 'Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE PIN = '" + pinnumber + "'");
                if (rs.next()) {
                    int balance = rs.getInt("balance");
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance \u26A0!!");
                        return;
                    }

                    Date date = new Date();
                    String query = "INSERT INTO bank VALUES ('" + pinnumber + "','" + date + "','" + depositType + "','" + amount + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "₹ " + amount + " Debited Successfully.");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error retrieving balance. Please try again later.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
