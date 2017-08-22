package org.spring.security.client;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class CustomClientDetails implements ClientDetails {
	
	private Collection<GrantedAuthority> authorities;
	private Set<String> authorizedGrantTypes;
	private String clientId;
	private String clientSecret;
	private Set<String> registeredRedirectUri;
	private Set<String> resourceIds;
	private Set<String> scope;

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return 600;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return 1800;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return registeredRedirectUri;
	}

	@Override
	public Set<String> getResourceIds() {
		return resourceIds;
	}

	@Override
	public Set<String> getScope() {
		return scope;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	@Override
	public boolean isScoped() {
		return false;
	}

	@Override
	public boolean isSecretRequired() {
		return false;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
		this.registeredRedirectUri = registeredRedirectUri;
	}

	public void setResourceIds(Set<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	public void setScope(Set<String> scope) {
		this.scope = scope;
	}
	
	

}
