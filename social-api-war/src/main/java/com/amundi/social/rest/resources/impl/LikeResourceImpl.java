package com.amundi.social.rest.resources.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.IAction;
import com.amundi.social.common.model.IAction.ActionType;
import com.amundi.social.common.providers.IActivityProvider;
import com.amundi.social.common.providers.IProductProvider;
import com.amundi.social.core.providers.impl.ActivityService;
import com.amundi.social.core.providers.impl.ProductService;
import com.amundi.social.rest.resources.AbstractActionResource;
import com.amundi.social.rest.resources.LikeResource;

public class LikeResourceImpl extends AbstractActionResource implements LikeResource {
	
	private static final Logger LOGGER = Logger.getLogger(LikeResourceImpl.class);
	
	private IActivityProvider activityService = new ActivityService();
	private IProductProvider productService = new ProductService();

	@Override
	public Response doLike(String userId, String appId, String productId) {
		activityService.doAction(userId, appId, productId, ActionType.LIKE);
		LOGGER.info("user " + userId + " did like on product " + productId + " of application " + appId);
		return Response.ok().build();
	}

	@Override
	public Response undoLike(String userId, String appId, String productId) {
		activityService.undoAction(userId, appId, productId, ActionType.LIKE);
		LOGGER.info("user " + userId + " undo like on product " + productId + " of application " + appId);
		return Response.ok().build();
	}
	
	@Override
	public Response get(String userId, String appId, String productId) {
		IAction like = activityService.get(userId, appId, productId, ActionType.LIKE);
		return like == null ? Response.ok().entity("false").build() : Response.ok().entity("true").build();
	}

	@Override
	public Response getAll(boolean detail) {
		List<? extends Object> ret;
		ret = detail ? activityService.get(ActionType.LIKE) : productService.getAll();
		return buildDefaultJsonFormatResponse(ret);
	}

	@Override
	public Response getByApplication(String appId) {
		return buildDefaultJsonFormatResponse(productService.get(appId));
	}

	@Override
	public Response getByProduct(String appId, String productId) {
		return buildDefaultJsonFormatResponse(productService.get(appId, productId));
	}

	@Override
	public Response getUserLikedProducts(UriInfo uriInfo, String userId) {
		
		String appId, productId;
		MultivaluedMap<String, String> params = uriInfo.getQueryParameters();
		appId = params.containsKey("app") ? params.get("app").get(0) : null;
		productId = params.containsKey("product") ? params.get("product").get(0) : null;
		
		List<IAction> ret = new ArrayList<>();
		
		if(appId == null && productId == null) {
			ret.addAll(activityService.get(userId, ActionType.LIKE));
		}
		if(appId == null && productId != null) {
			return Response.status(Status.BAD_REQUEST).entity("product_id should be provided with existence of app_id").build();
		}
		if(appId != null && productId == null) {
			ret.addAll(activityService.get(userId, appId, ActionType.LIKE));
		}
		if(appId != null && productId != null) {
			IAction like = activityService.get(userId, appId, productId, ActionType.LIKE);
			if(like != null)
				ret.add(like);
		}
		
		return buildDefaultJsonFormatResponse(ret);
	}

}
