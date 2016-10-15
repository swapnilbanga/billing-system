package test;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.*;

import javax.swing.*;

public class Inventory extends JFrame implements ActionListener {
	
	String[][] defaultvalues=new String[20][20];
	String[] columns={"ID","Name","Category","Stock","Supplier"};
	JLabel restaurant,add_label,remove_label,save_label,id_label;
	JButton add,remove,save,add_item,clear;
	JTable Inventory;
	String item_name,item_category,item_supplier,item_stock;
	Connection con;
	Statement stat;
	JTextField name,category,stock,supplier,id_text;
	DefaultTableModel model;
	int x,y;
	int id;
	Object item_id,o;
	Inventory()
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
	      save_label=new JLabel("Save changes to the inventory");
	      Font font=new Font("Rockwell",Font.ITALIC,18);
	      add_label.setFont(font);remove_label.setFont(font);save_label.setFont(font);
	      model= new DefaultTableModel(defaultvalues,columns);
	      Inventory=new JTable(defaultvalues,columns);
	      Inventory.setPreferredScrollableViewportSize(new Dimension(500,300));
	      Inventory.setModel(model);
	      JScrollPane sp=new JScrollPane(Inventory);
	      Inventory.getColumnModel().getColumn(0).setPreferredWidth(45);
	      Inventory.getColumnModel().getColumn(1).setPreferredWidth(120);
	      Inventory.getColumnModel().getColumn(2).setPreferredWidth(120);
	      Inventory.getColumnModel().getColumn(3).setPreferredWidth(120);
	      Inventory.getColumnModel().getColumn(4).setPreferredWidth(120);
	     
	      
	      add.addActionListener(this);remove.addActionListener(this);save.addActionListener(this);
	      
	      Inventory.setBounds(50,150,600,200);
	      sp.setBounds(Inventory.getBounds());
	      restaurant.setBounds(365,20,250,80);
	      add_label.setBounds(50, 380, 200, 20);
	      remove_label.setBounds(50,425,200,20);
	      save_label.setBounds(50,470,250,20);
	      add.setBounds(200,380,70,25);
	      remove.setBounds(200,425,70,25);
	      save.setBounds(305,470,70,25);
	      x=0;y=1;
	      
	    
	      add(add_label);add(save_label);add(remove_label);add(add);add(remove);add(save);add(sp);add(restaurant);
	      
	      
	      repaint();
	      revalidate();
	}
	
//CALLED AT START	
	
	void ins_function()
	{
		  try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				Statement stat=con.createStatement();
				String quer="SELECT*FROM Inventory";
				ResultSet result=stat.executeQuery(quer);
				  while(result.next())
				    {
				    //System.out.println(i);
					  	item_id=result.getInt("id");
					  	item_name=result.getString("name");
					  	item_category=result.getString("category");
					  	item_stock=result.getString("stock");
					  	item_supplier=result.getString("supplier");
					    
					  	Inventory.setValueAt(item_id, x, y-1);
					    Inventory.setValueAt(item_name, x, y);
					    Inventory.setValueAt(item_category, x, y+1);
					    Inventory.setValueAt(String.valueOf(item_stock), x, y+2);
					    Inventory.setValueAt(item_supplier, x, y+3);
					    x++;
				    }
			}
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
	      
	      
	}



	@Override
	public void actionPerformed(ActionEvent action) {
		o=new Object();
		if(action.getSource()==add)
		{
			
			
			name=new JTextField();
			category=new JTextField();
			stock=new JTextField();
			supplier=new JTextField();
			id_text=new JTextField();
			JLabel head=new JLabel("Enter details of item to be added");
			
			JLabel name_label=new JLabel("Name");JLabel cat_label=new JLabel("Category");
			JLabel stock_label=new JLabel("Stock");JLabel sup_label=new JLabel("Supplier");
			id_label=new JLabel("ID");
			
			clear=new JButton("Clear");
			add_item=new JButton("Add");
			
			
			Font font1=new Font("Rockwell",Font.ITALIC,18);
			Font font2=new Font("Rockwell",Font.PLAIN,14);
			head.setFont(font1);
			name_label.setFont(font2);stock_label.setFont(font2);sup_label.setFont(font2);cat_label.setFont(font2);
			
			JFrame addfr=new JFrame();
			addfr.setSize(400,400);
		    addfr.setVisible(true);
		    addfr.setResizable(false);
		    addfr.setLayout(null);
		    
		    head.setBounds(20,20,300,20);
		    name_label.setBounds(40,60,50,20);
		    cat_label.setBounds(40,100,100,20);
		    sup_label.setBounds(40,140,65,20);
		    stock_label.setBounds(40,180,50,20);
		    id_label.setBounds(40,220,50,20);
		    name.setBounds(120,60,100,25);
		    category.setBounds(120,100,100,25);
		    stock.setBounds(120,140,100,25);
		    supplier.setBounds(120,180,100,25);
		    id_text.setBounds(120,220,100,25);
		    add_item.setBounds(50,260,60,25);
		    clear.setBounds(150,260,70,25);
		    
		    add_item.addActionListener(this);
		    clear.addActionListener(this);
		    
		    addfr.add(head);addfr.add(name);addfr.add(category);addfr.add(stock);addfr.add(supplier);addfr.add(name_label);
		    addfr.add(cat_label);addfr.add(sup_label);addfr.add(stock_label);addfr.add(add_item);addfr.add(clear);
		    addfr.add(id_text);addfr.add(id_label);
		    
		  
		    
		    repaint();
		    revalidate();
			
		}
		
		if(action.getSource()==add_item)
		{
			
			String name_text=name.getText();
			String category_text=category.getText();
			String stock_text=stock.getText();
			String supplier_text=supplier.getText();
			int id_item=Integer.parseInt(id_text.getText());
			
			if(!name_text.isEmpty()&&!stock_text.isEmpty()&&!supplier_text.isEmpty()&&!category_text.isEmpty())
			{
			try
			{	
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
				stat=con.createStatement();
				String quer="insert into Inventory values('"+name_text+"','"+category_text+"','"+stock_text+"','"+supplier_text+"',"+id_item+")";
				stat.executeUpdate(quer);
				JOptionPane.showMessageDialog(getContentPane(), "Item added successfully");
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
			category.setText("");
			stock.setText("");
			supplier.setText("");
		}
		
		
		if(action.getSource()==remove)
		{
			int selRow = Inventory.getSelectedRow();
			int id_del=(int)Inventory.getValueAt(selRow,0);
			String quer1="delete from Inventory where id='"+id_del+"'";
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
			
			try
			{
			Inventory.setEnabled(false);
			con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","aventador");
			stat=con.createStatement();
			x=0;
			while(x<Inventory.getRowCount())
			{
			o=Inventory.getValueAt(x, 0);	
			id=(int)o;
			String str_name=(String) Inventory.getValueAt(x,1);
			String str_category=(String)Inventory.getValueAt(x, 2);
			String str_stock=(String) Inventory.getValueAt(x, 3);
			String str_supplier=(String) Inventory.getValueAt(x, 4);
			stat.executeUpdate("replace into Inventory values ('"+str_name+"','"+str_category+"','"+str_stock+"','"+str_supplier+"',"+id+")");
			x++;
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

Inventory object=new Inventory();
object.ins_function();

}
}