package com.amundi.social.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.amundi.social.common.model.Comment;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.rest.resources.impl.AbstractCommonRetrievingResource;

@Path("activity/comments")
public class CommentResource extends AbstractCommonRetrievingResource {
	
	@XmlRootElement
	public static class CommentBody {
		@XmlElement public int note;
		@XmlElement public String content;
	}

	public CommentResource() {
		super(ActionType.COMMENT);
	}

	@PUT
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId, final CommentBody body) {
		if(body == null) {
			return Response.status(Status.BAD_REQUEST).entity("bad post body").build();
		}
		Comment cmt = new Comment();
		cmt.setAppId(appId);
		cmt.setProductId(productId);
		cmt.setUserId(userId);
		cmt.setNote(body.note);
		cmt.setContent(body.content);
		activityService.add(cmt);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
	public Response undoAction(@PathParam("user_id") String userId, @PathParam("app_id") String appId, @PathParam("product_id") String productId) {
		Comment cmt = new Comment();
		cmt.setAppId(appId);
		cmt.setProductId(productId);
		cmt.setUserId(userId);
		activityService.remove(cmt);
		return Response.ok().build();
	}

}
