package org.spring.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;

public class SECUserCredential extends ClientCredentialsTokenEndpointFilter {
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException,
            IOException, ServletException {
 
			System.out.println("inside sec user credential "+this.getAuthenticationManager().getClass().getSimpleName());
            Authentication auth = this.getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(request.getParameter("username"),
                    		request.getParameter("password"),null));
 
            return auth;
        }
 
    @Override
    protected boolean requiresAuthentication(HttpServletRequest request,
            HttpServletResponse response) {
    	if(request.getMethod().equals("GET"))
        return true;
    	else
    		return false;
    }

}
