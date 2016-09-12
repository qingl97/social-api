package com.amundi.social.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
public interface ProductView {

	@Path("/")
	@GET
	public Response getAll();
	
	@Path("/{app_id}")
	@GET
	public Response getByApplication(@PathParam("app_id") String appId);
	
	@Path("/{app_id}/{product_id}")
	@GET
	public Response getByProduct(@PathParam("app_id") String appId, @PathParam("product_id") String productId);
}