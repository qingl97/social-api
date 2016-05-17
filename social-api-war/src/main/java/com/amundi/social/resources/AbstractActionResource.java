package com.amundi.social.resources;

import javax.security.auth.login.LoginException;
import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.amundi.services.server.security.authenticator.session.DeprecatedHttpSessionAuthenticator;
import com.amundi.social.application.SocialAPISecurityConfig;

import net.active.services.common.RequestContextResolver;
import net.active.services.server.RequestContextResolverImpl;
import net.active.services.server.security.SecurityManager;
import net.active.services.server.security.core.authenticator.HttpAuthenticator;
import net.active.services.server.security.core.authenticator.basic.HttpBasicCustomAuthenticator;
import net.active.services.server.util.AbstractResource;

public abstract class AbstractActionResource extends AbstractResource {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractActionResource.class);

	public static final String APP_ID_HEADER = "APP_ID";
	
	protected String getAppId(HttpHeaders headers) {
		if(headers.getRequestHeaders().containsKey(APP_ID_HEADER)) {
			LOGGER.debug("Inside getAppId : Application ID : " + headers.getRequestHeaders().get(APP_ID_HEADER).get(0));
			return headers.getRequestHeader(APP_ID_HEADER).get(0);
		}
		return null;
	}
	
	protected boolean isAuthenticated() {
		RequestContextResolverImpl requestContextResolverImpl= 
				(RequestContextResolverImpl) RequestContextResolver.getInstance();
		if(!StringUtils.isBlank(
				requestContextResolverImpl.getHttpHeaders().getHeaderString(HttpHeaders.AUTHORIZATION))){
			HttpAuthenticator httpAuthenticator = 
					new DeprecatedHttpSessionAuthenticator.Builder(
							new HttpBasicCustomAuthenticator()).useXsrfToken(false).build();
			try {
				httpAuthenticator.authenticate(
								SocialAPISecurityConfig.REALM, 
								requestContextResolverImpl.getContainerRequestContext());
			} catch (LoginException e) {
				LOGGER.info(e.getMessage());
				return false;
			}
		}
		return true;
	}
	
	protected String getUserId() {
		LOGGER.info(SecurityManager.getSubject().getPrimaryPrincipal().getName());
		return SecurityManager.getSubject().getPrimaryPrincipal().getName();
	}
}
