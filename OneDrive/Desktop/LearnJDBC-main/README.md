# LearnJDBC

**Steps to Connect with Database**

	1. Load the driver
	  We can only use the driver after loading it on our machine.
	
      1st Method
        Class.forName("Driver_name")
        e.g. Class.forName("com.mysql.jdbc.Driver")

      2nd Method
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver())
	
2. Create a connection
	 Connection gets established between program and database
	
    import java.sql.*;
    Connection conn = DriverManager.getConnection("url","username","password");
    e.g. ("jdbc:mysql://localhost:3306/jdbctest","root","password")
	
	
 3. Create a query
	    We will fire SQL queries after establishing connection. We will need one of three things  below:
        a. Statement - If we need simple query.
        b. PreparedStatement - If we have question marks/complex query.
        c. CallableStatement - If we need functions/procedures from database.
	
		a. Statement Example
      String q = " select * from students" ; 
      Statement stmt = conn.createstatement(); 
        § stmt.executeQuery() - when we expect only data
        e.g. ResultSet set = stmt.executeQuery();
        It will pull all data in set.
        § stmt.executeUpdate() - when we expect update and not data
        § stmt.execute();
   
4. Process the data
	We will process our data with help of set. We have methods for it.
	
	set.next() - If there is next row available?
	set.getInt() 
	set.getString()
	e.g.
    while(set.next()){
      int id = set.getInt(ColumnNumber/"ColumnName");
      String name = set.getString(ColumnNumber/"ColumnName");
      System.out.println(id + " " + name);
    }

5.Close the connection
	 conn.close();
