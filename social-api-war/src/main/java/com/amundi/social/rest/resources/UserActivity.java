package com.amundi.social.rest.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by liang on 04/08/2016.
 */
@Path("activity/{action}")
@Produces(MediaType.APPLICATION_JSON)
public interface UserActivity {

    @XmlRootElement
    class CommentBody {
        @XmlElement public int note;
        @XmlElement public String content;
    }

    @GET
    Response getAllUserActivity(
            @PathParam("action") String action,
            @QueryParam("appId") String appId,
            @QueryParam("productId") String productId,
            @QueryParam("userId") String userId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response doAction(
            @PathParam("action") String action,
            @QueryParam("appId") String appId,
            @QueryParam("productId") String productId,
            @QueryParam("userId") String userId,
            final CommentBody comment);

    @DELETE
    Response undoAction(
            @PathParam("action") String action,
            @QueryParam("appId") String appId,
            @QueryParam("productId") String productId,
            @QueryParam("userId") String userId);
}
