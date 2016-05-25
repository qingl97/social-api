package com.amundi.social.rest.resources.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.common.providers.IActivityProvider;
import com.amundi.social.core.providers.impl.ActivityService;
import com.amundi.social.rest.resources.ICommonUserActivityResource;
import com.amundi.social.rest.resources.util.DefaultResponseBuilder;

import net.active.services.server.util.AbstractResource;

public class UserActivityResourceImpl extends AbstractResource implements ICommonUserActivityResource {
	
	private IActivityProvider userActivityService = new ActivityService();

	@Override
	public Response getAll(String userId, String type) {
		if(type == null) {
			return DefaultResponseBuilder.build(userActivityService.getByUser(userId));
		}
		return DefaultResponseBuilder.build(userActivityService.getByUser(userId, ActionType.fromString(type)));
	}

	@Override
	public Response getByApplication(String userId, String appId, String type) {
		if(type == null) {
			return DefaultResponseBuilder.build(userActivityService.getByUser(userId, appId));
		}
		return DefaultResponseBuilder.build(userActivityService.getByUser(userId, appId, ActionType.fromString(type)));
	}

	@Override
	public Response getActivity(String userId, String appId, String productId, String type) {
		return DefaultResponseBuilder.build(
				type == null ? 
						userActivityService.getByUser(userId, appId, productId):
						userActivityService.getByUser(userId, appId, productId, ActionType.fromString(type)));
	}

	@Override
	public Response add(String userId, String appId, String productId, String type) {
		if(type == null) {
			return Response.status(Status.BAD_REQUEST).entity("must specify the activity type in order to add one").build();
		}
		return DefaultResponseBuilder.build(userActivityService.getByUser(userId, appId, productId, ActionType.fromString(type)));
	}

	@Override
	public Response remove(String userId, String appId, String productId, String type) {
		if(type == null) {
			return Response.status(Status.BAD_REQUEST).entity("must specify the activity type in order to delete one").build();
		}
		return DefaultResponseBuilder.build(userActivityService.getByUser(userId, appId, productId, ActionType.fromString(type)));
	}

}
