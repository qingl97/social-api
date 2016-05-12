package com.amundi.social.resources;

import javax.ws.rs.core.HttpHeaders;

import net.active.services.server.util.AbstractResource;
import net.active.services.server.security.SecurityManager;

public abstract class AbstractActionResource extends AbstractResource {

	public static final String APP_ID_HEADER = "APP_ID";
	
	public String getAppId(HttpHeaders headers) {
		if(headers.getRequestHeaders().containsKey(APP_ID_HEADER)) {
			System.out.println("Inside getAppId : Application ID : " + headers.getRequestHeaders().get(APP_ID_HEADER).get(0));
			return headers.getRequestHeader(APP_ID_HEADER).get(0);
		}
		return null;
	}
	
	public boolean isAuthenticated() {
		return SecurityManager.isSubjectAuthenticated();
	}
	
	protected String getUserId() {
		System.out.println(SecurityManager.getSubject().getPrimaryPrincipal().getName());
		return SecurityManager.getSubject().getPrimaryPrincipal().getName();
	}
}
