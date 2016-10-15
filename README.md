# billing-system <br />
A billing system for restaurants and eateries. <br />

Developed in Java, uses Nimbus look and feel. (https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html). <br />

If you wish to download and use this project, you will need to follow these steps (in no particular order). 
<br />
<br />
- Set up MySQL and create a few tables (table names are case sensitive): <br />
  manager - name, id, password, age, address, contact, joining_date <br />
  employee - name, id, password, age, address, contact, joining_date, job_title <br />
  selected - name, quantity, amount <br />
  inventory - id, name, category, stock, supplier. <br />
  customer - name, phone, e_mail, order_no, order_amount, customer_address, order_date, server <br />
  menu - name, detail, quantity, price <br />
<br />
- Change user name and password in JDBC connections to your user name and password. <br />
<br />
- Download Nimbus L&F. <br />
<br />
- Download JDBC driver. <br />
<br />
Feel free to alter the source code and add more features. <br />
