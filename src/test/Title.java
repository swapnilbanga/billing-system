package test;
import java.awt.*;
import java.awt.event.*;

import javax.swing.UIManager.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import com.sun.java.swing.plaf.nimbus.*;
import test.Bill;
import java.util.function.Function;

public class Title extends JFrame implements ActionListener,WindowListener
{	//table 1
	String[][] s3={{"One","Two","Three",""},{"Five","Four","six",""},
			{"Five","Four","six",""},{"Five","Four","six",""},{"Five","Four","six",""}};
	String[] cols={"Name","Detail","Price","Quantity"};	
	//table 2
	
	String[] democols={"Name","Quantity","Amount"};	
	String[][] demodata=new String[20][20];
	String empty=null;
	public static double total1;
	double total,amount;
	String quan;
	String amount2;
	int flag,l,m;
	JButton Submit;
	
	JTable table,demotab;
	String name,detail,quantity;
	double price;
	JFrame J=new JFrame();
	JLabel l1,l2,l3,l4,l5,l6,l7,la8,label9,label10,
	label11,label12,label13,label14,label15;
	JTextField t1,t2,t3,t4;
	JButton emplog,search,transfer;
	
	
	
	Font f1=new Font("Segoe Print",Font.ROMAN_BASELINE,40);
	Font f2=new Font("Rockwell",Font.PLAIN,22);
	Font f3=new Font("Rockwell",Font.PLAIN,18);
	
	String jdbc_driver = "com.mysql.jdbc.Driver"; 	//External connector required 
	String db_url = "jdbc:mysql://localhost/db";	//Fixed path

	   //  Database credentials
	   	String user = "root";
	   	String pass = "aventador";
	   	String s1,s2;
		int i=0,j=0;
		/*
		void func() 
	{				
		Connection con=null;
		Statement stmt1=null;
		Statement stmt2=null;
				try
				{
				Class.forName(jdbc_driver);
		con=DriverManager.getConnection(db_url,user,pass); //here db-database,root-username, and aventador-password  
				stmt1=con.createStatement();
				stmt2=con.createStatement();
				
				//sample query
				 ResultSet rs=stmt1.executeQuery("select*from emp");
				while(rs.next())
				{
				s1=rs.getString("name");
				System.out.println(s1);
				i=rs.getInt("contact");
				//System.out.println(i);
				}
				
				
				//read selected values
				Statement stat=con.createStatement();
				String op="select contact from emp where emp.id=11134 and emp.name='Angie'";
				 ResultSet rs2=stat.executeQuery(op);
				    while(rs2.next())
				    {
				   // System.out.println("");
				    s2=rs2.getString("contact");
			   // System.out.println(s2);
			    }
			    
			   // add values
			    String sql = "insert into emp values (10013, 'zara', 33367, 'cse')";
			     stat.executeUpdate(sql);
			    
			  // String sql1="delete from emp where emp.name='manan'";
			 //  stat.executeUpdate(sql1);
				con.close();
				}
				catch(Exception e)
				{
				System.out.println(e);
				}}
					*/
	
	 void Login()
	{	
//EMPTY THE ITEM TABLE
		 
		 
		 	amount=0.00;
		 	Connection con4=null;
			Statement stat4=null;
			try{
			con4=DriverManager.getConnection(db_url,user,pass);
			stat4=con4.createStatement();
			String clear="truncate selected";
			stat4.executeUpdate(clear);
			}
			catch(Exception e4)
			{
				e4.printStackTrace();
			}
//SET THEME
		 try {
			    for (LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) 
			    {
			        if ("Nimbus".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            SwingUtilities.updateComponentTreeUI(J);
			            break;
			        }
			    }
			    
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)  {
				ex.printStackTrace();
			}
		
//DEFINE EVERYTHING
		 
		
		setTitle("Restaurant");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setVisible(true);
		setSize(950,650);
		setResizable(true);
		l1=new JLabel("Restaurant");
		l2=new JLabel("Manager Login");
		l3=new JLabel("Employee Login");
		l4=new JLabel("ID:");
		l5=new JLabel("ID:");
		l6=new JLabel("Password:");
		l7=new JLabel("Password:");
		transfer=new JButton("Transfer");
		search=new JButton("Check");
		t1=new JTextField(20);
		t2=new JTextField(20);
		table=new JTable(s3,cols);
		table.setPreferredScrollableViewportSize(new Dimension(300,80));
		Submit=new JButton("Submit");
		demotab=new JTable(demodata,democols);
		demotab.setPreferredScrollableViewportSize(new Dimension(300,80));
		JScrollPane sp=new JScrollPane(table);
		JScrollPane sp1=new JScrollPane(demotab);
		
		
		t2=new JTextField(20); 
		t3=new JTextField(20);
		
		t4=new JTextField(5); //TOTAL
		add(t1);add(t2);add(t3);add(transfer);add(t2);add(t4);add(Submit);
		transfer.addActionListener(this);search.addActionListener(this);Submit.addActionListener(this);
		add(l1);add(search);
		t1.setText("Search");
		t2.setText("t2");
		t3.setText("t3");  //SEARCH
		t4.setText("0");
		add(sp);add(sp1);
		//t1.setText(s2);
		repaint();
	    revalidate();
	}
	
	public void actionPerformed(ActionEvent ae)
//WHEN SEARCHED
	{	j=0;i=0;
		if(ae.getSource()==search)
		{
		Connection con3=null;
		Statement stmt3=null; 
		String s5=t1.getText();
		String s6;

//REDUNDANT SPACES
		
		if((s5.charAt(0)==' ')||(s5.charAt(s5.length()-1)==' '))	
		{
		s5=s5.replaceAll("\\s+","");
		}
		if(s5.length()>=10)
		{	
		s6="select*from menu where concat(name,detail)="+"'"+s5+"'";
		}
		else
		s6="select*from menu where name="+"'"+s5+"'or detail="+"'"+s5+"'";
		
		
		
		
		
		try
		{	
		con3=DriverManager.getConnection(db_url,user,pass);
		stmt3=con3.createStatement();
		ResultSet rs3=stmt3.executeQuery(s6);
		    while(rs3.next())
		    {
		    //System.out.println(i);
		    name=rs3.getString("name");
		    detail=rs3.getString("detail");
		    price=rs3.getDouble("price");
		    quantity=rs3.getString("quantity");
		    table.setValueAt(name, i, j);
		    table.setValueAt(detail, i, j+1);
		    table.setValueAt(String.valueOf(price), i, j+2);
		    table.setValueAt(quantity, i, j+3);
		    i++; 
		    }
		    }
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
//SEARCH FAILS		
		if(i==0)
		{
		JOptionPane.showInternalMessageDialog(getContentPane(), "No items found for "+t1.getText()+". Please make sure all entered keywords are correct.");
		}
		else
		{
		 int k=i;
		    while(k<s3.length)
		    {	
		    	for(j=0;j<=3;j++)
		    	{
		    table.setValueAt(empty, k, j);
		    	}
		    	k++;
		    }	
		}
		}
			
// TRANSFER CONTENT TO DEMO TABLE
		
		if((ae.getSource()==transfer)&&(Integer.parseInt(t3.getText())!=0))
		{	
			 
			Connection con=null;
			Statement stat=null;
			try
			{
			con=DriverManager.getConnection(db_url,user,pass);
			stat=con.createStatement();
			t2.setText(String.valueOf(price));
			int i1=Integer.parseInt(t3.getText());
			
			quan=t3.getText().toString();
			amount=i1*price;
			amount2=String.valueOf(amount);
			
			stat.executeUpdate("insert into selected values ('"+name+"','"+quan+"', '"+amount+"')");
			
			total=total+amount;
			t1.setText(name);
			
			
//GET VALUES FROM DEMO TABLE			
			
			String s7="select*from menu where name="+"'"+name+"'";
			ResultSet rs4=stat.executeQuery(s7);
			    while(rs4.next())
			    {
			    System.out.println(i);
			    name=rs4.getString("name");
			    demotab.setValueAt(name, l, m);
			    demotab.setValueAt(quan, l, m+1);
			    demotab.setValueAt(amount2, l, m+2);
			    }
			    l++;
			
			if(l!=0)
			{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				addWindowListener(new WindowAdapter()
						{
				public void windowClosing(WindowEvent we) {
					
					String[] optbuttons={"Yes","No"};
					int PromptResult=JOptionPane.showOptionDialog(null,"You have not completed your work, are you sure you want to exit?",
					"Confirm Exit",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,optbuttons,optbuttons[1]);
					if(PromptResult==JOptionPane.YES_OPTION)
					{
						System.exit(0);
					}
				}
						});
			}
			
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		
		total1=total;
		t4.setText(String.valueOf(total1));

//CLICKED SUBMIT 
		//CLEAR DEMOTABLE
		
		if(ae.getSource()==Submit)
		{	 

			 int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.NO_OPTION) 
				    {
				      System.out.println("No transfer clicked");
				    } 
				    else if (response == JOptionPane.YES_OPTION) 
				    {	
				    	if(l!=0)
				    	{
				    	new Bill();
				    	}
				    	
				    } 
				    else if (response == JOptionPane.CLOSED_OPTION) 
				    {
				      System.out.println("JOptionPane closed");
				    }
				    
		}
		
	}
	
	
	
//MAIN FUNCTION
	
	public static void main(String[] args) 
	{	
		Title obj=new Title();
		obj.Login();	
	}
	
	
	
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}



