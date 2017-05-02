package com.eximius.api.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class EncryptPassword {
	public static String encryptPass(String input){
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		messageDigest.update(input.getBytes(),0, input.length());  
		String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
		if (hashedPass.length() < 32) {
		   hashedPass = "0" + hashedPass; 
		}
		return hashedPass;
	}
}

