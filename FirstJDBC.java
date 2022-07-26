import java.sql.*;
class FirstJDBC{
	public static void main(String[] args) {
		try{
			//Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Create connection
			String url = "jdbc:mysql://localhost:3306/jdbctest";
			String user = "root";
			String pass = "password";
			Connection conn = DriverManager.getConnection(url,user,pass);

			if(conn.isClosed()){
				System.out.println("...Closed");
			}else{
				System.out.println("Created...");
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}