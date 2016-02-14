package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {
	
	public String hash(String hash)
	{
		String encryptedString = null;
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(hash.getBytes());
			encryptedString = new String(messageDigest.digest());
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return encryptedString;
	}

}
