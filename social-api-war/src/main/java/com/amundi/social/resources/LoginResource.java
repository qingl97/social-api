package com.amundi.social.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import com.amundi.services.server.security.JsonUser;

import net.active.services.server.security.SecurityManager;
import net.active.services.server.security.core.annotation.NeedsAuthentication;
import net.active.services.server.util.AbstractResource;

@Path("/auth")
public class LoginResource extends AbstractResource {
	
	private static final Logger LOGGER = Logger.getLogger(LoginResource.class);

	@Context
	private HttpServletRequest request;

	@GET @Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	@NeedsAuthentication
	public Response getUser() {
		return Response.ok(new JsonUser(SecurityManager.getSubject())).build();
	}
	
	@DELETE @Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	@NeedsAuthentication
	public Response logout() {
		request.getSession().invalidate();
		return buildDeletedResponse();
	}
}
