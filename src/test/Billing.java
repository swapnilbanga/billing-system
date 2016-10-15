package test;


import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class Billing extends JFrame implements ActionListener,MouseListener,KeyListener
{
	JLabel Day,Month,Year,date;
	String selectedData1,qty,pri;
	String selectedData2;
	String selectedData3;
	String value;
	String[][] data;
	static double total1;
	String item_name,item_detail,item_quantity,str_name,str_quantity,str_detail;
	double item_price,str_price,total,amount_new,amount;
	String result,price,name;
	int i,j,a,b,x,y,k,flag;
	JTable table;
	JTable t;
	JTextField t1;
	Font f;
	Float pri1,qty1;
	int[] selectedRow,selectedCol;
	JButton search,remove,proceed;
	DefaultTableModel model,model1;
	JScrollPane sp,for2;
	JLabel labelimg4;

	void function()
	{
		flag=0;
		setVisible(true);
		setSize(1366,768);
		setLayout(null);
		setTitle("Bill");
		f=new Font("Rockwell",Font.PLAIN,16);
		
		//background image
		labelimg4=new JLabel(new ImageIcon(getClass().getResource("grey.jpg")));

		 
		
	    //date
		DateFormat df=new SimpleDateFormat("dd/MM/yy");
		Date dateobj=new Date();
		date=new JLabel(df.format(dateobj));date.setFont(f);
		
		//table 1
		Object[] columnname={"Item","Detail","Quantity","Price"};
		data=new String[20][20];
		
		model1= new DefaultTableModel(data,columnname);
		t=new JTable(data,columnname){
			public boolean isCellEditable(int data,int columnname)
			{
				return false;
			}
		};
		t.setModel(model1);
		t.setPreferredScrollableViewportSize(new Dimension(568,300));
		t.setRowHeight(25);
		t.setFont(f);
		t.getTableHeader().setFont(f);
		for(a=0;a<19;a++)
		{
			for(b=0;b<4;b++)
			{
				t.setValueAt("", a, b);
			}
		}
		
		//other declarations
		sp=new JScrollPane(t);
		
		t1=new JTextField(20);t1.setFont(f);
		
		search=new JButton("Search");search.setFont(f);
		remove=new JButton("Remove");remove.setFont(f);
		proceed=new JButton("Proceed to Checkout >>");proceed.setFont(f);
		
		//table 1 width
		t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		t.getColumnModel().getColumn(0).setPreferredWidth(150);
		t.getColumnModel().getColumn(1).setPreferredWidth(200);
		t.getColumnModel().getColumn(2).setPreferredWidth(100);
		t.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		//table 1 sorter
		t.setAutoCreateRowSorter(true);
		
		//enable selection
		t.setCellSelectionEnabled(true);
	    ListSelectionModel cellSelectionModel = t.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener(){
	    	public void valueChanged(ListSelectionEvent le)
	    	{
	    		int[] selectedrow=t.getSelectedRows();
	    		 for (int i = 0; i < selectedrow.length; i++) 
	    		 {
	    	          selectedData1=(String) t.getValueAt(selectedrow[i],0);
	    	          selectedData2 = (String) t.getValueAt(selectedrow[i],1);
	    	          selectedData3=(String) t.getValueAt(selectedrow[i],3);
	    	          result=new String(selectedData1+" "+selectedData2);
	    	          price=new String(selectedData3);
	    	          t1.setText(result); 
	    	          }
	    		 
	   	}
	    });

	    //table 2
	    Object[] clname={"Item","Price","Quantity","Amount"};
	   Object[][] data1={};
	  model = new DefaultTableModel(data1,clname);

	    table=new JTable(data1,clname){
			public boolean isCellEditable(int data1,int clname)
			{
				return clname==0 || clname==1 ? 
						false:true;
			}
		};
		table.setModel(model);
		table.setPreferredScrollableViewportSize(new Dimension(300,200));
		for2=new JScrollPane(table);
		table.setFont(f);
		table.setRowHeight(25);
		table.getTableHeader().setFont(f);
		
		//table 2 width
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		//make cell clickable
		DefaultCellEditor singleclick = new DefaultCellEditor(new JTextField());
		    singleclick.setClickCountToStart(1);

		    //set the editor as default on every column
		    for (int i = 0; i < table.getColumnCount(); i++) 
		    {
		        table.setDefaultEditor(table.getColumnClass(i), singleclick);
		    } 
		    
		//set bounds
	    t1.setBounds(30,240,450,30);
	    sp.setBounds(30,300,572,305);
	    search.setBounds(500,240,97,30);
	    for2.setBounds(743,300,572,257);
	    date.setBounds(1250,10,100,50);
	    remove.setBounds(970,600,97,30);
	    proceed.setBounds(1100,600,230,30);
	    labelimg4.setBounds(00,00,1366,768);
	    
	    //listeners
	    search.addActionListener(this);
	    remove.addActionListener(this);
	    proceed.addActionListener(this);
	    t.addMouseListener(this);
	    t1.addKeyListener(this);
	    t.addKeyListener(this);
	    table.addKeyListener(this);
	    
	   
	    //table width false
	    table.getTableHeader().setResizingAllowed(false);
	    table.getTableHeader().setReorderingAllowed(false);
	    t.getTableHeader().setResizingAllowed(false);
	    t.getTableHeader().setReorderingAllowed(false);
	    
	    //adding
	    add(sp);add(t1);add(search);add(for2);add(date);add(remove);add(proceed);add(labelimg4);
	    
	   
	    repaint();
	    revalidate();
	}
	
	void ins_function()
	{
		 //SET VALUES IN TABLE T FOR MENU 
		x=0;y=0;
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
			Statement stat=con.createStatement();
			String quer="SELECT*FROM menu";
			ResultSet result=stat.executeQuery(quer);
			  while(result.next())
			    {
			    //System.out.println(i);
				  	item_name=result.getString("name");
				  	item_detail=result.getString("detail");
				  	item_quantity=result.getString("quantity");
				  	item_price=result.getDouble("price");
				    
				    t.setValueAt(item_name, x, y);
				    t.setValueAt(item_detail, x, y+1);
				    t.setValueAt(item_quantity, x, y+2);
				    t.setValueAt(String.valueOf(item_price), x, y+3);
				    x++;
			    }
		}
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
	}
	
	//action listener
	public void actionPerformed(ActionEvent ae) 
	{
	if(ae.getSource()==search)
	{
		if(t1.getText().isEmpty())
		{
			ins_function();
		}
		else
		{
		Connection con3=null;
		Statement stmt3=null; 
		String s5=t1.getText().trim();
		String s6;

//REDUNDANT SPACES 
		
		String test=s5.replaceAll("\\s","");
		System.out.println(test);
		if(test.equalsIgnoreCase(s5))
		{
			s6="select*from menu where name="+"'"+s5+"'or detail="+"'"+s5+"'";
		}
		else
		{
			s6="select*from menu where concat(name,detail)="+"'"+test+"'";
		}
		
		
	//SEARCH IN MENU	
		
		
		try
		{	
		x=0;y=0;
		con3=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
		stmt3=con3.createStatement();
		ResultSet rs3=stmt3.executeQuery(s6);
		    while(rs3.next())
		    {
		    //System.out.println(i);
		    str_name=rs3.getString("name");
		    str_detail=rs3.getString("detail");
		    str_price=rs3.getDouble("price");
		    str_quantity=rs3.getString("quantity");
		    t.setValueAt(str_name, x, y);
		    t.setValueAt(str_detail, x, y+1);
		    t.setValueAt(String.valueOf(str_price), x, y+3);
		    t.setValueAt(str_quantity, x, y+2);
		    x++; 
		    }
		    }
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		
//SEARCH FAILS		
		if(x==0)
		{
		JOptionPane.showInternalMessageDialog(getContentPane(), "No items found for "+s5+". Please make sure all entered keywords are correct.");
		}
		else
		{
		 int k=x;
		    while(k<data.length)
		    {	
		    	for(j=0;j<=3;j++)
		    	{
		    t.setValueAt("", k, j);
		    	}
		    	k++;
		    }	
		}
		}
	}
	
	
	if(ae.getSource()==remove)
	{
		int selRow = table.getSelectedRow();
		 if(selRow != -1) 
		 {
			  model.removeRow(selRow);
		 }
	}   
	
	//CREATE BILL
	
	if(ae.getSource()==proceed)
	{	
	
		
		amount_new=0.00;
		total1=0;
		total=0;
		Connection con=null;
		Statement stat=null;
		if(flag==1)
		{
		try
		{
		con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
		stat=con.createStatement();
		for(x=0;x<table.getRowCount();x++)
		{
		str_name=(String) table.getValueAt(x,0);
		str_quantity=(String) table.getValueAt(x, 2);
		amount_new=(double) table.getValueAt(x, 3);
		stat.executeUpdate("insert into selected values ('"+str_name+"','"+str_quantity+"', '"+amount_new+"')");
		total=total+amount_new;
		}
		total1=total;
		new Bill();
	
	//BILL CREATED, EMPTY SELECTED TABLE
		
		
	 	Connection con4=null;
		Statement stat4=null;
		try{
		con4=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
		stat4=con4.createStatement();
		String clear="truncate selected";
		stat4.executeUpdate(clear);
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		dispose();
	}
	
	else 
		{
		JOptionPane.showMessageDialog(getContentPane(), "Incomplete data");
		}
	}
	}
	

	
	
	//mouse listener
	public void mouseClicked(MouseEvent me) 
	{
		if(me.getClickCount()==2)
		{
		Vector selected=new Vector();
		selected.addElement(result);
		selected.addElement(price);
		model.addRow(selected);	
		
	}
		}
	
	public void mouseEntered(MouseEvent mes) 
	{
	
	}
	public void mouseExited(MouseEvent arg0) {
		
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//key listener
	public void keyPressed(KeyEvent e) 
	{
		if(e.getSource()==t)
		{
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			Vector selected=new Vector();
			selected.addElement(t1.getText());
			selected.addElement(price);
			model.addRow(selected);	
			
		}
		}
	
		if(e.getSource()==table)
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
			flag=1;
			int[] sel=table.getSelectedRows();
			for (int amt =0;amt< sel.length; amt++) 
   		 {
			qty=(String) table.getValueAt(sel[amt],2);
			pri=(String) table.getValueAt(sel[amt],1);
			qty1=Float.parseFloat(qty);pri1=Float.parseFloat(pri);
			amount=qty1*pri1;
			table.setValueAt(amount,sel[amt],3);
		}
		}
			}
			}
		
		

	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
	

//main
	public static void main(String[] args) 
	{
		Billing c=new Billing();
		c.function();
		c.ins_function();
	}
}
	