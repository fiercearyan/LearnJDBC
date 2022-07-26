import java.sql.*;
import java.io.*;
class InsertImage{
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","password");

			String q = "create table images3(id int primary key auto_increment, pic longblob)";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(q);
			System.out.println("Table Created");

			String q2 = "insert into images3(pic) values(?)"; 
			PreparedStatement pstmt = conn.prepareStatement(q2);
			FileInputStream fis = new FileInputStream("strike.jpg");
			pstmt.setBinaryStream(1,fis,fis.available());
			pstmt.executeUpdate();
			System.out.println("Image Inserted");

			conn.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}