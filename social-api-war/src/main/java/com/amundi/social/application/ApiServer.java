package com.amundi.social.application;

import javax.ws.rs.ApplicationPath;

import com.amundi.services.server.AmundiApplication;
import com.amundi.services.server.config.security.AmundiSecurityFeatureConfig;
import com.amundi.social.resources.LikeResource;

import net.active.services.server.util.filter.CorsFilter;

/**
 * Created by liang on 26/04/2016.
 */

@ApplicationPath("api")
public class ApiServer extends AmundiApplication {
	
	public ApiServer() {
		registerResources(CorsFilter.class);
		registerResources(LikeResource.class);
	}
	
	@Override
	protected AmundiSecurityFeatureConfig getSecurityFeatureConfig() {
		return new SocialAPISecurityConfig();
	}
}
