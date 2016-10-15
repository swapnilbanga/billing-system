# billing-system
A billing system for restaurants and eateries.

Developed in Java, uses Nimbus look and feel. (https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html).

If you wish to download and use this project, you will need to follow these steps (in no particular order).
1. Set up MySQL and create a few tables (table names are case sensitive): 
    a) manager - name, id, password, age, address, contact, joining_date
    b) employee - name, id, password, age, address, contact, joining_date, job_title
    c) selected - name, quantity, amount
    d) inventory - id, name, category, stock, supplier.
    e) customer - name, phone, e_mail, order_no, order_amount, customer_address, order_date, server
    f) menu - name, detail, quantity, price
2. Change user name and password in JDBC connections to your user name and password. 
3. Download Nimbus L&F.
4. Download JDBC driver. 

Feel free to alter the source code as per your liking and add more features.
