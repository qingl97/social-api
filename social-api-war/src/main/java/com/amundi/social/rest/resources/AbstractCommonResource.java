package com.amundi.social.rest.resources;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.common.providers.IProductProvider;
import com.amundi.social.common.providers.IUserActivityProvider;
import com.amundi.social.core.providers.impl.ProductService;
import com.amundi.social.core.providers.impl.UserActivityService;
import com.amundi.social.rest.resources.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.active.services.server.util.AbstractResource;

public abstract class AbstractCommonResource extends AbstractResource implements ICommonResource {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractCommonResource.class);
	
	private ActionType type;
	private IUserActivityProvider userActivityService = new UserActivityService();
	private IProductProvider productService = new ProductService();
	
	public AbstractCommonResource(ActionType type) {
		this.type = type;
	}

	@Override
	public Response getAll(boolean detail) {
		List<? extends Object> ret;
		ret = detail ? userActivityService.get(type) : productService.getAll();
		return buildDefaultJsonFormatResponse(ret);
	}

	@Override
	public Response getUserActivities(String userId) {
		return buildDefaultJsonFormatResponse(userActivityService.get(userId, type));
	}

	@Override
	public Response getUserActivities(String userId, String appId) {
		return buildDefaultJsonFormatResponse(userActivityService.get(userId, appId, type));
	}

	@Override
	public Response getUserActivity(String userId, String appId, String productId) {
		IActivity activity = userActivityService.get(userId, appId, productId, type);
		return activity != null ?  buildDefaultJsonFormatResponse(activity) : Response.ok().build();
	}

	@Override
	public Response doAction(String userId, String appId, String productId) {
		userActivityService.add(userId, appId, productId, type);
		LOGGER.info("user " + userId + " does " + type.toString() + " on product " + productId + " of application " + appId);
		return Response.ok().build();
	}

	@Override
	public Response undoAction(String userId, String appId, String productId) {
		userActivityService.remove(userId, appId, productId, type);
		LOGGER.info("user " + userId + " undo " + type.toString() + " on product " + productId + " of application " + appId);
		return Response.ok().build();
	}

	@Override
	public Response getByApplication(String appId, boolean detail) {
		List<? extends Object> activities = 
				detail == true ? productService.getWithDetails(appId, type) : productService.get(appId);
		return buildDefaultJsonFormatResponse(activities);
	}

	@Override
	public Response getByProduct(String appId, String productId, boolean detail) {
		if(detail) {
			return buildDefaultJsonFormatResponse(productService.getWithDetails(appId, productId, type));
		} else {
			return buildDefaultJsonFormatResponse(productService.get(appId, productId));
		}
	}
	
	protected Response buildDefaultJsonFormatResponse(Object value) {
		try {
			return buildDefaultResponse(JsonUtil.serialize(value));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Failed to serialize object to JSON format").build();
		}
	}

}
