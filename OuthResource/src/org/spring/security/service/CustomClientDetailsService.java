package org.spring.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.spring.security.client.CustomClientDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

public class CustomClientDetailsService implements ClientDetailsService {

	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		CustomClientDetails clientDetails=new CustomClientDetails();
		clientDetails.setClientId("1223");
		clientDetails.setClientSecret("secretKey");
		
		Set<String> scopes=new TreeSet<String>();
		scopes.add("read");
		scopes.add("write");
		clientDetails.setScope(scopes);
		
		Set<String> redirectUri=new TreeSet<String>();
		redirectUri.add("http://localhost:8085/OauthClient/rest/redirectedPage");
		clientDetails.setRegisteredRedirectUri(redirectUri);
		
		Set<String> grantTypes=new TreeSet<String>();
		grantTypes.add("authorization_code");
		grantTypes.add("refresh_token");
		clientDetails.setAuthorizedGrantTypes(grantTypes);
		
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		clientDetails.setAuthorities(authorities);
		
		Set<String> resourceIds=new TreeSet<String>();
		resourceIds.add("test");
		clientDetails.setResourceIds(resourceIds);
		
		return clientDetails;
	}

}
