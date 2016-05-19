package com.amundi.social.rest.application;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amundi.social.rest.application.ApiServer;

public class ApiServerTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void should_not_throw_exception_when_instanced() {
		@SuppressWarnings("unused")
		ApiServer server = new ApiServer();
	}

}
