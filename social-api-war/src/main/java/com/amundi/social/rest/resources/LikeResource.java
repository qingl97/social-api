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

import com.amundi.social.common.model.Like;
import com.amundi.social.core.providers.impl.LikeService;
import com.amundi.social.repo.dao.impl.LikeDaoImpl;

/**
 * Created by liang on 07/09/2016.
 */
@Path("like")
@Produces(MediaType.APPLICATION_JSON)
public class LikeResource extends AbstractActivityResource<Like> {

    private LikeService likeService;
    
    public LikeResource() {
    	super(new LikeService(new LikeDaoImpl()));
    	this.likeService = (LikeService) super.activityService;
    }

    @PUT
    @Path("{appId}/{productId}")
    public Response add(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	Like like = new Like();
    	like.setAppId(appId);
    	like.setProductId(productId);
    	like.setUserId(userId);
    	like.setTimestamp(new Date());
    	likeService.add(like);
    	return Response.ok().build();
    }

    @DELETE
    @Path("{appId}/{productId}")
    public Response remove(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	Like like = new Like();
    	like.setAppId(appId);
    	like.setProductId(productId);
    	like.setUserId(userId);
    	like.setTimestamp(new Date());
    	likeService.remove(like);
    	return Response.ok().build();
    }
}
