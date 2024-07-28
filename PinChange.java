package bannk_management;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PinChange  extends JFrame implements ActionListener {

	JButton back,change;
	JPasswordField pin,repin;
	String pinnumber;
	
	PinChange(String pinnumber){
		this.pinnumber = pinnumber;
		
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(0, 0, 900, 900);
	        add(image);

	        JLabel text = new JLabel("Change Your PIN ");
	        text.setFont(new Font("System", Font.BOLD, 18));
	        text.setBounds(215, 245, 500, 45);
	        text.setForeground(Color.WHITE);
	        image.add(text);
	        
	        JLabel pintext = new JLabel("Enter Your PIN ");
	        pintext.setFont(new Font("System", Font.BOLD, 14));
	        pintext.setBounds(150, 295, 500, 45);
	        pintext.setForeground(Color.WHITE);
	        image.add(pintext);
	        
	        pin = new JPasswordField();
	        pin.setBounds(300, 305, 180, 25);
	        pin.setFont(new Font("System", Font.BOLD, 21));
	        image.add(pin);
	        
	        JLabel repintext = new JLabel("Re-Enter Your PIN ");
	        repintext.setFont(new Font("System", Font.BOLD, 14));
	        repintext.setBounds(150, 330, 500, 45);
	        repintext.setForeground(Color.WHITE);
	        image.add(repintext);
	        
	        repin = new JPasswordField();
	        repin.setBounds(300, 340, 180, 25);
	        repin.setFont(new Font("System", Font.BOLD, 21));
	        image.add(repin);
	        
	        change = new JButton("Change");
	        change.setBounds(335,447,140,30);
	        change.addActionListener(this);
	        image.add(change);
	        
	        back = new JButton("Back");
	        back.setBounds (335, 480, 140, 30);
	        back.addActionListener(this);
	        image.add(back);
	        
	        setSize(850, 814);
	        setLocation(320, 1);
	        setUndecorated(true);
	        setVisible(true);
		
		
	}
	
	 public void actionPerformed(ActionEvent ae) {
	        
	        if (ae.getSource() == change) {
	           try { 
	        	String npin = pin.getText();
	        	String rpin = pin.getText();
	        
	            if (!npin.equals(rpin)) {
	                JOptionPane.showMessageDialog(null, "ERROR!! PIN Does't Match");
	                return;
	            } 
	            	
	            if (npin.equals("")) {
	                JOptionPane.showMessageDialog(null, "Please Enter Your PIN ");

	            }
	            if (rpin.equals("")) {
	                JOptionPane.showMessageDialog(null, "Please Re-Enter Your PIN");

	            }
	            connn c = new connn();
	            String query1 = "update bank set pin = '"+rpin+"' where PIN = '"+pinnumber+"'";
	            String query2 = "update loginn set pin = '"+rpin+"' where PIN = '"+pinnumber+"'";
                String query3 = "update signupThreee set pin = '"+rpin+"' where PIN_NO = '"+pinnumber+"'";
                
                c.s.executeUpdate(query1);		
                c.s.executeUpdate(query2);	
				c.s.executeUpdate(query3);	
	            
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully ");

                setVisible(false);
	            new Transactions(rpin).setVisible(true);
                
	                } catch (Exception e) {
	                    System.out.println(e);
	                }
	                
	            } else  {
	            setVisible(false);
	            new Transactions(pinnumber).setVisible(true);
	        }
	    }
	    
	
	
	
	
	
	
	
	public static void main(String[] args) {

		new PinChange("").setVisible(true);
	}

}
