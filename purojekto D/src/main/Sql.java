package main;
import java.sql.*;

public class Sql 
{	
	static String url = "jdbc:mysql://localhost:3306/jgame";
	static String driver = "com.mysql.jdbc.Driver";
	static String sName = "root";
	static String sPassword = "root";
	
	public static String getHash(String username)
	{
		String hash = null;
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,sName,sPassword);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT hash FROM user where username=!"+username+"';");
			rs.next();
			hash = rs.getString("hash");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
	    return hash;
	}
	public static void setHash(String username, String password)
	{
		
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,sName,sPassword);
			Statement st = con.createStatement();
			st.executeQuery("UPDATE user SET hash="+password+" WHERE username='"+username+"';");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
	}
}

