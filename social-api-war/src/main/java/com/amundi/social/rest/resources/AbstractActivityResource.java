package com.amundi.social.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.core.providers.impl.AbstractActivityService;

import net.active.services.server.util.AbstractResource;

public abstract class AbstractActivityResource<T extends IActivity> extends AbstractResource {
	
	protected AbstractActivityService<T> activityService;

	protected AbstractActivityResource(AbstractActivityService<T> activityService) {
		this.activityService = activityService;
	}

	@DELETE
	@Path("{activityId}")
	public Response remove(@PathParam("activityId") int activityId) {
    	activityService.remove(activityId);
    	return Response.ok().build();
    }

	@GET
	public Response get(@HeaderParam("userId") String userId) {
    	List<IActivity> likes = new ArrayList<>();
    	if(userId != null && !userId.trim().isEmpty()) {
    		likes.addAll(activityService.getByUser(userId));
    	} else {
    		likes.addAll(activityService.getAll());
    	}
    	return buildDefaultResponse(likes);
    }

	@GET
	@Path("{appId}")
	public Response get(@HeaderParam("userId") String userId, @PathParam("appId") String appId) {
    	List<IActivity> likes = new ArrayList<>();
    	if(userId != null && !userId.trim().isEmpty()) {
    		likes.addAll(activityService.getByUserApp(userId, appId));
    	} else {
    		likes.addAll(activityService.getByApp(appId));
    	}
    	return buildDefaultResponse(likes);
    }

	@GET
	@Path("{appId}/{productId}")
	public Response get(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId) {
    	if(userId != null && !userId.trim().isEmpty()) {
    		List<? extends IActivity> userLikes = activityService.getByUserApp(userId, appId);
    		for(IActivity activity : userLikes) {
    			if(activity.getProductId().equals(productId)) {
    				return buildDefaultResponse(activity);
    			}
    		}
    	} else {
    		return buildDefaultResponse(activityService.getByAppProduct(appId, productId));
    	}
    	
    	return buildDefaultResponse(null);
    }
}
