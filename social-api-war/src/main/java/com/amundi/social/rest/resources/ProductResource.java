package com.amundi.social.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.amundi.social.common.providers.IProductProvider;
import com.amundi.social.core.providers.impl.ProductService;

import net.active.services.server.util.AbstractResource;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource extends AbstractResource {
	
	private IProductProvider productService = new ProductService();
	
	@Path("/")
	@GET
	public Response getAll() {
		return buildDefaultResponse(productService.getAll());
	}

	@Path("/{app_id}")
	@GET
	public Response getByApplication(@PathParam("app_id") String appId) {
		return buildDefaultResponse(productService.get(appId));
	}

	@Path("/{app_id}/{product_id}")
	@GET
	public Response getByProduct(@PathParam("app_id") String appId, @PathParam("product_id") String productId) {
		return buildDefaultResponse(productService.get(appId, productId));
	}
}
