package com.globallogic.userservice.service;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.globallogic.userservice.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.token.validity}")
	private long tokenValidity;

	// generate token for user
	public String generateToken(User userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, Integer.toString(userDetails.getUserId()));
	}

	public String doGenerateToken(Map<String, Object> claims, String id) {
		return Jwts.builder().setClaims(claims).setSubject(id).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + tokenValidity))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

}
