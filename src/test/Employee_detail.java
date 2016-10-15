package test;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import test.*;

public class Employee_detail extends JFrame implements ActionListener,KeyListener
{

	JLabel l1;
	JTextField t1;
	JButton b1,b2;
	Font f,f1,f2,f3,f4;
	public static int id_detail;
	
	public void emp()
	{
		setVisible(true);
		setResizable(false);
		setSize(296,125);
		setTitle("Input");
		setLayout(null);
	
		//font
		f=new Font("Rockwell",Font.PLAIN,50);
		f1=new Font("Rockwell",Font.PLAIN,26);
		f2=new Font("Rockwell",Font.PLAIN,22);
		f3=new Font("Rockwell",Font.BOLD,16);
		f4=new Font("Rockwell",Font.PLAIN,20);
		
		//Label 
		l1=new JLabel("Enter Employee ID:");
		
		//TextField
		t1=new JTextField(20);
		
		//Button
		b1=new JButton("OK");
		b2=new JButton("Cancel");
		
		//setBounds
		l1.setBounds(60,10,150,20);
		t1.setBounds(60,35,220,24);
		b1.setBounds(90,60,72,22);
		b2.setBounds(170,60,73,22);
		setBounds(350,270,296,125);
		
		add(l1);add(t1);add(b1);add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.addKeyListener(this);
		b2.addKeyListener(this);
		
		
		
		repaint();
		revalidate();
	}
	public static void main(String[] args) 
	{
		Employee_detail em=new Employee_detail();
		em.emp();
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(ae.getSource()==b1)
		{	
		
		if(t1.getText().isEmpty())
		{
			dispose();
		}
		else
		{
				id_detail=Integer.parseInt(t1.getText());
				Employee.id1=id_detail;
				Employee emp=new Employee();
				emp.fun(id_detail);
				dispose();
				
		}
		}
		if(ae.getSource()==b2)
		{
			dispose();
		}
		
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource()==b1)
		{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{	
			id_detail=Integer.parseInt(t1.getText());
			if(t1.getText().isEmpty())
			{
				dispose();
			}
			else
			{	
				Employee.id1=id_detail;
				Employee se=new Employee();
				se.fun(id_detail);
				dispose();
			}
	}

}
		if(e.getSource()==b2)
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				dispose();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

