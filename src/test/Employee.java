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

public class Employee extends JFrame implements MouseListener,ActionListener
{
	JPanel top,left,right;
	JLabel name,empname,bill,info,trans,backimagetop,backimageleft,backimageright;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t_id,t_age,t_contact,t_name,t_date,t6,t7,t_title;
	JTextArea ta1;
	JButton first,second,third;
	Font f,f1,f2,f3,f4;
	JButton update,save;
	JComboBox cb;
	JPasswordField p;
	public static int id1;
	public void  fun(int id)
	{
		setVisible(true);
		setLayout(null);
		setSize(950,650);
		setResizable(false);
		setTitle("Employee Desk");
		
		//font
		f=new Font("Rockwell",Font.PLAIN,50);
		f1=new Font("Rockwell",Font.PLAIN,26);
		f2=new Font("Rockwell",Font.PLAIN,22);
		f3=new Font("Rockwell",Font.BOLD,16);
		f4=new Font("Rockwell",Font.PLAIN,20);
		
		//panel declaration
		top=new JPanel();
		left=new JPanel();
		right=new JPanel();
		top.setLayout(null);
		left.setLayout(null);
		right.setLayout(null);
		
		//labels declared
		l1=new JLabel("Name");l1.setFont(f4);
		l2=new JLabel("ID");l2.setFont(f4);
		l3=new JLabel("Password");l3.setFont(f4);
		l4=new JLabel("Age");l4.setFont(f4);
		l5=new JLabel("Address");l5.setFont(f4);
		l6=new JLabel("Contact");l6.setFont(f4);
		l7=new JLabel("Date of Joining");l7.setFont(f4);
		l8=new JLabel("Job Title");l8.setFont(f4);
		
		name=new JLabel("Restaurant");name.setFont(f);
		empname=new JLabel("");empname.setFont(f1);
		
		//text fields declared
		t_id=new JTextField(20);t_id.setFont(f3);
		t_age=new JTextField(20);t_age.setFont(f3);
		t_contact=new JTextField(20);t_contact.setFont(f3);
		t_name=new JTextField(20);t_name.setFont(f3);
		t_date=new JTextField(20);t_date.setFont(f3);
		t_title=new JTextField(20);t_title.setFont(f3);
		
		//password
		p=new JPasswordField(20);
		
		//text area declared
		ta1=new JTextArea(150,75);ta1.setFont(f3);ta1.setLineWrap(true);
		
		//button declared
		update=new JButton("Update");update.setFont(f3);
		save=new JButton("Save");save.setFont(f3);
		
		//images de left panel
		info=new JLabel(new ImageIcon(getClass().getResource("user.png")));
		trans=new JLabel(new ImageIcon(getClass().getResource("trans2.jpg")));
		bill=new JLabel(new ImageIcon(getClass().getResource("bill.jpg")));
		
		//set tool tip to images
		info.setToolTipText("View Employee Details");
		trans.setToolTipText("View Transactions");
		bill.setToolTipText("Create Bills");
		
		//cursor on image
		bill.setCursor(new Cursor(Cursor.HAND_CURSOR));
		info.setCursor(new Cursor(Cursor.HAND_CURSOR));
		trans.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//making images button
		first=new JButton("user.jpg");
		second=new JButton("trans2.jpg");
		third=new JButton("bill.jpg");
		
		//background images
		backimagetop=new JLabel(new ImageIcon(getClass().getResource("grey1.jpg")));
		backimageleft=new JLabel(new ImageIcon(getClass().getResource("grey2.jpg")));
		backimageright=new JLabel(new ImageIcon(getClass().getResource("grey3.jpg")));
		
		//border on panel
		top.setBorder(BorderFactory.createLineBorder(Color.black));
		left.setBorder(BorderFactory.createLineBorder(Color.black));
		right.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//set bounds
		top.setBounds(00,00,960,121);
		left.setBounds(00,120,199,530);
		right.setBounds(147,120,809,530);
		name.setBounds(323,30,900,50);
		empname.setBounds(55,00,400,50);
		info.setBounds(11,05,175,155);
		trans.setBounds(11,167,175,160);
		bill.setBounds(11,335,175,160);
		backimagetop.setBounds(00,00,959,120);
		backimageleft.setBounds(00,00,198,530);
		backimageright.setBounds(00,00,857,530);
		l1.setBounds(75,70,100,30);l2.setBounds(75,110,100,30);
		l3.setBounds(75,150,100,30);l4.setBounds(75,190,100,30);
		l5.setBounds(75,270,100,30);l6.setBounds(75,360,100,30);
		l7.setBounds(75,395,200,30);l8.setBounds(75,230,100,30);
		t_id.setBounds(250,110,200,30);p.setBounds(250,150,200,30);
		t_age.setBounds(250,190,200,30);t_contact.setBounds(250,355,200,30);
		ta1.setBounds(250,270,200,75);t_date.setBounds(250,395,200,30);
		update.setBounds(250,460,100,25);save.setBounds(430,460,100,25);
		t_title.setBounds(250,230,200,30);setBounds(190,50,960,650);t_name.setBounds(250,70,200,30);
		
		t_id.setEditable(false);t_age.setEditable(false);t_contact.setEditable(false);t_title.setEditable(false);
		t_name.setEditable(false);ta1.setEditable(false);t_date.setEditable(false);p.setEditable(false);
		
		//adding declarations
		add(top);add(left);add(right);top.add(name);right.add(empname);left.add(bill);left.add(trans);
		left.add(info);right.add(l1);right.add(l2);right.add(l3);right.add(l4);right.add(l5);right.add(l6);
		right.add(t_id);right.add(t_age);right.add(t_contact);right.add(t_name);right.add(ta1);right.add(t_date);right.add(l7);
		right.add(update);right.add(save);right.add(l8);right.add(t_title);right.add(p);
		
		//adding background images
		top.add(backimagetop);left.add(backimageleft);right.add(backimageright);
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
		Statement stat=con.createStatement();
		String quer="select*from employee where id='"+id+"'";
		ResultSet rs=stat.executeQuery(quer);
		while(rs.next())
		{
			String name=rs.getString("name");
			int empid=rs.getInt("id");
			String emppass=rs.getString("password");
			int empage=rs.getInt("age");
			String empaddress=rs.getString("address");
			String contact=rs.getString("contact");
			Date date=rs.getDate("joining_date");
			String job_title=rs.getString("job_title");
			
			t_id.setText(String.valueOf(empid));
			t_age.setText(String.valueOf(empage));
			p.setText(emppass);
			t_contact.setText(String.valueOf(contact));
			t_name.setText(name);
			ta1.setText(empaddress);
			t_date.setText(String.valueOf(date));
			t_title.setText(job_title);
			empname.setText("Welcome, "+name);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		repaint();
		revalidate();
		
		//applying listeners
		update.addActionListener(this);
		save.addActionListener(this);
		info.addMouseListener(this);
		trans.addMouseListener(this);
		bill.addMouseListener(this);

	}
	
	//main
	public static void main(String[] args) 
	{
		
	}
	
	//action listener
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==save)
		{
			int op = JOptionPane.showConfirmDialog(this,"Are you sure you wish to contiue?");
			 if(op==0)
			 {
				 t_id.setEditable(false);t_age.setEditable(false);t_contact.setEditable(false);t_title.setEditable(false);
					t_name.setEditable(false);ta1.setEditable(false);t_date.setEditable(false);p.setEditable(false);
					
					String insname=t_name.getText();
					int insempid=Integer.parseInt(t_id.getText());
					char[] insmanpass=p.getPassword();
					int insempage=Integer.parseInt(t_age.getText());
					String insempaddress=ta1.getText();
					String inscontact=t_contact.getText();
					
					
					try
					{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
					Statement stat=con.createStatement();
		String quer="update employee set name='"+insname+"',password='"+String.valueOf(insmanpass)+""
				+ "',age='"+insempage+"',address='"+insempaddress+"',contact='"+inscontact+"' where id='"+Home.id+"'";
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
			 
			t_contact.setEditable(true);p.setEditable(true);ta1.setEditable(true);p.setEditable(true);
			t_name.setEditable(true);ta1.setEditable(true);t_age.setEditable(true);
		
			 }
		if(ae.getSource()==cb)
		{
			String combo=String.valueOf(cb.getSelectedItem());
		}
	}
	//mouse listener
	public void mouseClicked(MouseEvent me) 
	{
		if(me.getSource()==info)
		{
			right.setVisible(true);
		}
		if(me.getSource()==trans)
		{
			new Transactions();
		}
		if(me.getSource()==bill)
		{
			Billing ob=new Billing();
			ob.function();
			ob.ins_function();
		}
	}
public void mouseEntered(MouseEvent arg0) {	
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {	
	}
}
