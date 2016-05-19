package com.amundi.social.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("likes")
@Produces(MediaType.APPLICATION_JSON)
public interface LikeResource {
	
	@PUT
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response doLike(@PathParam("user_id") String userId, 
						   @PathParam("app_id") String appId,
						   @PathParam("product_id") String productId);
	
	@DELETE
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response undoLike(@PathParam("user_id") String userId, 
							 @PathParam("app_id") String appId,
							 @PathParam("product_id") String productId);
	
	@GET
	public Response getAll(@QueryParam("detail") boolean detail);
	
	@GET 
	@Path("/app/{app_id}")
	public Response getByApplication(@PathParam("app_id") String appId);
	
	@GET
	@Path("/app/{app_id}/product/{product_id}")
	public Response getByProduct(@PathParam("app_id") String appId, @PathParam("product_id") String productId);
	
	@GET 
	@Path("/user/{user_id}")
	public Response getUserLikedProducts(@Context UriInfo uriInfo, @PathParam("user_id") String userId);
	
}
