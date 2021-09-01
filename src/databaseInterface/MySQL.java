package databaseInterface;

import java.sql.*;
import javax.swing.JOptionPane;

public class MySQL {
	
	public Connection connection;
	private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/java";
	private final String user = "root";
	private final String password = "";
	
	public boolean getConnection() {
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Succesfully Connected!");
			return true;
		}catch(ClassNotFoundException error) {
			
			JOptionPane.showMessageDialog(null, "Driver not found!\n" + error.toString(), "Connection", JOptionPane.ERROR_MESSAGE);
			return false;
			
		}catch(SQLException error) {
			
			JOptionPane.showMessageDialog(null, "Connection Failed!" + error.toString(), "Connection", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	
	public void close() {
		
		try {
			connection.close();
			System.out.println("Connection Closed!");
		}catch(SQLException error) {
			
		}
		
	}

}
