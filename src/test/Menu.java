package test;

import java.awt.Dimension;
import javax.swing.table.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
	
	String[][] defaultvalues=new String[20][20];
	String[] columns={"ID","Name","Detail","Quantity","Price"};
	JLabel restaurant,add_label,remove_label,save_label,id_label;
	JButton add,remove,save,add_item,clear;
	JTable menu;
	DefaultTableModel model;
	String item_name,item_detail,item_quantity,id_str;
	double item_price;
	JTextField name,price,detail,quantity,id_text;
	int x,y,id,item_id,id_item;
	Connection con;
	Statement stat;
	Menu()
	{
	
		  setSize(950,650);
	      setVisible(true);
	      setResizable(false);
	      setLayout(null);
	      
	      restaurant=new JLabel("Restaurant");
	      restaurant.setFont(new Font("Rockwell",Font.PLAIN,42));
	      add=new JButton("Here");
	      remove=new JButton("Here");
	      save=new JButton("Here");
	      add_label=new JLabel("Add a new item");
	      remove_label=new JLabel("Remove an item");
	      save_label=new JLabel("Save changes to the menu");
	      Font font=new Font("Rockwell",Font.ITALIC,18);
	      add_label.setFont(font);remove_label.setFont(font);save_label.setFont(font);
	      
	    
	      model= new DefaultTableModel(defaultvalues,columns);
	      menu=new JTable(model);
	      menu.setPreferredScrollableViewportSize(new Dimension(500,300));
	      menu.setModel(model);
	      JScrollPane sp=new JScrollPane(menu);
	      menu.getColumnModel().getColumn(0).setPreferredWidth(45);
	      menu.getColumnModel().getColumn(1).setPreferredWidth(120);
	      menu.getColumnModel().getColumn(2).setPreferredWidth(120);
	      menu.getColumnModel().getColumn(3).setPreferredWidth(120);
	      menu.getColumnModel().getColumn(4).setPreferredWidth(120);
	      
	      add.addActionListener(this);remove.addActionListener(this);save.addActionListener(this);
	      
	      
	      menu.setBounds(50,150,600,200);
	      sp.setBounds(menu.getBounds());
	      restaurant.setBounds(365,20,250,80);
	      add_label.setBounds(50, 380, 200, 20);
	      remove_label.setBounds(50,425,200,20);
	      save_label.setBounds(50,470,250,20);
	      add.setBounds(200,380,70,25);
	      remove.setBounds(200,425,70,25);
	      save.setBounds(275,470,70,25);
	      x=0;y=0;
	      
	     
	      
	      add(add_label);add(save_label);add(remove_label);add(add);add(remove);add(save);add(sp);add(restaurant);
	      
	      
	      repaint();
	      revalidate();
	}
	
//CALLED AT START OF THE PROGRAM
	
	void ins_function()
	{
		 try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				stat=con.createStatement();
				String quer="SELECT*FROM menu";
				ResultSet result=stat.executeQuery(quer);
				  while(result.next())
				    {
				    //System.out.println(i);
					  
					  	item_name=result.getString("name");
					  	item_detail=result.getString("detail");
					  	item_quantity=result.getString("quantity");
					  	item_price=result.getDouble("price");
					    item_id=result.getInt("id");
					    
					  	menu.setValueAt((int)item_id, x, y);
					    menu.setValueAt(item_name, x, y+1);
					    menu.setValueAt(item_detail, x, y+2);
					    menu.setValueAt(item_quantity, x, y+3);
					    menu.setValueAt(String.valueOf(item_price), x, y+4);
					    
					    x+=1;
				    }
				  con.close();
			}
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
	      
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		if(action.getSource()==add)
		{
			
			
			name=new JTextField();
			detail=new JTextField();
			price=new JTextField();
			quantity=new JTextField();
			id_text=new JTextField();
			JLabel head=new JLabel("Enter details of item to be added");
			
			JLabel name_label=new JLabel("Name");JLabel detail_label=new JLabel("Detail");
			JLabel price_label=new JLabel("Price");JLabel quantity_label=new JLabel("Quantity");
			id_label=new JLabel("ID");
			
			clear=new JButton("Clear");
			add_item=new JButton("Add");
			
			
			Font font1=new Font("Rockwell",Font.ITALIC,18);
			Font font2=new Font("Rockwell",Font.PLAIN,14);
			head.setFont(font1);
			name_label.setFont(font2);price_label.setFont(font2);quantity_label.setFont(font2);detail_label.setFont(font2);
			
			JFrame addfr=new JFrame();
			addfr.setSize(400,400);
		    addfr.setVisible(true);
		    addfr.setResizable(false);
		    addfr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		    addfr.setLayout(null);
		    
		    head.setBounds(20,20,300,20);
		    name_label.setBounds(40,60,50,20);
		    detail_label.setBounds(40,100,50,20);
		    quantity_label.setBounds(40,140,65,20);
		    price_label.setBounds(40,180,50,20);
		    id_label.setBounds(40,220,50,20);
		    name.setBounds(100,60,100,25);
		    detail.setBounds(100,100,100,25);
		    quantity.setBounds(100,140,100,25);
		    price.setBounds(100,180,100,25);
		    id_text.setBounds(100,220,100,25);
		    add_item.setBounds(50,260,60,25);
		    clear.setBounds(150,260,70,25);
		    
		    add_item.addActionListener(this);
		    clear.addActionListener(this);
		    
		    addfr.add(head);addfr.add(name);addfr.add(detail);addfr.add(quantity);addfr.add(price);addfr.add(name_label);
		    addfr.add(detail_label);addfr.add(quantity_label);addfr.add(price_label);addfr.add(add_item);addfr.add(clear);
		    addfr.add(id_label);addfr.add(id_text);
		    
		  
		    
		    repaint();
		    revalidate();
			
		}
		
		if(action.getSource()==add_item)
		{
			
			String name_text=name.getText();
			String price_text=price.getText();
			String detail_text=detail.getText();
			String quantity_text=quantity.getText();
			id_item=Integer.parseInt(id_text.getText());
			
			if(!name_text.isEmpty()&&!price_text.isEmpty()&&!detail_text.isEmpty()&&!quantity_text.isEmpty())
			{
			try
			{	
				int price=Integer.parseInt(price_text);
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				stat=con.createStatement();
				String quer="insert into menu values('"+name_text+"','"+detail_text+"','"+quantity_text+"','"+price_text+"',"+id_item+")";
				stat.executeUpdate(quer);
				JOptionPane.showMessageDialog(getContentPane(), "Item added successfully");
				 con.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			}
			else
			{
				 JOptionPane.showMessageDialog(null,"One or more fields are empty", "Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(action.getSource()==clear)
		{
			name.setText("");
			price.setText("");
			detail.setText("");
			quantity.setText("");
		}
		
		
		if(action.getSource()==remove)
		{
			
			int selRow = menu.getSelectedRow();
			int id_del=(int)menu.getValueAt(selRow,0);
			String quer1="delete from menu where id='"+id_del+"'";
			 if(selRow != -1) 
			 {
				  
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
					stat=con.createStatement();
					stat.executeUpdate(quer1);
					con.close();
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
				  model.removeRow(selRow);
			 }
		}
		
		if(action.getSource()==save)
		{
			revalidate();
			try
			{
			con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
			stat=con.createStatement();
			for(x=0;x<menu.getRowCount();x++)
			{
			id=(int) menu.getValueAt(x,0);
			String str_name=(String) menu.getValueAt(x,1);
			String str_detail=(String)menu.getValueAt(x, 2);
			String str_quantity=(String) menu.getValueAt(x, 3);
			Double str_price=Double.parseDouble(String.valueOf(menu.getValueAt(x, 4)));
			stat.executeUpdate("replace into menu values ('"+str_name+"','"+str_detail+"','"+str_quantity+"','"+str_price+"','"+id+"')");
			}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
		
	


public static void main(String[] args) 
{
Menu object=new Menu();
object.ins_function();
}
}
