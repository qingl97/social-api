package com.amundi.social.rest.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;

import com.amundi.services.common.util.jackson.AmundiObjectMapper;
import com.amundi.services.server.AmundiApplication;
import com.amundi.services.server.security.AmundiSecurityConfig;
import com.amundi.services.server.security.authenticator.AmundiLoginContextFinder;
import com.amundi.social.rest.resources.CommentResource;
import com.amundi.social.rest.resources.FavoriteResource;
import com.amundi.social.rest.resources.FollowResource;
import com.amundi.social.rest.resources.LikeResource;
import com.amundi.social.rest.resources.impl.ProductViewResourceImpl;

import net.active.services.common.security.HttpAuthenticationScheme;

/**
 * Created by liang on 26/04/2016.
 */

@ApplicationPath("api")
public class ApiServer extends AmundiApplication {

	private static final String APPLICATION_NAME = "BRIQUE_SOCIAL";
	
	public ApiServer() {
		super(APPLICATION_NAME);
		registerResources(
				ProductViewResourceImpl.class,
				LikeResource.class,
				FavoriteResource.class,
				FollowResource.class,
				CommentResource.class);
		
		registerObjectMapper(new AmundiObjectMapper());

		AmundiSecurityConfig securityConfig = new AmundiSecurityConfig.Builder()
				.withHttpBasicSessionAuthenticator(new AmundiLoginContextFinder(){
					@Override
					public String findContext(String scheme, String realm, ContainerRequestContext containerRequestContext) {
						return realm + "." + scheme;
					}
				}, new AmundiSecurityConfig.CookieConfig("/", null, Integer.MAX_VALUE, false))
				.defaultAuthenticationConfig(new AmundiSecurityConfig.AuthenticationConfig("DEFAULT", new String[]{ /* HttpAuthenticationScheme.NEGOTIATE, */ HttpAuthenticationScheme.BASIC})).build();

		securityConfig(securityConfig)
				.addAuthorizedCorsHeaders("X-XSRF-TOKEN");
	}
}
