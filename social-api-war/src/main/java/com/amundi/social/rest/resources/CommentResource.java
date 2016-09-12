package com.amundi.social.rest.resources;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.amundi.social.common.model.Comment;
import com.amundi.social.core.providers.impl.CommentService;
import com.amundi.social.repo.dao.impl.CommentDaoImpl;

@Path("comment")
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource extends AbstractActivityResource<Comment> {
	
	@XmlRootElement
    class CommentBody {
        @XmlElement public int note;
        @XmlElement public String content;
    }
	
	private CommentService commentService;

	public CommentResource() {
		super(new CommentService(new CommentDaoImpl()));
		this.commentService = (CommentService) super.activityService;
	}
	
	@POST
    @Path("{appId}/{productId}")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response add(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId, final CommentBody commentBody) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.ACCEPTED).build();
    	}
    	Comment comment = new Comment();
    	comment.setAppId(appId);
    	comment.setProductId(productId);
    	comment.setUserId(userId);
    	comment.setTimestamp(new Date());
    	comment.setContent(commentBody.content);
    	comment.setNote(commentBody.note);
    	commentService.add(comment);
    	return Response.ok().build();
    }

    @DELETE
    @Path("{appId}/{productId}")
    public Response remove(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	Comment comment = new Comment();
    	comment.setAppId(appId);
    	comment.setProductId(productId);
    	comment.setUserId(userId);
    	comment.setTimestamp(new Date());
    	commentService.remove(comment);
    	return Response.ok().build();
    }

}
