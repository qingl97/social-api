package com.amundi.social.rest.resources.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.common.providers.IActivityProvider;
import com.amundi.social.core.providers.impl.ActivityService;
import com.amundi.social.repo.dao.impl.CommentDaoImpl;
import com.amundi.social.repo.dao.impl.FavoriteDaoImpl;
import com.amundi.social.repo.dao.impl.FollowDaoImpl;
import com.amundi.social.repo.dao.impl.LikeDaoImpl;
import com.amundi.social.rest.resources.ICommonRetrievingResource;
import com.amundi.social.rest.resources.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.active.services.server.util.AbstractResource;

public abstract class AbstractCommonActivityResource extends AbstractResource implements ICommonRetrievingResource {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractCommonActivityResource.class);
	
	private ActionType type;
	protected IActivityProvider activityService = new ActivityService(new LikeDaoImpl(), new FollowDaoImpl(), new FavoriteDaoImpl(), new CommentDaoImpl());
	
	public AbstractCommonActivityResource(ActionType type) {
		this.type = type;
	}

	@Override
	public Response getAll() {
		return buildDefaultJsonFormatResponse(activityService.getAll(type));
	}

	@Override
	public Response getUserActivities(String userId) {
		return buildDefaultJsonFormatResponse(activityService.getByUser(userId, type));
	}

	@Override
	public Response getUserActivities(String userId, String appId) {
		return buildDefaultJsonFormatResponse(activityService.getByUser(userId, appId, type));
	}

	@Override
	public Response getUserActivity(String userId, String appId, String productId) {
		IActivity activity = activityService.getByUser(userId, appId, productId, type);
		return activity != null ?  buildDefaultJsonFormatResponse(activity) : Response.ok().build();
	}

	@Override
	public Response getByApplication(String appId) {
		return buildDefaultJsonFormatResponse(activityService.get(appId, type));
	}

	@Override
	public Response getByProduct(String appId, String productId) {
		return buildDefaultJsonFormatResponse(activityService.get(appId, productId, type));
	}
	
	protected Response buildDefaultJsonFormatResponse(Object value) {
		try {
			return buildDefaultResponse(JsonUtil.serialize(value));
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage(), e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Failed to serialize object to JSON format").build();
		}
	}

}
