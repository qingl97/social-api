package com.amundi.social.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.active.services.server.security.core.annotation.NeedsAuthentication;

@Path("likes")
public class LikeResource extends AbstractActionResource {
	
	/**
	 * Get all likes of all products of all applications.
	 * 
	 * @return 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLikes(@Context HttpHeaders headers) {
		
		return this.buildDefaultResponse("[{\"app_id\":\"0001\",\"product_id\":\"0001\",\"count\":6}]");
	}
	
	@GET @Path("/detail")
	@Produces(MediaType.APPLICATION_JSON)
	@NeedsAuthentication
	public Response getLikeDetail(@Context HttpHeaders headers) {
		return this.buildDefaultResponse("[{\"app_id\":\"0001\",\"product_id\":\"0001\",\"user_id\":\"USR001\"}]");
	}
	
	@GET @Path("/user/{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserLikedProducts(@Context HttpHeaders headers, @PathParam("user_id") String userId) {
		return this.buildDefaultResponse("[{\"app_id\":\"0001\",\"product_id\":\"0001\"}]");
	}
	
	@GET @Path("/product/{product_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductLikeDetail(@Context HttpHeaders headers, @PathParam("product_id") String productId) {
		return this.buildDefaultResponse("[{\"app_id\":\"0001\",\"user_id\":\"USR001\"}]");
	}
	
}
