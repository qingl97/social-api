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

import com.amundi.social.common.model.Follow;
import com.amundi.social.core.providers.impl.FollowService;
import com.amundi.social.repo.dao.impl.FollowDaoImpl;

@Path("follow")
@Produces(MediaType.APPLICATION_JSON)
public class FollowResource extends AbstractActivityResource<Follow> {
	
	private FollowService followService;

	public FollowResource() {
		super(new FollowService(new FollowDaoImpl()));
		this.followService = (FollowService) super.activityService;
	}
	
	@PUT
    @Path("{appId}/{productId}")
    public Response add(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	Follow follow = new Follow();
    	follow.setAppId(appId);
    	follow.setProductId(productId);
    	follow.setUserId(userId);
    	follow.setTimestamp(new Date());
    	followService.addActivity(follow);
    	return Response.ok().build();
    }

    @DELETE
    @Path("{appId}/{productId}")
    public Response remove(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	Follow follow = new Follow();
    	follow.setAppId(appId);
    	follow.setProductId(productId);
    	follow.setUserId(userId);
    	follow.setTimestamp(new Date());
    	followService.removeActivity(follow);
    	return Response.ok().build();
    }

}
