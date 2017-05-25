package app.notemaker.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cipher {
	public static String getEncodedString(String password) throws NoSuchAlgorithmException
	{	
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		String encodePassword = sb.toString();
		return encodePassword;
		
	}
}
