package com.amundi.social.rest.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

public interface ICommonResource {

	@GET
	public Response getAll(@QueryParam("detail") boolean detail);
	
	@GET 
	@Path("/user/{user_id}")
	public Response getUserActivities(@PathParam("user_id") String userId);
	
	@GET 
	@Path("/user/{user_id}/app/{app_id}")
	public Response getUserActivities(@PathParam("user_id") String userId, @PathParam("app_id") String appId);
	
	@GET
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response getUserActivity(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId);
	
	@PUT
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response doAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId);
	
	@DELETE
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response undoAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId);
	
	@GET
	@Path("/app/{app_id}")
	public Response getByApplication(@PathParam("app_id") String appId, @QueryParam("detail") boolean detail);
	
	@GET
	@Path("/app/{app_id}/product/{product_id}")
	public Response getByProduct(@PathParam("app_id") String appId, @PathParam("product_id") String productId, @QueryParam("detail") boolean detail);
	
}
