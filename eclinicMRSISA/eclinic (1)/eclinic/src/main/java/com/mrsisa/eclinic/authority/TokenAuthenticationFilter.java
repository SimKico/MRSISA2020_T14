package com.mrsisa.eclinic.authority;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mrsisa.eclinic.security.TokenUtils;

/* Filter that will intercept every client's request to the server,
 * except for the ignore paths in WebSecurityConfig.configure(WebSecurity web)
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {
	private TokenUtils tokenUtils;

	private UserDetailsService userDetailsService;

	public TokenAuthenticationFilter(TokenUtils tokenHelper, UserDetailsService userDetailsService) {
		this.tokenUtils = tokenHelper;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String email;
		String authToken = tokenUtils.getToken(request);

		if (authToken != null) {
			// extract email from token
			email = tokenUtils.getEmailFromToken(authToken);
			System.out.println(email);
				
			if (email != null) {
				// get user based on email
				System.out.println("ovdje email");
				UserDetails userDetails = userDetailsService.loadUserByUsername(email);
				System.out.println(userDetails);
				// check token validity
				if (tokenUtils.validateToken(authToken, userDetails)) {
					// create authentication
					TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
					authentication.setToken(authToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
					System.out.println("uspjelo");
				}
			}
		}
		chain.doFilter(request, response);
	}

}