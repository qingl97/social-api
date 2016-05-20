package com.amundi.social.rest.application;

import javax.ws.rs.ApplicationPath;

import com.amundi.services.server.AmundiApplication;
import com.amundi.services.server.config.security.AmundiSecurityFeatureConfig;
import com.amundi.social.rest.resources.CommentResource;
import com.amundi.social.rest.resources.FavoriteResource;
import com.amundi.social.rest.resources.FollowResource;
import com.amundi.social.rest.resources.LikeResource;

import net.active.services.server.util.filter.CorsFilter;

/**
 * Created by liang on 26/04/2016.
 */

@ApplicationPath("api")
public class ApiServer extends AmundiApplication {
	
	public ApiServer() {
		registerResources(CorsFilter.class);
		registerResources(LikeResource.class);
		registerResources(FollowResource.class);
		registerResources(FavoriteResource.class);
		registerResources(CommentResource.class);
	}
	
	@Override
	protected AmundiSecurityFeatureConfig getSecurityFeatureConfig() {
		return new SocialAPISecurityConfig();
	}
}
