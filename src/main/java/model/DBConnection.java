package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		final String URL = "jdbc:mysql://localhost/todoapp";
		final String USER = "root";
		final String PASS = "";
		
		try{
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(URL,USER,PASS);
		return con;
	}
}
