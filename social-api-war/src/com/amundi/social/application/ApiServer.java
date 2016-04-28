package com.amundi.social.application;

import javax.ws.rs.ApplicationPath;

import com.amundi.services.server.AmundiSessionApplication;
import com.amundi.services.server.security.authenticator.session.DeprecatedHttpSessionAuthenticator;
import com.amundi.social.resources.LikeResource;

import net.active.services.server.security.core.authenticator.HttpAuthenticator;
import net.active.services.server.security.core.authenticator.basic.HttpBasicCustomAuthenticator;
import net.active.services.server.util.filter.CorsFilter;

/**
 * Created by liang on 26/04/2016.
 */

@ApplicationPath("api")
public class ApiServer extends AmundiSessionApplication {

	public ApiServer() {
		registerClasses(CorsFilter.class);
		registerClasses(LikeResource.class);
	}
	
    @Override
    protected HttpAuthenticator getDefaultHttpAuthenticator() {
        return new DeprecatedHttpSessionAuthenticator.Builder(
        		new HttpBasicCustomAuthenticator())
        		.useXsrfToken(false).build();
    }
}
