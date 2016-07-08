package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbAdapter 
{	
	private static String url = "jdbc:mysql://barcreeper.sytes.net:3306/jgame";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String sName = "martin";
	private static String sPassword = "1234";
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement pSt = null;
	
	private static void connect()
	{
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url,sName,sPassword);
			
		}
		catch(Exception e)
		{
			System.out.println("Error while connecting: "+e.getMessage());
		}
	}
	private static void disconnect()
	{
		try
		{
			if(rs!=null) rs.close();
			if(pSt!=null)pSt.close();
			if(con!=null)con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Error while disconnecting: "+e.getMessage());
		}
	}
	
	public static String getHash(String username)
	{
		String hash = null;
		try
		{
			connect();
			pSt = con.prepareStatement("SELECT hash FROM user where username=?");
			pSt.setString(1, username);
			rs = pSt.executeQuery();
			rs.next();
			hash = rs.getString("hash");
			disconnect();
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
			connect();
			pSt = con.prepareStatement("UPDATE user SET hash = ? WHERE username = ? ");
			pSt.setString(1, Hash.calc(password));
			pSt.setString(2, username);
			pSt.executeUpdate();
			disconnect();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public static int insertUser(String username, String password)
	{
		int ret = 0;
		try
		{
			connect();
			pSt = con.prepareStatement("INSERT INTO user (hash, username) VALUES(?, ?) ");
			pSt.setString(1, Hash.calc(password));
			pSt.setString(2, username);
			ret = pSt.executeUpdate();
			disconnect();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	
		return ret;
	}
}

