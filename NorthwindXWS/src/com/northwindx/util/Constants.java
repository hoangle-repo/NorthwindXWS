package com.northwindx.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Constants {
	private static final String Key = "NorthwindTraderCustomerServices";
	private static final String md5CheckSumKey = createMD5(Key);
	
	public static String createMD5(String key){
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte[] data = key.getBytes(); 
	    m.update(data,0,data.length);
	    BigInteger i = new BigInteger(1,m.digest());
	    return i.toString(16);
	}

	public static String getMd5checksumkey() {
		return md5CheckSumKey;
	}
}
