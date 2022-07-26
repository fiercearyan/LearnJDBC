import java.sql.*;
class InsertJDBC{
	public static void main(String[] args) {
		try{
			//Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Create connection
			String url = "jdbc:mysql://localhost:3306/jdbctest";
			String user = "root";
			String pass = "password";
			Connection conn = DriverManager.getConnection(url,user,pass);

			//Create a query
			// String q = "create table table1(tId int(20) primary key auto_increment, tname varchar(200) not null, tCity varchar(400))";

			String q = "create table images(id int primary key auto_increment, pic blob)";

			//Create a Statement
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(q);
			System.out.println("Table Created");

			//Close Connection
			conn.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}