package test;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import test.*;

public class Manager extends JFrame implements MouseListener
{
	JPanel top,left,right;
	JLabel name,manname1,manager,New_accounts,menu,customer,emp_detail,inventory,backimagetop,backimageleft,backimageright;
	JButton first,second,third,fourth,fifth,sixth;
	Font f,f1,f2,f3,f4;
	
	public void  function1()
	{
		setVisible(true);
		setLayout(null);
		setSize(950,650);
		setResizable(false);
		setTitle("Manager Desk");
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
		
		//lables declared
		name=new JLabel("Restaurant");name.setFont(f);
		manname1=new JLabel("Welcome, "+Home.manname);manname1.setFont(f2);
		
		//images de right panel
		New_accounts=new JLabel(new ImageIcon(getClass().getResource("accounts.jpg")));
		menu=new JLabel(new ImageIcon(getClass().getResource("menu.jpg")));
		manager=new JLabel(new ImageIcon(getClass().getResource("manager.jpg")));
		emp_detail=new JLabel(new ImageIcon(getClass().getResource("user.png")));
		inventory=new JLabel(new ImageIcon(getClass().getResource("inventory1.jpg")));
		customer=new JLabel(new ImageIcon(getClass().getResource("customer.jpg")));
		
		//set tool tip text
		manager.setToolTipText("View Manager Details");
		New_accounts.setToolTipText("Add new New_accounts");
		menu.setToolTipText("Update menu");
		emp_detail.setToolTipText("Update Employee Details");
		customer.setToolTipText("View Customer Details");
		inventory.setToolTipText("Manage Inventory");
		
		//cursor on image
		manager.setCursor(new Cursor(Cursor.HAND_CURSOR));
		New_accounts.setCursor(new Cursor(Cursor.HAND_CURSOR));
		emp_detail.setCursor(new Cursor(Cursor.HAND_CURSOR));
		inventory.setCursor(new Cursor(Cursor.HAND_CURSOR));
		customer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//making images button
		first=new JButton("manager.jpg");
		second=new JButton("New_accounts.jpg");
		third=new JButton("menu.jpg");
		fourth=new JButton("user.png");
		fifth=new JButton("customer.jpg");
		sixth=new JButton("inventory.jpg");
		
		//background images
		backimagetop=new JLabel(new ImageIcon(getClass().getResource("grey1.jpg")));
		backimageleft=new JLabel(new ImageIcon(getClass().getResource("grey2.jpg")));
		backimageright=new JLabel(new ImageIcon(getClass().getResource("grey3.jpg")));
		
		//border on panel
		top.setBorder(BorderFactory.createLineBorder(Color.black));
		left.setBorder(BorderFactory.createLineBorder(Color.black));
		right.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//set Bounds
		top.setBounds(00,00,960,121);
		left.setBounds(00,120,199,530);
		right.setBounds(147,120,809,530);
		name.setBounds(323,30,900,50);
		manname1.setBounds(10,00,400,50);
		backimagetop.setBounds(00,00,959,120);
		backimageleft.setBounds(00,00,198,530);
		backimageright.setBounds(00,00,857,530);setBounds(190,50,960,650);
		New_accounts.setBounds(325,45,200,200);menu.setBounds(560,45,200,200);
		manager.setBounds(90,45,200,200);emp_detail.setBounds(90,270,200,200);
		customer.setBounds(325,270,200,200);inventory.setBounds(560,270,200,200);
		
		//adding declarations
		add(top);add(left);add(right);top.add(name);left.add(manname1);right.add(New_accounts);
		right.add(manager);right.add(menu);right.add(customer);right.add(emp_detail);right.add(inventory);
		
		//adding background images
		top.add(backimagetop);left.add(backimageleft);right.add(backimageright);
		
		//adding mouselisteners
		manager.addMouseListener(this);
		New_accounts.addMouseListener(this);
		menu.addMouseListener(this);
		emp_detail.addMouseListener(this);
		customer.addMouseListener(this);
		inventory.addMouseListener(this);
		
		
		repaint();
		revalidate();
	}
	
	public static void main(String[] args) 
	{
	Manager man=new Manager();
	man.function1();
	}

	@Override
	public void mouseClicked(MouseEvent me) 
	{
		if(me.getSource()==manager)
		{
			System.out.println("manager");
		}
		
		if(me.getSource()==New_accounts)
		{
			New_account ob=new New_account();
			ob.function2();
		}
		
		if(me.getSource()==menu)
		{
			Menu obj=new Menu();
			obj.ins_function();
			
		}
		
		if(me.getSource()==emp_detail)
		{
			Employee_detail e=new Employee_detail();
			e.emp();
			//String input=JOptionPane.showInputDialog("Enter Employyee ID:");
		}
		
		if(me.getSource()==customer)
		{
			Customer obj=new Customer();
			obj.ins_function();
		}
		
		if(me.getSource()==inventory)
		{
			Inventory obj=new Inventory();
			obj.ins_function();
		}
		
		if(me.getSource()==manager)
		{
			Manager_detail man=new Manager_detail();
			man.fun2();
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

