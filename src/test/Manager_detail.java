package test;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import test.Billing;

public class Manager_detail extends JFrame implements ActionListener
{

	JPanel top,down;
	Font f,f1,f2,f3,f4;
	JLabel name,backimagetop,backimagedown;
	JLabel l1,l2,l3,l4,l5,l6,l7,l9;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JTextArea ta1;
	JButton update,save;
	JPasswordField p;
	
	public void fun2()
	{
		setVisible(true);
		setLayout(null);
		setSize(960,650);
		setResizable(true);
		setTitle("Manager Details");

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
		l1=new JLabel("Your personal details:");l1.setFont(f2);
		l2=new JLabel("Name");l2.setFont(f4);
		l3=new JLabel("ID");l3.setFont(f4);
		l4=new JLabel("Password");l4.setFont(f4);
		l5=new JLabel("Address");l5.setFont(f4);
		l6=new JLabel("Contact");l6.setFont(f4);
		l7=new JLabel("Date of Joining");l7.setFont(f4);
		l9=new JLabel("Age");l9.setFont(f4);
		
		//text fields declared
		t1=new JTextField(20);t1.setFont(f3);
		t2=new JTextField(20);t2.setFont(f3);
		t3=new JTextField(20);t3.setFont(f3);
		t4=new JTextField(20);t4.setFont(f3);
		t5=new JTextField(20);t5.setFont(f3);
		
		//text area declared
		ta1=new JTextArea(150,75);ta1.setFont(f3);ta1.setLineWrap(true);
		
		//password
		p=new JPasswordField(10);
				
		//button declared
		update=new JButton("Update");update.setFont(f3);
		save=new JButton("Save");save.setFont(f3);
		
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
		down.setBounds(00,121,960,530);
		name.setBounds(323,30,900,50);
		backimagetop.setBounds(00,00,959,120);
		backimagedown.setBounds(00,00,970,530);
		l1.setBounds(125,00,400,50);l2.setBounds(175,60,100,30);
		l3.setBounds(175,100,100,30);l4.setBounds(175,140,100,30);
		l5.setBounds(175,220,100,30);l6.setBounds(175,305,100,30);
		l7.setBounds(175,345,200,30);l9.setBounds(175,180,100,30);
		t1.setBounds(350,60,200,30);t2.setBounds(350,100,200,30);
		t3.setBounds(350,180,200,30);t4.setBounds(350,305,200,30);
		ta1.setBounds(350,220,200,75);t5.setBounds(350,345,200,30);
		update.setBounds(350,420,100,25);save.setBounds(530,420,100,25);
		p.setBounds(350,140,200,30);setBounds(185,50,970,650);
		
		t1.setEditable(false);t2.setEditable(false);t3.setEditable(false);
		t4.setEditable(false);t5.setEditable(false);ta1.setEditable(false);
		p.setEditable(false);
		
		//adding declarations
		add(top);add(down);top.add(name);down.add(l1);down.add(l2);down.add(l3);down.add(l4);down.add(l5);down.add(l6);
		down.add(t1);down.add(t2);down.add(t3);down.add(t4);down.add(ta1);down.add(t5);down.add(l7);
		down.add(update);down.add(l9);down.add(p);down.add(save);
	
	
		//adding background images
		top.add(backimagetop);down.add(backimagedown);
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
		Statement stat=con.createStatement();
		int id1=Home.id;
		String quer="select*from manager where id='"+id1+"'";
		ResultSet rs=stat.executeQuery(quer);
		while(rs.next())
		{
			String name=rs.getString("name");
			int manid=rs.getInt("id");
			String manpass=rs.getString("password");
			int manage=rs.getInt("age");
			String manaddress=rs.getString("address");
			String contact=rs.getString("contact");
			Date date=rs.getDate("joining_date");
			
			t1.setText(name);
			t2.setText(String.valueOf(manid));
			p.setText(manpass);
			t3.setText(String.valueOf(manage));
			t4.setText(contact);
			ta1.setText(manaddress);
			t5.setText(String.valueOf(date));
			
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		repaint();
		revalidate();
		
		save.addActionListener(this);
		update.addActionListener(this);
	}
	
	public static void main(String[] args) 
	{
		Manager_detail a =new Manager_detail();
		a.fun2();
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==save)
		{
			int op = JOptionPane.showConfirmDialog(this,"Are you sure you wish to contiue?");
			 if(op==0)
			 {
				 t1.setEditable(false);t2.setEditable(false);t3.setEditable(false);
					t4.setEditable(false);t5.setEditable(false);ta1.setEditable(false);
					p.setEditable(false);
			
					
					String insname=t1.getText();
					int insmanid=Integer.parseInt(t2.getText());
					char[] insmanpass=p.getPassword();
					int insmanage=Integer.parseInt(t3.getText());
					String insmanaddress=t4.getText();
					String inscontact=ta1.getText();
					
					
					try
					{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
					Statement stat=con.createStatement();
		String quer="update manager set name='"+insname+"',password='"+String.valueOf(insmanpass)+""
				+ "',age='"+insmanage+"',address='"+insmanaddress+"',contact='"+inscontact+"' where id='"+Home.id+"'";
					stat.executeUpdate(quer);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				
			 }
			 }
		
		
		if(ae.getSource()==update)
		{
			
			t1.setEditable(true);t3.setEditable(true);
			t4.setEditable(true);ta1.setEditable(true);
			p.setEditable(true);
			
			repaint();
			revalidate();
			}
		
	}

}



