package com.amundi.social.rest.resources.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class JsonUtil {
	
	private static ObjectMapper mapper = new ObjectMapper().registerModule(new JodaModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

	public static String serialize(Object value) throws JsonProcessingException {
		return mapper.writeValueAsString(value);
	}

}
