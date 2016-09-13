package com.amundi.social.rest.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
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
    public static class CommentBody {
        @XmlElement public int note;
        @XmlElement public String content;
    }
	
	private CommentService commentService;

	public CommentResource() {
		super(new CommentService(new CommentDaoImpl()));
		this.commentService = (CommentService) super.activityService;
	}
	
	@PUT
    @Path("{appId}/{productId}")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response add(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId, final CommentBody commentBody) {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	Comment comment = new Comment();
    	comment.setAppId(appId);
    	comment.setProductId(productId);
    	comment.setUserId(userId);
    	comment.setTimestamp(new Date());
    	comment.setContent(commentBody.content);
    	comment.setNote(commentBody.note);
    	commentService.addComment(comment);
    	return Response.ok().build();
    }

    @DELETE
    @Path("{appId}/{productId}/{timestamp}")
    public Response remove(@HeaderParam("userId") String userId, @PathParam("appId") String appId, @PathParam("productId") String productId, @PathParam("timestamp") String ts) throws ParseException {
    	if(userId == null || userId.trim().isEmpty()) {
    		return Response.status(Status.BAD_REQUEST).build();
    	}
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
    	Comment comment = new Comment();
    	comment.setAppId(appId);
    	comment.setProductId(productId);
    	comment.setUserId(userId);
    	comment.setTimestamp(formatter.parse(ts));
    	commentService.removeActivity(comment);
    	return Response.ok().build();
    }

}
