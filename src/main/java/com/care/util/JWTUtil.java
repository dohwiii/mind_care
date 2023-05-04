package com.care.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTUtil {

	private static String JWT_SALT = "adfasdf234";

	public static String generateJWT(String id) {
		
		Calendar calendar = Calendar.getInstance();
		Date issueDate = calendar.getTime();
		calendar.add(Calendar.DATE, 1); // 1일 더함
		Date expireDate = calendar.getTime(); // 위에서 더한 시간을 유효시간으로 지정

		return JWT.create()
				.withIssuer(id)
				.withIssuedAt(issueDate)
				.withExpiresAt(expireDate)
				.sign(Algorithm.HMAC256(JWT_SALT)).toString();
	}

	public static DecodedJWT verifyJWT(String token, String id) {

		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JWT_SALT)).withIssuer(id).build();
		return verifier.verify(token);
	}

}
