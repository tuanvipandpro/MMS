package dev.tuanlm.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import dev.tuanlm.demo.utils.JwtUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setHeader("content-type", "application/json;charset=UTF-8");
		
		String jwt = getJwtFromHeader(request);
		if (jwt == null || jwt.isBlank()) {
//			throw new JwtException("Jwt is invalid");
			SecurityContextHolder.getContext().setAuthentication(null);
		} else {
			String username =  JwtUtils.getUserFromToken(jwt);
			SecurityContextHolder
				.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken(username, null, null));
		}
		filterChain.doFilter(request, response);
	}
	
	private String getJwtFromHeader(HttpServletRequest request) {
		String header = request.getHeader(JwtUtils.HEADER_STRING);
		
		return StringUtils.hasText(header) && header.startsWith(JwtUtils.TOKEN_PREFIX) 
				? header.substring(7, header.length())
				: null;
	}

}
