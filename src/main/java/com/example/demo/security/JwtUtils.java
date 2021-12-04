package com.example.demo.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	private String jwtSecret = "ABCDEF";
	
	private Integer jwtExpirationsMs = 72000; 
	
	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		Date now = new Date();
		Date exp = new Date((now).getTime() + jwtExpirationsMs);
		userPrincipal.setExpirationTime(exp);
		return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(now)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		
	}
	
	public String getUsernameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		}catch(Exception e) {
			
		}
		return false;
	}
}
