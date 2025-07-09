package com.ddpl.paathner.security.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private String SECRET_KEY="HGDIEDjfbjd1232R^&^&&*)()_(&^%^&*";
	public String generateToken(String email) {
		Map<String, Object> claims=new HashMap<>();
		return createToken(claims,email);
	}
	private SecretKey getSigningKey() {
			return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}

	private String createToken(Map<String, Object> claims, String email) {
		return Jwts.builder().claims(claims)
				.subject(email)
				.header().empty().add("typ","JWT")
				.and()
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000*60*5))
				.signWith(getSigningKey())
				.compact();
	}

}
