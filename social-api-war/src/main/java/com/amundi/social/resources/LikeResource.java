package com.amundi.social.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.active.services.server.security.core.annotation.NeedsAuthentication;
import net.active.services.server.util.AbstractResource;

@Path("/likes")
@NeedsAuthentication
public class LikeResource extends AbstractResource {

	/**
	 * Get all likes of all products of all applications.
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLikes() {
		
		return null;
	}
	
	public LikeResource() {
		
	}

}
