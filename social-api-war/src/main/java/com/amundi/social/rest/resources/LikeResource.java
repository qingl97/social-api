package com.amundi.social.rest.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.common.model.Like;
import com.amundi.social.rest.resources.impl.AbstractCommonRetrievingResource;

@Path("activity/likes")
public class LikeResource extends AbstractCommonRetrievingResource {

	public LikeResource() {
		super(ActionType.LIKE);
	}

	@PUT
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response doAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId) {
		Like like = new Like();
		like.setUserId(userId);
		like.setAppId(appId);
		like.setProductId(productId);
		activityService.add(like);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response undoAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId) {
		Like like = new Like();
		like.setUserId(userId);
		like.setAppId(appId);
		like.setProductId(productId);
		activityService.remove(like);
		return Response.ok().build();
	}

}
