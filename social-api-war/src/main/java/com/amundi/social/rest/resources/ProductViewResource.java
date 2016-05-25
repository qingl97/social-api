package com.amundi.social.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("view")
@Produces(MediaType.APPLICATION_JSON)
public interface ProductViewResource {

	@Path("/all")
	@GET
	public Response getAll();
	
	@Path("/all/detail")
	@GET
	public Response getAllDetail(@QueryParam("detail") boolean detail);
	
	@Path("/app/{app_id}")
	@GET
	public Response getByApplication(@PathParam("app_id") String appId);
	
	@Path("/app/{app_id}/detail")
	@GET
	public Response getByApplicationDetail(@PathParam("app_id") String appId);
	
	@Path("/app/{app_id}/product/{product_id}")
	@GET
	public Response getByProduct(@PathParam("app_id") String appId, @PathParam("product_id") String productId);
	
	@Path("/app/{app_id}/product/{product_id}/detail")
	@GET
	public Response getByProductDetail(@PathParam("app_id") String appId, @PathParam("product_id") String productId);
}
