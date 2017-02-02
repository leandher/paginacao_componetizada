package main.java.br.com.paginacao.util;

import java.security.SecureRandom;
import java.util.Base64;

public class StringHash {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public String encode(String senha) {
		byte[] encodedBytes = Base64.getEncoder().encode(senha.getBytes());
		return new String(encodedBytes);
	}
	
	public String decode(String senha){
		byte[] decodedBytes = Base64.getDecoder().decode(senha);
		return new String(decodedBytes);
	}
}
