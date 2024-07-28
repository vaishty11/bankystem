package bannk_management;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;
public class Signp1st extends JFrame implements ActionListener {

	long random;
	JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField ;
	JButton next;
	JRadioButton male,female,other,married,unmarried;
	JDateChooser dateChooser;
	
	Signp1st(){
		
setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO: " + random );
		formno.setFont(new Font("ALgerian" ,Font.BOLD,34));
		formno.setBounds(180,0,500,45);
		add(formno);
		
		JLabel personaldetails = new JLabel("Page 1: Personal Details");
		personaldetails.setFont(new Font("ALgerian" ,Font.BOLD,20));
		personaldetails.setBounds(270,45,400,45);
		add(personaldetails);
		
		JLabel 	name = new JLabel("Name: ");
		name.setFont(new Font("ALgerian" ,Font.BOLD,21));
		name.setBounds(80,105,100,45);
		add(name);
		
	    nameTextField = new JTextField();
		nameTextField.setBounds(300,105,380,40);
		nameTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
		add(nameTextField);
		
		JLabel fname = new JLabel("Father's Name: ");
		fname.setFont(new Font("ALgerian" ,Font.BOLD,21));
		fname.setBounds(80,160,200,45);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setBounds(300,160,380,40);
		fnameTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth: ");
		dob.setFont(new Font("ALgerian" ,Font.BOLD,21));
		dob.setBounds(80,215,200,45);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,215,150,35);
		dateChooser.setFont(new Font("Times New Roman" ,Font.PLAIN,18));
		dateChooser.setForeground(new Color(130,14,10));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("ALgerian" ,Font.BOLD,21));
		gender.setBounds(80,270,200,45);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,270,100,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450,270,100,30);
		female.setBackground(Color.WHITE);
		add(female);
	
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel email = new JLabel("E-Mail: ");
		email.setFont(new Font("ALgerian" ,Font.BOLD,21));
		email.setBounds(80,325,200,45);
		add(email);
		
		emailTextField = new JTextField();
        emailTextField.setBounds(300,325,380,40);
        emailTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
        add(emailTextField);
		
		JLabel martial = new JLabel("Marital Status: ");
		martial.setFont(new Font("ALgerian" ,Font.BOLD,21));
		martial.setBounds(80,380,200,45);
		add(martial);
		
		unmarried = new JRadioButton("Single");
		unmarried.setBounds(450,380,100,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		married = new JRadioButton("Married");
		married.setBounds(300,380,100,30);
		married.setBackground(Color.WHITE);
		add(married);
			
		other = new JRadioButton("Other");
		other.setBounds(600,380,100,30);
		other.setBackground(Color.WHITE);
		add(other);
	
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
	    JLabel address = new JLabel("Address: ");
		address.setFont(new Font("ALgerian" ,Font.BOLD,21));
		address.setBounds(80,435,200,40);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(300,435,380,40);
		addressTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
		add(addressTextField);
		
		JLabel city = new JLabel("City: ");
		city.setFont(new Font("ALgerian" ,Font.BOLD,21));
		city.setBounds(80,490,200,45);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(300,490,230,40);
		cityTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
		add(cityTextField);
		
		JLabel state = new JLabel("State: ");
		state.setFont(new Font("ALgerian" ,Font.BOLD,21));
		state.setBounds(80,545,200,45);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setBounds(300,545,230,40);
		stateTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
		add(stateTextField);
		
		JLabel pincode = new JLabel("Pincode: ");
		pincode.setFont(new Font("ALgerian" ,Font.BOLD,21));
		pincode.setBounds(80,600,200,45);
		add(pincode);
		
		pinTextField = new JTextField();
		pinTextField.setBounds(300,600,170,40);
		pinTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
		add(pinTextField);
		
		next = new JButton("Next");
        next.setBounds(630,650,160,45);
        next.setBackground(Color.black);
        next.setFont(new Font("ALgerian" ,Font.BOLD,24));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);  
		
		
		
        getContentPane().setBackground(new Color(220, 230, 240));
	
	
		setSize(850, 790);
        setLocation(320, 20);
        setVisible(true);
}
	
	public void actionPerformed(ActionEvent ae) {
		
		String formno = "" + random;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();		
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		}else if (female.isSelected()) {
			gender = "Female";
		} 
		
		String email = emailTextField.getText();
		String marital = null;
		if (unmarried.isSelected()) {
			marital = "Single";
			}else if (married.isSelected()) {
				marital = "Married";
			}else if (other.isSelected()) {
				marital = "Other";
			}
		String address = addressTextField.getText();
		String state = stateTextField.getText();
		String city = cityTextField.getText();
		String pin = pinTextField.getText();
		
		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is not Empty !!⚠");
			} else {
			connn c = new connn();
			String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new Signp2nd(formno).setVisible(true);
			
			}
		}catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	
	public static void main(String[] args) {
		new Signp1st();
		
		
		
		
	}

}
