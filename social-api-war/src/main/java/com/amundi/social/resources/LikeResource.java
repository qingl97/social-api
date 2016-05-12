package com.amundi.social.resources;

import java.util.List;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.amundi.services.server.security.authenticator.session.DeprecatedHttpSessionAuthenticator;
import com.amundi.social.application.SocialAPISecurityConfig;
import com.amundi.social.model.Like;
import com.amundi.social.service.api.LikeService;
import com.amundi.social.service.impl.LikeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.active.services.common.RequestContextResolver;
import net.active.services.server.RequestContextResolverImpl;
import net.active.services.server.security.core.DefaultSubject;
import net.active.services.server.security.core.annotation.NeedsAuthentication;
import net.active.services.server.security.core.authenticator.HttpAuthenticator;
import net.active.services.server.security.core.authenticator.basic.HttpBasicCustomAuthenticator;

@Path("likes")
public class LikeResource extends AbstractActionResource {
	
	private static final Logger LOGGER = Logger.getLogger(LikeResource.class);
	
	private LikeService likeService = new LikeServiceImpl();

	@PUT @Path("/app/{appId}/product/{product_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response doLike(@Context HttpHeaders headers, @PathParam("product_id") String productId) {
		String userId = getUserId();
		String appId = getAppId(headers);
		
		if(userId == null)
			return Response.status(Status.UNAUTHORIZED).build();
		if(appId == null)
			return Response.status(Status.BAD_REQUEST).build();	
		
		likeService.doLike(userId, appId, productId);
		LOGGER.info("user " + userId + " did like on product " + productId + " of application " + appId);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLikes(@Context HttpHeaders headers) {
		try {
			RequestContextResolverImpl requestContextResolverImpl= 
					(RequestContextResolverImpl) RequestContextResolver.getInstance();
			if(!StringUtils.isBlank(
					requestContextResolverImpl.getHttpHeaders().getHeaderString(HttpHeaders.AUTHORIZATION))){
				try {
					HttpAuthenticator httpAuthenticator=new DeprecatedHttpSessionAuthenticator.Builder(
							new HttpBasicCustomAuthenticator()).useXsrfToken(false).build();
					DefaultSubject defaultSubject = 
							httpAuthenticator.authenticate(
									SocialAPISecurityConfig.REALM, 
									requestContextResolverImpl.getContainerRequestContext());
				} catch (FailedLoginException e) {
					e.printStackTrace();
				} catch (LoginException e) {
					e.printStackTrace();
				}
			}
			
			String appId = getAppId(headers);
			String jsonLikes = null;
			List<Like> likes;
			if(appId == null) {
				LOGGER.info("Getting likes for all applications");
				likes = likeService.getLikes();
			} else {
				LOGGER.info("Getting likes for application [id: " + appId + "]");
				likes = likeService.getLikes(appId);
			}
			jsonLikes = new ObjectMapper().writeValueAsString(likes);
			return buildDefaultResponse(jsonLikes);
		} catch(JsonProcessingException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Failed to serialize object to JSON format").build();
		}
	}
	
	@GET @Path("/detail")
	@Produces(MediaType.APPLICATION_JSON)
	@NeedsAuthentication(message="not authenticated")
	public Response getLikeDetail(@Context HttpHeaders headers) {
		if(isAuthenticated())
			return buildDefaultResponse("[{\"app_id\":\"0001\",\"product_id\":\"0001\",\"count\":6}]");
		return this.buildDefaultResponse("[{\"app_id\":\"0001\",\"product_id\":\"0001\",\"user_id\":\"USR001\"}]");
	}
	
	@GET @Path("/user/{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserLikedProducts(@Context HttpHeaders headers, @PathParam("user_id") String userId) {
		return this.buildDefaultResponse("[{\"app_id\":\"0001\",\"product_id\":\"0001\"}]");
	}
	
	@GET @Path("/product/{product_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductLikeDetail(@Context HttpHeaders headers, @PathParam("product_id") String productId) {
		return this.buildDefaultResponse("[{\"app_id\":\"0001\",\"user_id\":\"USR001\"}]");
	}
	
}
