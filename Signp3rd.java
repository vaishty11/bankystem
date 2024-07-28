package bannk_management;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Signp3rd extends JFrame implements ActionListener{

	JButton submit,cancel;
	JRadioButton psaving,pdeposit,pcurrent,prdeposit;
	JCheckBox s1,s2,s3,s4,s5,s6,s7;
	String formno;
	
	Signp3rd(String formno){
		this.formno = formno;
		
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		
		JLabel additionaldetails = new JLabel("Page 3: Account Details");
		additionaldetails.setFont(new Font("ALgerian" ,Font.BOLD,20));
		additionaldetails.setBounds(270,30,400,45);
		add(additionaldetails);
		
		JLabel 	paccounttype = new JLabel("Account Type ");
		paccounttype.setFont(new Font("ALgerian" ,Font.BOLD,21));
		paccounttype.setBounds(80,115,160,45);
		add(paccounttype);
		
		psaving = new JRadioButton("Savings Account");
		psaving.setBounds(85,160,220,28);
		psaving.setFont(new Font("ALgerian" ,Font.BOLD,18));
		psaving.setBackground(Color.WHITE);
		add(psaving);
		
		pdeposit = new JRadioButton("Fixed Deposit Account");
		pdeposit.setBounds(450,160,270,28);
		pdeposit.setFont(new Font("ALgerian" ,Font.BOLD,18));
		pdeposit.setBackground(Color.WHITE);
		add(pdeposit);
	
		pcurrent = new JRadioButton("Current Account");
		pcurrent.setBounds(85,200,220,28);
		pcurrent.setFont(new Font("ALgerian" ,Font.BOLD,18));
		pcurrent.setBackground(Color.WHITE);
		add(pcurrent);
		
		prdeposit = new JRadioButton("Recurring Deposit Account");
		prdeposit.setBounds(450,200,300,28);
		prdeposit.setFont(new Font("ALgerian" ,Font.BOLD,18));
		prdeposit.setBackground(Color.WHITE);
		add(prdeposit);
		
		ButtonGroup paccounttypegroup = new ButtonGroup();
		paccounttypegroup.add(psaving);
		paccounttypegroup.add(pdeposit);
		paccounttypegroup.add(pcurrent);
		paccounttypegroup.add(prdeposit);
		
		JLabel card = new JLabel("Card Number: ");
		card.setFont(new Font("ALgerian" ,Font.BOLD,21));
		card.setBounds(80,250,200,45);
		add(card);
		
		String labelText = "Your 16 digit Card No: ";
		JLabel carddetail = new JLabel(labelText);
		carddetail.setFont(new Font("ALgerian" ,Font.BOLD,12));
		carddetail.setBounds(80,270,200,45);
		add(carddetail);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-3538");
		number.setFont(new Font("ALgerian" ,Font.BOLD,25));
		number.setBounds(400,250,350,45);
		add(number);
		
		JLabel pin = new JLabel("PIN: ");
		pin.setFont(new Font("ALgerian" ,Font.BOLD,21));
		pin.setBounds(80,315,200,45);
		add(pin);
		
		String pinText = "Your 4 Digit PIN is: ";
		JLabel pindetail = new JLabel(pinText);
		pindetail.setFont(new Font("ALgerian" ,Font.BOLD,12));
		pindetail.setBounds(80,335,200,45);
		add(pindetail);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("ALgerian" ,Font.BOLD,25));
		pnumber.setBounds(400,315,200,45);
		add(pnumber);
		
		JLabel pservices = new JLabel("Services: ");
		pservices.setFont(new Font("ALgerian" ,Font.BOLD,21));
		pservices.setBounds(80,380,200,45);
		add(pservices);
		
		s1 = new JCheckBox("ATM CARD");
		s1.setBackground(Color.WHITE);
		s1.setFont(new Font("ALgerian" ,Font.BOLD,18));
		s1.setBounds(100,430,180,25);
		add(s1);
		
		s2 = new JCheckBox("Internet Banking");
		s2.setBackground(Color.WHITE);
		s2.setFont(new Font("ALgerian" ,Font.BOLD,18));
		s2.setBounds(450,430,250,25);
		add(s2);
		
		s3 = new JCheckBox("Mobile Banking");
		s3.setBackground(Color.WHITE);
		s3.setFont(new Font("ALgerian" ,Font.BOLD,18));
		s3.setBounds(100,470,180,25);
		add(s3);
		
		s4 = new JCheckBox("E-Mail & SMS ALerts");
		s4.setBackground(Color.WHITE);
		s4.setFont(new Font("ALgerian" ,Font.BOLD,18));
		s4.setBounds(450,470,250,25);
		add(s4);
		
		s5 = new JCheckBox("Cheque Book");
		s5.setBackground(Color.WHITE);
		s5.setFont(new Font("ALgerian" ,Font.BOLD,18));
		s5.setBounds(100,510,180,25);
		add(s5);
		
		s6 = new JCheckBox("E-Statement");
		s6.setBackground(Color.WHITE);
		s6.setFont(new Font("ALgerian" ,Font.BOLD,18));
		s6.setBounds(450,510,200,25);
		add(s6);
		
		String s7Text = "I hereby declares that the above entered details are correct to the best of my knowledge. ";
		s7 = new JCheckBox(s7Text);
		s7.setBackground(Color.WHITE);
		s7.setFont(new Font("ALgerian" ,Font.BOLD,13));
		s7.setBounds(80,565,700,35);
		add(s7);
		
		
		
		submit = new JButton("Submit");
		submit.setBounds(220,630,130,40);
		submit.setBackground(Color.black);
		submit.setFont(new Font("ALgerian" ,Font.BOLD,24));
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit); 
		
		cancel = new JButton("Cancel");
        cancel.setBounds(470,630,130,40);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("ALgerian" ,Font.BOLD,24));
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);  
		
        getContentPane().setBackground(new Color(220, 230, 240));

	
		setSize(850, 790);
        setLocation(320, 20);
        setVisible(true);
}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == submit) {
			String paccounttype = null;
			if (psaving.isSelected()) {
				paccounttype = "Savings Account";
			}else if (pdeposit.isSelected()) {
				paccounttype = "Fixed Deposit Account";
			} else if (pcurrent.isSelected()) {
				paccounttype = "Current Account";
			} else if (prdeposit.isSelected()) {
				paccounttype = "Recurring Deposit Account"; 
			}
			Random random = new Random();
			String cardnumber = "" + Math.abs((random.nextLong()% 900000L))+ 50409360000L;
			
			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String pservices = null;
			if (s1.isSelected()) {
				pservices = "ATM CARD";
			}else if (s2.isSelected()) {
				pservices = "Internet Banking";
			} else if (s3.isSelected()) {
				pservices = "Mobile Banking";
			} else if (s4.isSelected()) {
				pservices = "E-Mail & SMS ALerts"; 
			} else if (s5.isSelected()) {
				pservices = "Cheque Book"; 
			} else if (s6.isSelected()) {
				pservices = "E-Statement"; 
			}
				try {
					if (paccounttype.equals("")) {
						JOptionPane.showMessageDialog(null,"Account Type is Required \u26A0 !!");
					} else  {
						
						connn c = new connn();
						String query1 = "insert into signupthreee values ('"+formno+"','"+paccounttype+"','"+cardnumber+"','"+pinnumber+"','"+pservices+"')";
						String query2 = "insert into loginn values ('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

						c.s.executeUpdate(query1);		
						c.s.executeUpdate(query2);		
						
						JOptionPane.showMessageDialog(null, " Card Number: " + cardnumber + "\nPin: "  + pinnumber);
						
						
					}
				
				} catch (Exception e) {
	                System.out.println(e);
	            }
		    } else if (ae.getSource() == cancel) {
		    	setVisible(false);
				new loginATM().setVisible(true);
		    }
		}
	
	public static void main(String[] args) {
		new Signp3rd("");
		
	}

}

