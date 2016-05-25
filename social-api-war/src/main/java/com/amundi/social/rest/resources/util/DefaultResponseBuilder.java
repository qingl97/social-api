package com.amundi.social.rest.resources.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonProcessingException;

public class DefaultResponseBuilder {

	public static Response build(Object entity) {
		try {
			return Response.ok().entity(JsonUtil.serialize(entity)).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Failed to serialize object to JSON format").build();
		}
	}
}
