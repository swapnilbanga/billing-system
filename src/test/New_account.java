package test;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




public class New_account extends JFrame implements ActionListener
{

	JPanel top,down;
	Date date;
	Font f,f1,f2,f3,f4;
	JLabel name,backimagetop,backimagedown;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	String e_name,e_pass,e_title,e_contact,e_address,e_join;
	int e_id,e_age;
	JTextArea ta1;
	JButton save,clear;
	JComboBox cb;
	JPasswordField p;
	
	public void function2()
	{
		setVisible(true);
		setLayout(null);
		setSize(960,650);
		setResizable(true);
		setTitle("Add new accounts");

		//font
		f=new Font("Rockwell",Font.PLAIN,50);
		f1=new Font("Rockwell",Font.PLAIN,26);
		f2=new Font("Rockwell",Font.PLAIN,22);
		f3=new Font("Rockwell",Font.BOLD,16);
		f4=new Font("Rockwell",Font.PLAIN,20);
		
		//String declared for combobox
		String s[]={"Bartender","Catering Manager","Counter Server","Executive Chef","General Manager","Janitor","Server"};
	
		//panel declaration
		top=new JPanel();
		down=new JPanel();
		top.setLayout(null);
		down.setLayout(null);
		
		//labels declared
		l1=new JLabel("Add a new employee:");l1.setFont(f2);
		l2=new JLabel("Name");l2.setFont(f4);
		l3=new JLabel("ID");l3.setFont(f4);
		l4=new JLabel("Password");l4.setFont(f4);
		l5=new JLabel("Address");l5.setFont(f4);
		l6=new JLabel("Contact");l6.setFont(f4);
		l7=new JLabel("Date of Joining");l7.setFont(f4);
		l8=new JLabel("Job Title");l8.setFont(f4);
		l9=new JLabel("Age");l9.setFont(f4);
		
		//text fields declared
		t1=new JTextField(20);t1.setFont(f3);
		t2=new JTextField(20);t2.setFont(f3);
		t3=new JTextField(20);t3.setFont(f3);
		t4=new JTextField(20);t4.setFont(f3);
		t5=new JTextField(20);t5.setFont(f3);
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dt);
		t5.setText(date);
		
		//Combobox declared
		cb=new JComboBox(s);
		String combo=String.valueOf(cb.getSelectedItem());
		
		//text area declared
		ta1=new JTextArea(150,75);ta1.setFont(f3);ta1.setLineWrap(true);
		
		//password
		p=new JPasswordField(10);
				
		//button declared
		save=new JButton("Save");save.setFont(f3);
		clear=new JButton("Clear");clear.setFont(f3);
		
		//lables declared
		name=new JLabel("Restaurant");name.setFont(f);
				
		//background images
		backimagetop=new JLabel(new ImageIcon(getClass().getResource("grey1.jpg")));
		backimagedown=new JLabel(new ImageIcon(getClass().getResource("grey4.jpg")));
		
		//border on panel
		top.setBorder(BorderFactory.createLineBorder(Color.black));
		down.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//set Bounds
		top.setBounds(00,00,960,121);
		down.setBounds(00,121,970,530);					
		name.setBounds(323,30,900,50);
		backimagetop.setBounds(00,00,959,120);
		backimagedown.setBounds(00,00,970,530);
		l1.setBounds(125,00,400,50);l2.setBounds(175,60,100,30);
		l3.setBounds(175,100,100,30);l4.setBounds(175,140,100,30);
		l5.setBounds(175,260,100,30);l6.setBounds(175,345,100,30);
		l7.setBounds(175,385,200,30);l8.setBounds(175,220,100,30);
		l9.setBounds(175,180,100,30);setBounds(185,50,970,650);
		t1.setBounds(350,60,200,30);t2.setBounds(350,100,200,30);
		t3.setBounds(350,180,200,30);t4.setBounds(350,345,200,30);
		ta1.setBounds(350,260,200,75);t5.setBounds(350,385,200,30);
		save.setBounds(350,460,100,25);clear.setBounds(530,460,100,25);
		cb.setBounds(350,220,200,30);p.setBounds(350,140,200,30);
		
		//adding declarations
		add(top);add(down);top.add(name);down.add(l1);down.add(l2);down.add(l3);down.add(l4);down.add(l5);down.add(l6);
		down.add(t1);down.add(t2);down.add(t3);down.add(t4);down.add(ta1);down.add(t5);down.add(l7);
		down.add(save);down.add(clear);down.add(cb);down.add(l8);down.add(l9);down.add(p);
	
	
		//adding background images
		top.add(backimagetop);down.add(backimagedown);
		
		repaint();
		revalidate();
		
		cb.addActionListener(this);
		clear.addActionListener(this);
		save.addActionListener(this);
	}
	
	public static void main(String[] args) 
	{
		New_account ac=new New_account();
		ac.function2();
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==clear)
		{
			t1.setText("");t1.setText("");t2.setText("");t3.setText("");
			t4.setText("");t5.setText("");ta1.setText("");p.setText("");
		}
		
		if(ae.getSource()==save)
		{
			 int op = JOptionPane.showConfirmDialog(this,"Are you sure you wish to contiue?");
			 if(op==0)
			 {
			t1.setEditable(false);t2.setEditable(false);t3.setEditable(false);
			t4.setEditable(false);t5.setEditable(false);ta1.setEditable(false);
			p.setEditable(false);cb.setEditable(false);
			
			e_name=t1.getText();
			e_id=Integer.parseInt(t2.getText());
			e_pass=String.valueOf(p.getPassword());
			System.out.println(e_pass);
			e_age=Integer.parseInt(t3.getText());
			e_title=cb.getSelectedItem().toString();
			e_address=ta1.getText();
			e_contact=t4.getText();
			e_join=t5.getText();
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				Statement stat=con.createStatement();
				String quer="insert into employee values('"+e_name+"','"+e_id+"','"+e_pass+"','"+e_age+"','"+e_title+"','"+e_address+"','"+e_contact+"','"+e_join+"')";
				stat.executeUpdate(quer);
		}
			 catch(Exception e)
			
			{
				 JOptionPane.showMessageDialog(getContentPane(), "Failed to add new account, check entered information");
				 e.printStackTrace();
			}
			 }
		
		if(ae.getSource()==cb)
		{
			String combo=String.valueOf(cb.getSelectedItem());
		}
		
	}
	}
	

}
