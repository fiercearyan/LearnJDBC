package com.jdbc.app;
import java.sql.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbctest";
			String user = "root";
			String pass = "password";
			Connection conn = DriverManager.getConnection(url,user,pass);
			
			String q = "insert into images3(pic) values(?)";
			PreparedStatement pstmt = conn.prepareStatement(q);
			
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(null);
			File file = jfc.getSelectedFile();
			
			FileInputStream fis = new FileInputStream(file);
			
			pstmt.setBinaryStream(1,fis,fis.available());
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Uploaded");
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
