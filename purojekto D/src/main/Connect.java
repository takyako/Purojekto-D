package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	static String url = "jdbc:mysql://localhost:3306/jgame";
	static String driver = "com.mysql.jdbc.Driver";
	static String sName = "martin";
	static String sPassword = "1234";
	
	
	public static Connection con() {
		Connection con = null;
		try {
			Class.forName(driver);
		con = DriverManager.getConnection(url,sName,sPassword);
		
		
		} catch (ClassNotFoundException ex) {
			System.out.println("Fehler beim Aufbau einer Verbindung mit der Datenbank " + ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("Fehler beim Aufbau einer Verbindung mit der Datenbank " + ex.getMessage());
			ex.printStackTrace();
		}
		return con;
	}
}
