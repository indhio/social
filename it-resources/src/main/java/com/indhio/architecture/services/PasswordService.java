package com.indhio.architecture.services;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import sun.misc.BASE64Encoder;

public final class PasswordService implements Serializable {

	private static final long serialVersionUID = 1L;

	private static PasswordService instance;

	/**
	 * Alphabet consisting of upper and lowercase letters A-Z and the digits 0-9.
	 */
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };

	private SecureRandom rand;

	private PasswordService() {
		this.rand = new SecureRandom();
	}

	public synchronized String encrypt(String plaintext) throws Exception {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e.getMessage());
		}

		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}

		byte[] raw = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);

		return hash;
	}

	public synchronized String gerarSenha(int tamanho) {
		String senha = "";

		while (senha.length() < tamanho) {
			int i = this.rand.nextInt(62);
			senha += ALPHABET[i];
		}

		return senha;
	}

	public static synchronized PasswordService getInstance() {
		if (instance == null) {
			return new PasswordService();
		} else {
			return instance;
		}
	}

	public static void main(String[] args) throws Exception {
		PasswordService ps = new PasswordService();
		String password = ps.gerarSenha(14);
		System.out.println(password);
		System.out.println(ps.encrypt(password));
	}
}
