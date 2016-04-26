package com.amundi.social.conf;

import javax.ws.rs.Path;

import com.amundi.services.server.AmundiSessionApplication;
import com.amundi.services.server.security.authenticator.session.DeprecatedHttpSessionAuthenticator;
import com.amundi.social.resources.LikeResource;

import net.active.services.server.security.core.authenticator.HttpAuthenticator;
import net.active.services.server.security.core.authenticator.basic.HttpBasicCustomAuthenticator;
import net.active.services.server.util.filter.CorsFilter;

/**
 * Created by liang on 26/04/2016.
 */

@Path("/")
public class Application extends AmundiSessionApplication {

	public Application() {
		registerResources(LikeResource.class);
		registerClasses(CorsFilter.class);
	}
	
    @Override
    protected HttpAuthenticator getDefaultHttpAuthenticator() {
        return new DeprecatedHttpSessionAuthenticator.Builder(new HttpBasicCustomAuthenticator()).useXsrfToken(false)
                .build();
    }
}
