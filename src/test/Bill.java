package test;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.lang.Math.*;
import java.math.BigInteger;

import test.*;
import java.io.*;

public class Bill extends JFrame implements ActionListener {
	JLabel restaurant,l1,head,cusname,cusphone,cusmail,orderno,orderamount,cusadd,server;
	JTable billtable;
	JTextField t_cusname,t_cusphone,t_cusmail,t_orderno,t_orderamount,t_server;
	JTextArea t_cusadd;
	JButton done,submit;
	String name,value,serverstr;
	Font common=new Font("Rockwell",Font.PLAIN,15);
	int quantity,amount;
	int x,y,row,col,length;
	int i=0;
	String[][] defaultvalues=new String[20][20];
	float total2,tax;
	
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
	String date=sdf.format(dt);
	
	String[] columns={"Name","Quantity","Amount"};
	

	Bill()
	{		
		
		// INITIALIZE 
		total2=0;
		for(int a=0;a<=19;a++)
		{
			for(int b=0;b<=19;b++)
			{
				defaultvalues[a][b]="";	
			}
		}
		
		
		
		x=0;y=0;
		
	      setSize(950,650);
	      setVisible(true);
	      setResizable(false);
	      setLayout(null);
	      l1=new JLabel("Bill created and saved as a text file."); l1.setFont(new Font("Rockwell",Font.PLAIN,16));
	      restaurant=new JLabel("Restaurant");restaurant.setFont(new Font("Rockwell",Font.PLAIN,42));
	      head=new JLabel("Please fill in the following info:");
	      head.setFont(new Font("Rockwell",Font.ITALIC,18));
	      billtable=new JTable(defaultvalues,columns);
	      billtable.setPreferredScrollableViewportSize(new Dimension(400,300));
	      JScrollPane sp=new JScrollPane(billtable);
	      cusname=new JLabel("Customer Name");
	      server=new JLabel("Server");server.setFont(common);
	      cusphone=new JLabel("Phone Number");
	      cusmail=new JLabel("Customer E-Mail");
	      cusadd=new JLabel("Customer Address");
	      orderno=new JLabel("Order No.");
	      orderamount=new JLabel("Order Amount");
	      t_server=new JTextField(30);
	      t_cusname=new JTextField(30);
	      t_cusphone=new JTextField(30);
	      t_cusmail=new JTextField(30);
	      t_cusadd=new JTextArea(30,50);
	      t_cusadd.setLineWrap(true);
	      t_orderno=new JTextField(30);
	      t_orderamount=new JTextField(30);
	      done=new JButton("Done");
	      submit=new JButton("Submit");
			
	      Border border = BorderFactory.createLineBorder(Color.gray);
	      t_cusadd.setBorder(border);
	      
	      
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				Statement stat=con.createStatement();
				String quer="select*from selected";
				ResultSet result=stat.executeQuery(quer);
				while(result.next())
				{
					name=result.getString("Name");
					quantity=result.getInt("Quantity");
					amount=result.getInt("Amount");
					billtable.setValueAt(name, x, y);
				    billtable.setValueAt(String.valueOf(quantity), x, y+1);
				    billtable.setValueAt(String.valueOf(amount), x, y+2);
				    x++;
				}
				total2=(float) Billing.total1;
				tax=(float) (total2*0.135);
				
				System.out.println(total2);
				
				
				billtable.setValueAt("Total", x+1, y);
				billtable.setValueAt(String.valueOf(total2),x+1,y+2);
				billtable.setValueAt("Tax", x+2, y);
				billtable.setValueAt(String.valueOf(tax), x+2, y+2);
				billtable.setValueAt("Grand Total",x+3,y);
				total2=total2+tax;
				billtable.setValueAt(String.valueOf(total2),x+3,y+2);
				t_orderamount.setText(String.valueOf(total2));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
//PRINT THE BILL
			
	//GET THE BILL NUMBER 	
			
			
			try 
			{
			BufferedReader br=new BufferedReader(new FileReader("H:/Project/Initializers/Values.txt"));
			value=br.readLine();
			i=Integer.parseInt(value);
			br.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			try
			{
			PrintWriter writer=new PrintWriter("H:/Project/Initializers/Values.txt");
			i=i+1;
			writer.print(String.valueOf(i));
			writer.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		t_orderno.setText(value);
		
	//CREATE A NEW FOLDER
			
			File dir=new File("H:/Project/Bills/"+date);
			dir.mkdir();
			
			
	//CREATE A NEW TEXT FILE 
			try
			{
			File f=new File("H:/Project/Bills/"+date+'/'+"bill"+i+".txt");	
			PrintWriter stream=new PrintWriter(f);
			stream.print("Order Number: "+i);
			stream.println('\n');
			stream.println("");
			
			for(col=0;col<billtable.getColumnCount();col++)
			{
				stream.print(billtable.getColumnName(col));
				stream.print("              ");
			}
			stream.println("");
			for(row=0;row<billtable.getRowCount();row++)
			{
				for(col=0;col<billtable.getColumnCount();col++)
				{	
					
					stream.print(billtable.getValueAt(row,col));
					length=billtable.getValueAt(row,col).toString().length();
					for(int w=0;w<=20-length;w++)
					{
						stream.print(" ");
					}
				}
				stream.println();
			}
			stream.close();
			} 
			
			catch (FileNotFoundException e) {
			
				e.printStackTrace();
			}
			
			
			
		
			
			
			l1.setBounds(500,400,300,30);
			done.setBounds(770,400,70,25);
			submit.setBounds(180,500,80,25);
			billtable.setBounds(500, 170, 400, 200);
			sp.setBounds(billtable.getBounds());
			
			restaurant.setBounds(365,20,250,80);
			head.setBounds(50,120,300,40);
			
			  cusname.setBounds(50,170,150,20);
		      cusphone.setBounds(50,205,150,20);
		      cusmail.setBounds(50,240,150,20);
		      cusadd.setBounds(50,275,150,20);
		      orderno.setBounds(50,360,150,20);
		      orderamount.setBounds(50,395,150,20);
		      server.setBounds(50,430,150,20);
		     
		      cusname.setFont(common);cusphone.setFont(common);cusmail.setFont(common);cusadd.setFont(common);
		      orderno.setFont(common);orderamount.setFont(common);
		      
		      t_cusname.setBounds(250,170,150,25);
		      t_cusphone.setBounds(250,205,150,25);
		      t_cusmail.setBounds(250,240,150,25);
		      t_cusadd.setBounds(250,275,150,65);
		      t_orderno.setBounds(250,360,150,25);
		      t_orderamount.setBounds(250,395,150,25);
		      t_server.setBounds(250,430,150,25);
		      
			
			
			
			done.addActionListener(this);submit.addActionListener(this);
			add(submit);add(sp);
			add(cusname);add(cusphone);add(cusmail);add(cusadd);add(orderno);add(orderamount);add(server);
			add(t_cusname);add(t_cusphone);add(t_cusmail);add(t_cusadd);add(t_orderno);add(t_orderamount);add(t_server);
			add(head);add(restaurant);
			repaint();
			revalidate();
	}
	
	//FORM SUBMITTED
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)                                                      
		{	
			
			String name=t_cusname.getText();
			
			String e_mail=t_cusmail.getText();
			String address=t_cusadd.getText();
			String order_no=t_orderno.getText();
			double order_amount=Double.parseDouble(t_orderamount.getText());
			String serverstr=t_server.getText();
			
			if(name.isEmpty()||e_mail.isEmpty()||address.isEmpty()||t_cusphone.getText().isEmpty()||serverstr.isEmpty())
			{
				 JOptionPane.showMessageDialog(getContentPane(), "One or more fields are empty.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{		
					String phone=t_cusphone.getText();
					try
					{
					Connection con=null;
					Statement stmt1=null;
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador"); 
					stmt1=con.createStatement();
			String query="insert into customer values('"+name+"','"+e_mail+"','"+order_no+"','"+order_amount+"','"+date+"','"+serverstr+"','"+address+"','"+phone+"')";
					stmt1.executeUpdate(query);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
			
			
			add(l1);add(done);remove(submit);
			repaint();revalidate();
			}
			
		}
		
//SUCCESSFULLY SUBMITTED 
		
		if(ae.getSource()==done)
		{
			JOptionPane.showInternalMessageDialog(getContentPane(), "Returning to the previous window...");
			
			/*Connection con4=null;
			Statement stat=null;
			try{
			con4=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
			stat=con4.createStatement();
			String clear="truncate selected";
			stat.executeUpdate(clear);
			}
			catch(Exception e4)
			{
				e4.printStackTrace();
			}
			*/
			
			new Billing().function();
			dispose();
			
		}
		
		
	}
	public static void main(String[] args) 
	{
		Bill object=new Bill();
		
	}

}
