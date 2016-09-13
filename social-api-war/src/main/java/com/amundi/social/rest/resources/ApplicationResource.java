package com.amundi.social.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.amundi.social.core.providers.impl.ApplicationService;

import net.active.services.server.util.AbstractResource;

@Path("apps")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource extends AbstractResource {
	
	private ApplicationService applicationService;

	public ApplicationResource() {
		applicationService = new ApplicationService();
	}
	
	@GET
	public Response getRegisteredApps() {
		return buildDefaultResponse(applicationService.getApps());
	}
	
	@GET
	@Path("{appId}")
	public Response getApp(@PathParam("appId") String appId) {
		return buildDefaultResponse(applicationService.getById(appId));
	}
	
	@POST
	@Path("register/{refit}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response register(@HeaderParam("creatorId") String creatorId, @PathParam("refit") String refit, final String desc) {
		if(creatorId == null || creatorId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
		String appId = applicationService.generateId(Integer.parseInt(refit));
		applicationService.newApp(appId, creatorId, desc);
		return Response.ok().build();
	}
}
