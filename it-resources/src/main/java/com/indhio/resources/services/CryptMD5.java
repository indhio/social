package com.indhio.resources.services;

import java.io.Serializable;
import java.security.MessageDigest;

import javax.ejb.Singleton;

@Singleton
public class CryptMD5 implements Serializable {

	private static final long serialVersionUID = 1L;

	public String MD5(String md5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
