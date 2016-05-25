package com.amundi.social.rest.resources.impl;

import javax.ws.rs.core.Response;

import com.amundi.social.common.providers.IActivityProvider;
import com.amundi.social.common.providers.IProductProvider;
import com.amundi.social.core.providers.impl.ActivityService;
import com.amundi.social.core.providers.impl.ProductService;
import com.amundi.social.rest.resources.ProductViewResource;
import com.amundi.social.rest.resources.util.DefaultResponseBuilder;

import net.active.services.server.util.AbstractResource;

public class ProductViewResourceImpl extends AbstractResource implements ProductViewResource {
	
	private IProductProvider productService = new ProductService();
	private IActivityProvider activityService = new ActivityService();
	
	@Override
	public Response getAll() {
		return DefaultResponseBuilder.build(productService.getAll());
	}
	
	@Override
	public Response getAllDetail(boolean detail) {
		return DefaultResponseBuilder.build(activityService.getAll());
	}

	@Override
	public Response getByApplication(String appId) {
		return DefaultResponseBuilder.build(productService.get(appId));
	}

	@Override
	public Response getByApplicationDetail(String appId) {
		return DefaultResponseBuilder.build(activityService.get(appId));
	}

	@Override
	public Response getByProduct(String appId, String productId) {
		return DefaultResponseBuilder.build(productService.get(appId, productId));
	}

	@Override
	public Response getByProductDetail(String appId, String productId) {
		return DefaultResponseBuilder.build(activityService.get(appId, productId));
	}
}
