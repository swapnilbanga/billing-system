package test;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;

public class Customer extends JFrame implements ActionListener
{

	Font f,f1,f2,f3,f4;
	JTable customer;
	DefaultTableModel model;
	JTextField t_name;
	JLabel l;
	JButton search,remove,update;
	Connection con;
	Statement stat;
	int i,j;
	String name;
	
	Customer()
	{
		setVisible(true);
		setLayout(null);
		setSize(960,650);
		setResizable(false);
		setTitle("Customer Details");
		
		//font
		f=new Font("Rockwell",Font.PLAIN,50);
		f1=new Font("Rockwell",Font.PLAIN,26);
		f2=new Font("Rockwell",Font.PLAIN,22);
		f3=new Font("Rockwell",Font.BOLD,16);
		f4=new Font("Rockwell",Font.PLAIN,20);
		
		//table
		String []column={"Name","E-mail","Order No.","Amount","Address","Contact Number"};
		String [][]rows=new String[20][20];
		customer=new JTable(rows,column);
		
		customer.setPreferredScrollableViewportSize(new Dimension(750,300));
		
		//customer.setRowHeight(25);
		//customer.setFont(f);
		//customer.getTableHeader().setFont(f);
		
		
		//table width
		customer.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		customer.getColumnModel().getColumn(0).setPreferredWidth(120);
		customer.getColumnModel().getColumn(1).setPreferredWidth(160);
		customer.getColumnModel().getColumn(2).setPreferredWidth(80);
		customer.getColumnModel().getColumn(3).setPreferredWidth(120);
		customer.getColumnModel().getColumn(4).setPreferredWidth(120);
		customer.getColumnModel().getColumn(5).setPreferredWidth(120);
		JScrollPane sp=new JScrollPane(customer);
		
				
		//table sorter
		customer.setAutoCreateRowSorter(true);
		
		//table width false
	    customer.getTableHeader().setResizingAllowed(false);
	   // customer.getTableHeader().setReorderingAllowed(false);
		
		//textfield
		t_name=new JTextField(20);t_name.setFont(f3);
		
		//label
		l=new JLabel("Enter customer name:");l.setFont(f2);
		
		//button
		search=new JButton("Search");search.setFont(f3);
		remove=new JButton("Remove");remove.setFont(f3);
		update=new JButton("Update");update.setFont(f3);
		
		customer.setBounds(50,150,950,300);
		t_name.setBounds(50,65,400,25);
		customer.setBounds(50,150,750,300);
		sp.setBounds(customer.getBounds());
		l.setBounds(50,20,300,25);
		search.setBounds(480,65,100,25);
		
		add(t_name);add(l);add(search);add(sp);
		search.addActionListener(this);
		
		repaint();
		revalidate();
	}
	
	void ins_function()
	{
		i=0;j=0;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
			stat=con.createStatement();
			String quer="SELECT*FROM customer";
			ResultSet result=stat.executeQuery(quer);
			  while(result.next())
			    {
			    //System.out.println(i);
				  	String cusname=result.getString("Name");
				  	String cusphone =result.getString("phone");
				    String cusmail=result.getString("e_mail");
				    int order_no=result.getInt("order_no");
				    Float order_amount=result.getFloat("order_amount");
				    String address=result.getString("customer_address");
				    
				   // customer.setValueAt(String.valueOf(i+1), i, j-1);
				    customer.setValueAt(cusname, i, j);
				    customer.setValueAt(cusmail, i, j+1);
				    customer.setValueAt(String.valueOf(order_no), i, j+2);
				    customer.setValueAt(String.valueOf(order_amount), i, j+3);
				    customer.setValueAt(address, i, j+4);
				    customer.setValueAt(String.valueOf(cusphone), i, j+5);
				    
				   
				    i++;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==search)
		{
			if(t_name.getText().isEmpty())
			{
				ins_function();
			}
			else
			{
				for(i=0;i<20;i++)
				{
					for(j=0;j<6;j++)
					{
						customer.setValueAt("", i, j);
					}
				}
				name=t_name.getText();
				System.out.println(name);
			i=0;j=0;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				stat=con.createStatement();
				String quer="SELECT*FROM customer where name= "+"'"+name+"'";
				ResultSet result=stat.executeQuery(quer);
				  while(result.next())
				    {
				    //System.out.println(i);
					  	String cusname=result.getString("Name");
					  	String cusphone =result.getString("phone");
					    String cusmail=result.getString("e_mail");
					    int order_no=result.getInt("order_no");
					    Float order_amount=result.getFloat("order_amount");
					    String address=result.getString("customer_address");
					    
					   // customer.setValueAt(String.valueOf(i+1), i, j-1);
					    customer.setValueAt(cusname, i, j);
					    customer.setValueAt(cusmail, i, j+1);
					    customer.setValueAt(String.valueOf(order_no), i, j+2);
					    customer.setValueAt(String.valueOf(order_amount), i, j+3);
					    customer.setValueAt(address, i, j+4);
					    customer.setValueAt(String.valueOf(cusphone), i, j+5);
					    
					   
					    i++;
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		Customer object=new Customer(); 
		object.ins_function();
		
	}


}

