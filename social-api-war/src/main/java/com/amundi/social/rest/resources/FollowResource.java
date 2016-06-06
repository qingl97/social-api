package com.amundi.social.rest.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.amundi.social.common.model.Follow;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.core.providers.impl.ActivityService;
import com.amundi.social.repo.dao.impl.CommentDaoImpl;
import com.amundi.social.repo.dao.impl.FavoriteDaoImpl;
import com.amundi.social.repo.dao.impl.FollowDaoImpl;
import com.amundi.social.repo.dao.impl.LikeDaoImpl;
import com.amundi.social.rest.resources.impl.AbstractCommonActivityResource;

@Path("activity/follows")
public class FollowResource extends AbstractCommonActivityResource {
	
	public FollowResource() {
		super(ActionType.FOLLOW);
		activityService = new ActivityService(new LikeDaoImpl(), new FollowDaoImpl(), new FavoriteDaoImpl(), new CommentDaoImpl());
	}

	@PUT
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response doAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId) {
		Follow fol = new Follow();
		fol.setUserId(userId);
		fol.setAppId(appId);
		fol.setProductId(productId);
		activityService.add(fol);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response undoAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId) {
		Follow fol = new Follow();
		fol.setUserId(userId);
		fol.setAppId(appId);
		fol.setProductId(productId);
		activityService.remove(fol);
		return Response.ok().build();
	}
}
