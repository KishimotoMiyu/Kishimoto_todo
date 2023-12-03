package util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash{
	
	public static String generateHash(String val) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte [] inputBytes = val.getBytes();
		byte [] hashedBytes = md.digest(inputBytes);
		StringBuilder hexString = new StringBuilder();
		for(byte b : hashedBytes) {
			String hex = Integer.toHexString(0xff & b);
			if(hex.length() == 1 ) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
