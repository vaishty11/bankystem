package bannk_management;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class loginATM extends JFrame implements ActionListener {
	
	JButton login,signup,clear;
	JLabel newuser,cardno,pin;
	 JTextField cardTextField;
	 JPasswordField pinTextField ;
	 
	loginATM(){
  
		setTitle("AUTOMATED TELLER MACHINE (ATM) \uD83C\uDFE7");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		JLabel label = new JLabel(i3);
        label.setBounds(10, 10, 100, 100); 
        label.setBounds(70,10,100,100);
        add(label);
		
        getContentPane().setBackground(new Color(220, 230, 240));
	        
        newuser = new JLabel("Welcome to ATM.");
	        newuser.setBounds(280,60,600,40);
	        newuser.setFont(new Font("ALgerian" ,Font.BOLD,46));
	        newuser.setForeground(new Color(130,14,10));
	        add(newuser);
	        
	        cardno = new JLabel("Card No:");
	        cardno.setBounds(150,200,250,45);
	        cardno.setFont(new Font("ALgerian" ,Font.BOLD,34));
	        cardno.setForeground(new Color(130,14,10));
	        add(cardno);
	        
	        cardTextField = new JTextField();
	        cardTextField.setBounds(350,200,380,45);
	        cardTextField.setFont(new Font("ALgerian" ,Font.BOLD,24));
	        add(cardTextField);
	        
	        JLabel pin = new JLabel("Pin:");
	        pin.setBounds(150,290,150,45);
	        pin.setFont(new Font("ALgerian" ,Font.BOLD,34));
	        pin.setForeground(new Color(130,14,10));
	        add(pin);
	        
	        pinTextField = new JPasswordField();
	        pinTextField.setBounds(350,290,380,45);
	        pinTextField.setFont(new Font("ALgerian" ,Font.BOLD,24));
	        add(pinTextField);
	        
	        login = new JButton("Sign In");
	        login.setBounds(350,380,160,45);
	        login.setFont(new Font("ALgerian" ,Font.BOLD,24));
	        login.setBackground(Color.black);
	        login.setForeground(Color.white);
	        login.addActionListener(this);
	        add(login);  
	        
	        clear = new JButton("Clear");
	        clear.setBounds(565,380,160,45);
	        clear.setFont(new Font("ALgerian" ,Font.BOLD,24));
	        clear.setBackground(Color.black);
	        clear.setForeground(Color.white);
	        clear.addActionListener(this);
	        add(clear);  
	        
	        newuser = new JLabel("New user ?? Sign Up Here =>");
	        newuser.setBounds(150,455,320,40);
	        newuser.setFont(new Font("ALgerian" ,Font.BOLD,20));
	        newuser.setForeground(new Color(10,14,119));
	        add(newuser); 
	        
	        signup = new JButton("Sign Up");
	        signup.setBounds(460,455,160,45);
	        signup.setBackground(Color.black);
	        signup.setFont(new Font("ALgerian" ,Font.BOLD,24));
	        signup.setForeground(Color.white);
	        signup.addActionListener(this);
	        add(signup);  
	        
        setSize(1000, 600);
        setLocation(280, 150);
        setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
			
			
		} else if(ae.getSource() == login) {
			connn c = new connn ();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			
			String query = "select* from loginn where CARD = '"+cardnumber+"' and PIN = '"+pinnumber+"'";
			try {
				
				ResultSet rs  = c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "INCORRECT CARD NUMBER  or PIN \u26A0" );
				}
			}catch (Exception e){
				System.out.println(e);
			}
			
			
			} else if(ae.getSource() == signup) {
		setVisible(false);
		new Signp1st().setVisible(true);
	}
	}
	
	
	public static void main(String[] args) {

		new loginATM();
	
	}

}
