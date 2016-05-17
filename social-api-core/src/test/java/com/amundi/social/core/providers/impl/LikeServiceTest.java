package com.amundi.social.core.providers.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class LikeServiceTest {
	
	private LikeService likeService = new LikeService();
	
	@Test
	public void testIsLike() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoLike() {
		// data
		String appId = "APP001";
		String productId = "APP001-001";
		String userId = "prenom.nom@amundi.com";
		
		// action
		likeService.doLike(userId, appId, productId);
		
		// check
		
	}

	@Test
	public void testUndoLike() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserLikes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLikes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLikesString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLikesStringString() {
		fail("Not yet implemented");
	}

}
