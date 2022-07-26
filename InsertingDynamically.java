import java.sql.*;
import java.io.*;
class InsertingDynamically{
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
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Name : ");
			String name = br.readLine();
			System.out.println("Enter City : ");
			String city = br.readLine();

			//Set Values to Query
			pstmt.setString(1,name);
			pstmt.setString(2,city);

			pstmt.executeUpdate();

			System.out.println("Inserted");

			//Close Connection
			conn.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

