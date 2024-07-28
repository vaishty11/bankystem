package bannk_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signp2nd extends JFrame implements ActionListener{

	JTextField panTextField,aadharTextField ;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox Category,religion,Income,educational,occupation ;
	String formno;
	
	Signp2nd(String formno){
		this.formno = formno;
		
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionaldetails = new JLabel("Page 2: Additional Details");
		additionaldetails.setFont(new Font("ALgerian" ,Font.BOLD,20));
		additionaldetails.setBounds(270,35,400,45);
		add(additionaldetails);
		
		JLabel 	preligion = new JLabel("Religion: ");
		preligion.setFont(new Font("ALgerian" ,Font.BOLD,21));
		preligion.setBounds(80,105,160,45);
		add(preligion);
		
		String valReligion[] = {"Hindu","Muslim","Sikh","Christian","other"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300,105,200,40);
		religion.setFont(new Font("ALgerian" ,Font.BOLD,22));
		religion.setBackground(Color.WHITE);
		religion.setForeground(new Color(130,14,10));
		add(religion);
		
		JLabel pcategory = new JLabel("Category: ");
		pcategory.setFont(new Font("ALgerian" ,Font.BOLD,21));
		pcategory.setBounds(80,160,200,45);
		add(pcategory);
		
		String valCategory[] = {"General","OBC","SC","ST","other"};
		Category = new JComboBox(valCategory);
		Category.setBounds(300,160,380,40);
		Category.setFont(new Font("ALgerian" ,Font.BOLD,22));
		Category.setBackground(Color.WHITE);
		Category.setForeground(new Color(130,14,10));
		add(Category);
		
		JLabel pincome = new JLabel("Income: ");
		pincome.setFont(new Font("ALgerian" ,Font.BOLD,21));
		pincome.setBounds(80,215,200,45);
		add(pincome);
		
		String valIncome[] = {"< 2 LAKH","   2-4 LAKH","  > 4 LAKH"};
		Income = new JComboBox(valIncome);
		Income.setBounds(300,215,300,35);
		Income.setFont(new Font("ALgerian" ,Font.BOLD,22));
		Income.setBackground(Color.WHITE);
		Income.setForeground(new Color(130,14,10));
		add(Income);
		
		JLabel peducation = new JLabel("Educational: ");
		peducation.setFont(new Font("ALgerian" ,Font.BOLD,21));
		peducation.setBounds(80,270,200,45);
		add(peducation);
		
		JLabel pqualification = new JLabel("Qualification: ");
		pqualification.setFont(new Font("ALgerian" ,Font.BOLD,21));
		pqualification.setBounds(80,305,200,45);
		add(pqualification);
		
		String educationalValues[] = {"10th" ,"12th","Graduation", "Post-Graduation","PHd","Others"};
		educational = new JComboBox(educationalValues);
		educational.setBounds(300,325,380,40);
		educational.setFont(new Font("ALgerian" ,Font.BOLD,22));
		educational.setBackground(Color.WHITE);
		educational.setForeground(new Color(130,14,10));
		add(educational);
		
		JLabel poccupation = new JLabel("Occupation: ");
		poccupation.setFont(new Font("ALgerian" ,Font.BOLD,21));
		poccupation.setBounds(80,380,200,45);
		add(poccupation);
		
		String occupationValues[] = {"Student" ,"Salaried", "Self-Employed","Retired","Others"};
		occupation = new JComboBox(occupationValues);
		occupation.setBounds(300,380,300,30);
		occupation.setFont(new Font("ALgerian" ,Font.BOLD,22));
		occupation.setBackground(Color.WHITE);
		occupation.setForeground(new Color(130,14,10));
		add(occupation);
		
	    JLabel ppanno = new JLabel("PAN NO: ");
		ppanno.setFont(new Font("ALgerian" ,Font.BOLD,21));
		ppanno.setBounds(80,435,200,40);
		add(ppanno);
		
		panTextField = new JTextField();
		panTextField.setBounds(300,435,380,40);
		panTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
		add(panTextField);
		
		JLabel paadharno = new JLabel("Aadhhar No: ");
		paadharno.setFont(new Font("ALgerian" ,Font.BOLD,21));
		paadharno.setBounds(80,490,200,45);
		add(paadharno);
		
		aadharTextField = new JTextField();
		aadharTextField.setBounds(300,490,230,40);
		aadharTextField.setFont(new Font("ALgerian" ,Font.BOLD,22));
		add(aadharTextField);
		
		JLabel pseniorcitizen = new JLabel("Senior Citizen: ");
		pseniorcitizen.setFont(new Font("ALgerian" ,Font.BOLD,21));
		pseniorcitizen.setBounds(80,545,200,45);
		add(pseniorcitizen);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300,545,100,40);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450,545,230,40);
		sno.setBackground(Color.WHITE);
		add(sno);
	
		ButtonGroup pseniorcitizengroup = new ButtonGroup();
		pseniorcitizengroup.add(syes);
		pseniorcitizengroup.add(sno);
		
		JLabel pexistingaccount = new JLabel("Existing Account: ");
		pexistingaccount.setFont(new Font("ALgerian" ,Font.BOLD,21));
		pexistingaccount.setBounds(80,600,250,45);
		add(pexistingaccount);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300,600,100,40);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450,600,100,40);
		eno.setBackground(Color.WHITE);
		add(eno);
	
		ButtonGroup pexistingaccountGroup = new ButtonGroup();
		pexistingaccountGroup.add(eyes);
		pexistingaccountGroup.add(eno);
		
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
		
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) Category.getSelectedItem();
		String sIncome = (String) Income.getSelectedItem();	
		String seducational = (String) educational.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		String pseniorcitizen = null;
		if (syes.isSelected()) {
			pseniorcitizen = "Yes";
		}else if (sno.isSelected()) {
			pseniorcitizen = "No";
		} 
		
		String pexistingaccount = null;
		if (eyes.isSelected()) {
			pexistingaccount = "Yes";
			}else if (eno.isSelected()) {
				pexistingaccount = "No";
			}
		
		String ppanno = panTextField.getText();
		String paadharno = aadharTextField.getText();
		
		try {
			connn c = new connn();
			String query = "insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sIncome+"','"+seducational+"','"+soccupation+"','"+ppanno+"','"+paadharno+"','"+pseniorcitizen+"','"+pexistingaccount+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new Signp3rd(formno).setVisible(true);
			
		}catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	
	public static void main(String[] args) {
		new Signp2nd("");
		
	}

}
