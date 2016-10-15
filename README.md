# billing-system <br />
A billing system for restaurants and eateries. <br />

Developed in Java, uses Nimbus look and feel. (https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html). <br />

If you wish to download and use this project, you will need to follow these steps (in no particular order). <br />
1. Set up MySQL and create a few tables (table names are case sensitive): <br />
    a) manager - name, id, password, age, address, contact, joining_date <br />
    b) employee - name, id, password, age, address, contact, joining_date, job_title <br />
    c) selected - name, quantity, amount <br />
    d) inventory - id, name, category, stock, supplier. <br />
    e) customer - name, phone, e_mail, order_no, order_amount, customer_address, order_date, server <br />
    f) menu - name, detail, quantity, price <br />
2. Change user name and password in JDBC connections to your user name and password. <br />
3. Download Nimbus L&F. <br />
4. Download JDBC driver. <br />

Feel free to alter the source code and add more features. <br />
