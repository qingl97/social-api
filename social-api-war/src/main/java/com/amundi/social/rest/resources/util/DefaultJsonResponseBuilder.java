package com.amundi.social.rest.resources.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

public class DefaultJsonResponseBuilder {
	
	private static final Logger LOGGER = Logger.getLogger(DefaultJsonResponseBuilder.class);

	public static Response build(Object entity) {
		try {
			return Response.ok().entity(JsonUtil.serialize(entity)).build();
		} catch (JsonProcessingException e) {
			LOGGER.error(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Failed to serialize object to JSON format").build();
		}
	}
}
