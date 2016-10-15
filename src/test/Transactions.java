package test;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

public class Transactions extends JFrame implements ActionListener {
				
	String[][] defaultvalues=new String[20][20];
	String[] columns={"S. No.","Customer Name","Customer E-Mail","Customer Phone","Order No.","Order Amount","Order Date","Server",
			};
	JLabel restaurant,head,or1,head2,head3,or2;
	JButton view,view1,view2;
	JTable trans;
	JTextField number,datein;
	String cusname,cusmail,cusaddress,date,strdate,serverstr,cusphone;
	String empty="";
	float order_amount;
	int order_no;
	
	int n,i,j,a,b;
	
	
//CONSTRUCTOR
	
	Transactions()
			{	
			
			
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
			date=sdf.format(dt);
			
			java.util.Date dt1 = new java.util.Date();
			strdate=sdf.format(dt1);
			
			  setSize(950,650);
		      setVisible(true);
		      setResizable(false);
		      setLayout(null);
		      
		      restaurant=new JLabel("Restaurant");
		      restaurant.setFont(new Font("Rockwell",Font.PLAIN,42));
		      head=new JLabel("Enter the number of transactions to view:");
		      or1=new JLabel("OR");
		      or2=new JLabel("OR");
		      head2=new JLabel("View today's all transactions");
		      head3=new JLabel("View transactions on a specific day");
		      Font font=new Font("Rockwell",Font.ITALIC,18);
		      head.setFont(font);head2.setFont(font);head3.setFont(font);
		      view=new JButton("View");
		      view1=new JButton("View");
		      view2=new JButton("View");
		      final JTextField number=new JTextField(2);
		      datein=new JTextField("yyyy-mm-dd");
		      trans=new JTable(defaultvalues,columns);
		      trans.setPreferredScrollableViewportSize(new Dimension(500,300));
		      trans.getColumnModel().getColumn(0).setPreferredWidth(45);
		      trans.getColumnModel().getColumn(1).setPreferredWidth(120);
		      trans.getColumnModel().getColumn(2).setPreferredWidth(160);
		      trans.getColumnModel().getColumn(3).setPreferredWidth(120);
		      trans.getColumnModel().getColumn(4).setPreferredWidth(60);
		      trans.getColumnModel().getColumn(5).setPreferredWidth(100);
		      trans.getColumnModel().getColumn(6).setPreferredWidth(80);
		      trans.getColumnModel().getColumn(7).setPreferredWidth(100);
		      
		      
		      JScrollPane sp=new JScrollPane(trans);
		      view.addActionListener(this);view2.addActionListener(this);view1.addActionListener(this);
		      
		      trans.setBounds(50,300,800,200);
		      sp.setBounds(trans.getBounds());
		      restaurant.setBounds(365,20,250,80);
		      or1.setBounds(50,220,350,25);
		      or2.setBounds(50,160,350,25);
		      head2.setBounds(50,190,350,25);
		      head3.setBounds(50,130,350,25);
		      head.setBounds(50,250,350,25);
		      datein.setBounds(350,130,100,30);
		      setBounds(190,50,960,650);
		      number.setBounds(390,250,30,30);
		      view2.setBounds(470,130,80,30);
		      view1.setBounds(300,190,80,30);
		      view.setBounds(440,250,80,30);
		      add(sp);add(restaurant);add(head);add(view);add(number);add(head2);add(or1);add(view1);add(head3);add(view2);
		      add(or2);add(datein);
		      
		      trans.getTableHeader().setResizingAllowed(false);
			  trans.getTableHeader().setReorderingAllowed(false);
			  trans.setAutoCreateRowSorter(true);
			  
		      repaint();
		      revalidate();
		      
// GET NUMBER OF TRANSACTIONS FROM USER
		      
		      number.getDocument().addDocumentListener(new DocumentListener() {
		    	  public void changedUpdate(DocumentEvent e) {
		    	    warn();
		    	  }
		    	  public void removeUpdate(DocumentEvent e) {
		    	    warn();
		    	  }
		    	  public void insertUpdate(DocumentEvent e) {
		    	    warn();
		    	  }

		    	  public void warn() {
		    		  if(number.getText().isEmpty()==false)
		    		  {
		    	     if (Integer.parseInt(number.getText())<=0||Integer.parseInt(number.getText())>20){
		    	       JOptionPane.showMessageDialog(null,
		    	          "Please enter a number between 1 and 20", "Error Massage",
		    	          JOptionPane.ERROR_MESSAGE);
		    	      
		    	     }
		    	       else
		    	    	   n=Integer.parseInt(number.getText());
		    	     
		    	  }
		    	  }
		      });
		      
		      
					}
	


	@Override
	public void actionPerformed(ActionEvent action) {
		
		if(action.getSource()==view)
		{	
			for(a=0;a<19;a++)
			{
				for(b=0;b<8;b++)
				{
					trans.setValueAt("", a, b);
				}
			}
			
			
			i=0;j=1;
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				Statement stat=con.createStatement();
				String quer="SELECT*FROM customer ORDER BY order_no DESC LIMIT "+""+n+"";
				ResultSet result=stat.executeQuery(quer);
				  while(result.next())
				    {
				    //System.out.println(i);
					  	cusname=result.getString("Name");
					    cusphone =result.getString("phone");
					    cusmail=result.getString("e_mail");
					    order_no=result.getInt("order_no");
					    order_amount=result.getFloat("order_amount");
					    strdate=result.getDate("Order_Date").toString();
					    serverstr=result.getString("server");
					    
					    trans.setValueAt(String.valueOf(i+1), i, j-1);
					    trans.setValueAt(cusname, i, j);
					    trans.setValueAt(cusmail, i, j+1);
					    trans.setValueAt(String.valueOf(cusphone), i, j+2);
					    trans.setValueAt(String.valueOf(order_no), i, j+3);
					    trans.setValueAt(String.valueOf(order_amount), i, j+4);
					    trans.setValueAt(String.valueOf(strdate), i, j+5);
					    trans.setValueAt(serverstr, i, j+6);
					    i++;
				    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
			
//VIEW TODAY'S TRANSACTIONS
		
		if(action.getSource()==view1)
			{	
				getvalues();
			}
		
//VIEW TRANSACTIONS ON A SPECIFIC DAY
		
			if(action.getSource()==view2)
			{	
					date=datein.getText();
					getvalues();
			}
	}
	
		public void getvalues()
		{
			
			for(a=0;a<19;a++)
			{
				for(b=0;b<8;b++)
				{
					trans.setValueAt(empty, a, b);
				}
			}
			
			i=0;j=1;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				Statement stat=con.createStatement();
				String quer="SELECT*FROM customer where Order_Date= "+"'"+date+"'";
				System.out.println(date);
				ResultSet result=stat.executeQuery(quer);
				while(result.next())
				{
					cusname=result.getString("Name");
				    cusphone =result.getString("phone");
				    cusmail=result.getString("e_mail");
				    order_no=result.getInt("order_no");
				    order_amount=result.getFloat("order_amount");
				    strdate=result.getDate("Order_Date").toString();
				    serverstr=result.getString("server");
				    
				    trans.setValueAt(String.valueOf(i+1), i, j-1);
				    trans.setValueAt(cusname, i, j);
				    trans.setValueAt(cusmail, i, j+1);
				    trans.setValueAt(String.valueOf(cusphone), i, j+2);
				    trans.setValueAt(String.valueOf(order_no), i, j+3);
				    trans.setValueAt(String.valueOf(order_amount), i, j+4);
				    trans.setValueAt(String.valueOf(strdate), i, j+5);
				    trans.setValueAt(serverstr, i, j+6);
				    i++; 
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		}

		public static void main(String[] args) 
		{
			
			Transactions object=new Transactions();

		}
	}

