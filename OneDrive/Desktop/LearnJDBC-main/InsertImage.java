import java.sql.*;
import java.io.*;
class InsertImage{
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
			String q = "insert into images(pic) values(?)"; 

			//Get Prepared Statement Object
			PreparedStatement pstmt = conn.prepareStatement(q);


			//Set Values to Query
			FileInputStream fis = new FileInputStream("strike.jpg");

			pstmt.setBinaryStream(1,fis,fis.available());
			pstmt.executeUpdate();

			System.out.println("Image Inserted");

			//Close Connection
			conn.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}