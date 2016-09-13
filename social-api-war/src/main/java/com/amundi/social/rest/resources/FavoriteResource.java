package com.amundi.social.rest.resources;

import java.util.Date;

import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.amundi.social.common.model.Favorite;
import com.amundi.social.core.providers.impl.FavoriteService;
import com.amundi.social.repo.dao.impl.FavoriteDaoImpl;

@Path("favorite")
@Produces(MediaType.APPLICATION_JSON)
public class FavoriteResource extends AbstractActivityResource<Favorite> {
	
	private FavoriteService favoriteService;

	public FavoriteResource() {
		super(new FavoriteService(new FavoriteDaoImpl()));
		this.favoriteService = (FavoriteService) super.activityService;
	}
	
	@PUT
    @Path("{appId}/{productId}")
    public Response add(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	Favorite favorite = new Favorite();
    	favorite.setAppId(appId);
    	favorite.setProductId(productId);
    	favorite.setUserId(userId);
    	favorite.setTimestamp(new Date());
    	favoriteService.addActivity(favorite);
    	return Response.ok().build();
    }

    @DELETE
    @Path("{appId}/{productId}")
    public Response remove(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	Favorite favorite = new Favorite();
    	favorite.setAppId(appId);
    	favorite.setProductId(productId);
    	favorite.setUserId(userId);
    	favorite.setTimestamp(new Date());
    	favoriteService.removeActivity(favorite);
    	return Response.ok().build();
    }

}
