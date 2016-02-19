package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	public static String calc(String hash) 
	{
		String encryptedString = null;
		MessageDigest messageDigest;
		
		try 
		{
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(hash.getBytes());
			encryptedString = new String(messageDigest.digest());
		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encryptedString;
	}

}
