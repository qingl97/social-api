package com.amundi.social.resources;

import javax.ws.rs.core.HttpHeaders;

import net.active.services.server.util.AbstractResource;

public abstract class AbstractActionResource extends AbstractResource {

	public static final String APP_ID_HEADER = "APP_ID";
	
	public String getAppId(HttpHeaders headers) {
		if(headers.getRequestHeader(APP_ID_HEADER) != null) {
			return headers.getRequestHeader(APP_ID_HEADER).get(0);
		}
		return null;
	}
	
	public boolean isAuthenticated() {
		return true;
	}
}
