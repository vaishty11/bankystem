package bannk_management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{

	JButton deposit,ministatement,fastcash,withdrawal,pinchange,balancequery,exit;
	String pinnumber;
	
	Transactions (String pinnumber){
		this.pinnumber = pinnumber;
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please select your Transaction ");
		text.setFont(new Font("System" ,Font.BOLD,18));
		text.setBounds(175,245,500,45);
		text.setForeground(Color.WHITE);
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(135,373,140,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawal = new JButton("Cash Withdrawal");
		withdrawal.setBounds(335,373,140,30);
		withdrawal.addActionListener(this);
		image.add(withdrawal);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(135,410,140,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(335,410,140,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("PIN Change");
		pinchange.setBounds(135,447,140,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balancequery = new JButton("Balance Query");
		balancequery.setBounds(335,447,140,30);
		balancequery.addActionListener(this);
		image.add(balancequery);
		
		exit = new JButton("Exit");
		exit.setBounds(335,480,140,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
		
		
		setSize(850, 814);
        setLocation(320, 1);
        setUndecorated(true);
        setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == deposit ){
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if (ae.getSource() == withdrawal) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}else if (ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}else if (ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);		
		}else if (ae.getSource() == balancequery) {
			setVisible(false);
			new BalanceQuery(pinnumber).setVisible(true);
		}else if (ae.getSource() == ministatement) {
			new MiniStatement(pinnumber).setVisible(true);
		}else if (ae.getSource() == exit) {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for using the ATM!");
                System.exit(0);
            }
		}
		
		
	}
	
public static void main(String[] args) {
	new Transactions ("");

	}
}
