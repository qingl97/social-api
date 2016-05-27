//package com.amundi.social.rest.resources;
//
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("activity")
//@Produces(MediaType.APPLICATION_JSON)
//public interface ICommonUserActivityResource {
//
//	@GET 
//	@Path("/user/{user_id}")
//	public Response getAll(
//			@PathParam("user_id") String userId, 
//			@QueryParam("type") String type);
//	
//	@GET 
//	@Path("/user/{user_id}/product/{app_id}")
//	public Response getByApplication(
//			@PathParam("user_id") String userId, 
//			@PathParam("app_id") String appId, 
//			@QueryParam("type") String type);
//	
//	@GET
//	@Path("/user/{user_id}/app/{app_id}/product/{product_id}")
//	public Response getActivity(
//			@PathParam("user_id") String userId, 
//			@PathParam("app_id") String appId, 
//			@PathParam("product_id") String productId,
//			@QueryParam("type") String type);
//	
//	@PUT
//	@Path("/user/{user_id}/app/{app_id}/product/{product_id}/{type}")
//	public Response add(
//			@PathParam("user_id") String userId, 
//			@PathParam("app_id") String appId, 
//			@PathParam("product_id") String productId,
//			@PathParam("type") String type);
//	
//	@DELETE
//	@Path("/user/{user_id}/app/{app_id}/product/{product_id}/{type}")
//	public Response remove(
//			@PathParam("user_id") String userId, 
//			@PathParam("app_id") String appId, 
//			@PathParam("product_id") String productId,
//			@PathParam("type") String type);
//}
