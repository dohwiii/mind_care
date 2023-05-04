package com.care.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//비밀번호 암호 
public class SHA256 {

	private final static String SHA256_SALT = "34ocijegflgn";
	
    public static String encrypt(String text) throws NoSuchAlgorithmException {
    	text = SHA256_SALT + text;
        MessageDigest md = MessageDigest.getInstance("SHA-256"); //MessageDigest 인스턴스 생성 
        md.update(text.getBytes()); //해쉬값 업데이트 

        return bytesToHex(md.digest()); //해쉬값 얻고 16진수로 바꾸기 
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(encrypt("admin1234"));
	}
}
