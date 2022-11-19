package dev.tuanlm.demo.utils;

import java.util.Date;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtUtils {
	
	/** The Constant EXPIRATION_TIME. */
	private static final long EXPIRATION_TIME = 4*7*24*60*60*1000L; 
	
	/** The Constant SECRET_KEY_APP. */
	private static final String SECRET_KEY_APP = "eM7LWDNZMSHCtAZVWKJNERu4v0UPMYgu0BqE4705";
	
	/** The Constant HEADER_STRING. */
	public static final String HEADER_STRING = "Authorization";
	
	/** The Constant TOKEN_PREFIX. */
	public static final String TOKEN_PREFIX = "Bearer ";

	public static String generateJwtToken(String username) {
		Date now = new Date();
		
		return Jwts.builder()
					.setSubject(username)
					.setIssuedAt(now)
					.setExpiration(new Date(now.getTime() + EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS512, SECRET_KEY_APP)
					.compact();
	}
	
	public static String getUserFromToken(String token) throws SignatureException, MalformedJwtException, 
							ExpiredJwtException, UnsupportedJwtException, IllegalArgumentException {
		return Jwts.parser()
					.setSigningKey(SECRET_KEY_APP)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
	}
}
