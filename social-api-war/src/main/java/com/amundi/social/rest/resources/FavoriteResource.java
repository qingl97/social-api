package com.amundi.social.rest.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.amundi.social.common.model.Favorite;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.rest.resources.impl.AbstractCommonRetrievingResource;

@Path("activity/favorites")
public class FavoriteResource extends AbstractCommonRetrievingResource {

	public FavoriteResource() {
		super(ActionType.FAVORITE);
	}

	@PUT
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response doAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId) {
		Favorite fav = new Favorite();
		fav.setUserId(userId);
		fav.setAppId(appId);
		fav.setProductId(productId);
		activityService.add(fav);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response undoAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId) {
		Favorite fav = new Favorite();
		fav.setUserId(userId);
		fav.setAppId(appId);
		fav.setProductId(productId);
		activityService.remove(fav);
		return Response.ok().build();
	}

}
