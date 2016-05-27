package com.amundi.social.rest.resources.impl;

import javax.ws.rs.core.Response;

import com.amundi.social.common.providers.IProductProvider;
import com.amundi.social.core.providers.impl.ProductService;
import com.amundi.social.rest.resources.ProductViewResource;
import com.amundi.social.rest.resources.util.DefaultJsonResponseBuilder;

import net.active.services.server.util.AbstractResource;

public class ProductViewResourceImpl extends AbstractResource implements ProductViewResource {
	
	private IProductProvider productService = new ProductService();
	
	@Override
	public Response getAll() {
		return DefaultJsonResponseBuilder.build(productService.getAll());
	}

	@Override
	public Response getByApplication(String appId) {
		return DefaultJsonResponseBuilder.build(productService.get(appId));
	}

	@Override
	public Response getByProduct(String appId, String productId) {
		return DefaultJsonResponseBuilder.build(productService.get(appId, productId));
	}
}
