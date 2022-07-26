///Insert data into table using PreparedStatement

import java.sql.*;
class InsertDataJDBC{
	public static void main(String[] args) {
		try{
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbctest";
			String user = "root";
			String pass = "password";
			Connection conn = DriverManager.getConnection(url,user,pass);

			//Create Query
			String q = "insert into table1(tName,tCity) values(?,?)"; 

			//Get Prepared Statement Object
			PreparedStatement pstmt = conn.prepareStatement(q);

			//Set Values to Query
			pstmt.setString(1,"Naruto");
			pstmt.setString(2,"Hidden Leaf");

			// pstmt.setString(1,"Sasuke");
			// pstmt.setString(2,"Hidden Leaf");

			// pstmt.setString(1,"Gaara");
			// pstmt.setString(2,"Hidden Sand");

			// pstmt.setString(1,"Kakashi");
			// pstmt.setString(2,"Konoha");

			pstmt.executeUpdate();

			System.out.println("Inserted");

			//Close Connection
			conn.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}