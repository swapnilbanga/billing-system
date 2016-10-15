package test;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.UIManager;
import com.sun.java.swing.plaf.nimbus.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.sql.*;

public class Home extends JFrame implements ActionListener
{
	JPanel p1,p2,p3;
	JLabel name,manlogin,emplogin,manid,empid,manpass,emppass,l8,labelimg1,labelimg2,labelimg3,lamanbutton,laempbutton,lab3,lab4;
	JTextField manidtext,empidtext;
	JButton manbutton,empbutton,proceed;
	JPasswordField manpastext,emppastext;
	Font f,f1,f2,f3,f4;
	JFrame frame=new JFrame();
	public static int id;
	public static String manname;
	
	void function()
	{
		
		setVisible(true);
		setLayout(null);
		setSize(960,650);
		setResizable(false);
		setTitle("Title");
		
		 //Set Theme
	    try
	    {
	    	for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels())
	    	{
	    		if("Nimbus".equals(info.getName()))
	    		{
	    			UIManager.setLookAndFeel(info.getClassName());
	    			SwingUtilities.updateComponentTreeUI(frame);
	    			break;
	    		}
	    	}
	    } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException  ex)
	    {
	    	ex.printStackTrace();
	    }
		
		f=new Font("Rockwell",Font.PLAIN,50);
		f1=new Font("Rockwell",Font.PLAIN,26);
		f2=new Font("Rockwell",Font.PLAIN,19);
		f3=new Font("Rockwell",Font.BOLD,18);
		f4=new Font("Rockwell",Font.PLAIN,16);
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		
		labelimg1=new JLabel(new ImageIcon(getClass().getResource("food1.jpg")));
		labelimg2=new JLabel(new ImageIcon(getClass().getResource("food2.jpg")));
		labelimg3=new JLabel(new ImageIcon(getClass().getResource("food3.jpg")));
		
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		name=new JLabel("Restaurant");name.setFont(f);
		manlogin=new JLabel("Manager Login");manlogin.setFont(f1);
		emplogin=new JLabel("Employee Login");emplogin.setFont(f1);
		manid=new JLabel("Username:");manid.setFont(f2);
		empid=new JLabel("Username:");empid.setFont(f2);
		manpass=new JLabel("Password:");manpass.setFont(f2);
		emppass=new JLabel("Password:");emppass.setFont(f2);
		lamanbutton=new JLabel("After logging in, you can:");lamanbutton.setFont(f3);
		laempbutton=new JLabel("After logging in, you can:");laempbutton.setFont(f3);
		lab3=new JLabel("<html><ul>"+"<li>Create a new bill</li>"+"<li>Last five transactions</li>"+
		"<li>Update your details</li>"+"</ul></html>");lab3.setFont(f4);
		lab4=new JLabel("<html><ul>"+"<li>Add new employee accounts</li>"+"<li>Manage Inventory</li>"+
		"<li>Make changes to the menu</li>"+"<li>View customer details</li>"+"</ul></html>");
		lab4.setFont(f4);
		
		manpastext=new JPasswordField();
		emppastext=new JPasswordField();
		
		manidtext=new JTextField(20);
		empidtext=new JTextField(20);
		
		manbutton=new JButton("Login");
		empbutton=new JButton("Login");
		
		name.setBounds(323,30,900,50);
		
		labelimg1.setBounds(00,00,960,119);
		labelimg2.setBounds(00,00,479,530);
		labelimg3.setBounds(00,00,479,530);
		
		p1.setBounds(00,00,960,120);
		p3.setBounds(00,120,480,530);
		p2.setBounds(480,120,480,530);
		
		emplogin.setBounds(20,20,250,40);
		empid.setBounds(80,80,120,20);
		empidtext.setBounds(80,110,160,25);
		emppass.setBounds(80,150,120,20);
		emppastext.setBounds(80,180,160,25);
		empbutton.setBounds(200,240,90,32);
		
		manlogin.setBounds(20,20,250,40);
		manid.setBounds(80,80,120,20);
		manidtext.setBounds(80,110,160,25);
		manpass.setBounds(80,150,120,20);
		manpastext.setBounds(80,180,160,25);
		manbutton.setBounds(200,240,90,32);
		lamanbutton.setBounds(20,315,250,40);
		laempbutton.setBounds(20,315,250,40);
		lab3.setBounds(30,285,300,200);
		lab4.setBounds(30,300,300,200);
		setBounds(190,50,960,650);
		
		add(p1);add(p2);add(p3);p1.add(name);p2.add(laempbutton);p2.add(lab4);p3.add(lamanbutton);p3.add(lab3);
		p3.add(emplogin);p3.add(empid);p3.add(emppass);p3.add(emppastext);p3.add(empidtext);p3.add(empbutton);
		p2.add(manlogin);p2.add(manid);p2.add(manpass);p2.add(manpastext);p2.add(manidtext);p2.add(manbutton);
		
		p1.add(labelimg1);p2.add(labelimg3);p3.add(labelimg2);
		
		
		manbutton.addActionListener(this);
		empbutton.addActionListener(this);
		
		repaint();
		revalidate();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==empbutton)
		{	
			
			if(!empidtext.getText().isEmpty())
			id=Integer.parseInt(empidtext.getText());
			char[] emppass=emppastext.getPassword();
			String emppassstr=String.copyValueOf(emppass);
			if(empidtext.getText().isEmpty()||emppass.length==0)
			{
				JOptionPane.showMessageDialog(getContentPane(), "Please enter your credentials first");
			}

			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
			Statement stat=con.createStatement();
			String quer="select password from employee where id='"+id+"'";
			ResultSet rs=stat.executeQuery(quer);
			while(rs.next())
			{
			if(rs.getString("password").equals(emppassstr))
			{
				Employee emp=new Employee();
				emp.fun(Home.id);
				emppastext.setText("");
				empidtext.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(getContentPane(), "Please check your details");
			}
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
		}
		if(ae.getSource()==manbutton)
		{
			if(!manidtext.getText().isEmpty())
			id=Integer.parseInt(manidtext.getText());
			
			System.out.println(id);
			char[] manpass=manpastext.getPassword();
			String manpassstr=String.copyValueOf(manpass);
			if(manidtext.getText().isEmpty()||manpass.length==0)
			{
				JOptionPane.showMessageDialog(getContentPane(), "Please enter your credentials first");
			}
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
			Statement stat=con.createStatement();
			String quer="select password,name from manager where id='"+id+"'";
			ResultSet rs=stat.executeQuery(quer);
			while(rs.next())
			{
			manname=rs.getString("name");
			if(rs.getString("password").equals(manpassstr))
			{
				Manager man=new Manager();
				man.function1();
				manpastext.setText("");
				manidtext.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(getContentPane(), "Please check your details");
			}
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		if(ae.getSource()==proceed)
		{
			frame.setVisible(true);
			frame.setSize(100,100);
		} 
	
	}
	
	
	public static void main(String[] args)  
	{
		Home c=new Home();
		c.function();
	}

}

