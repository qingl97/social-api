package com.amundi.social.service.impl;

import java.util.Arrays;
import java.util.List;

import com.amundi.social.model.Like;
import com.amundi.social.service.api.LikeService;

public class LikeServiceImpl implements LikeService {

	public LikeServiceImpl() {
		System.out.println("LikeServiceImpl instanced");
	}

	@Override
	public void doLike(String userId, String appId, String productId) {
		
	}

	@Override
	public List<Like> getUserLikes(String userId) {
		Like like = new Like();
		like.setUserId(userId);
		return Arrays.asList(like);
	}

	@Override
	public List<Like> getLikes() {
		return Arrays.asList(new Like());
	}

	@Override
	public List<Like> getLikes(String appId) {
		Like like = new Like();
		like.setAppId(appId);
		return Arrays.asList(like);
	}

	@Override
	public List<Like> getLikes(String appId, String productId) {
		Like like = new Like();
		like.setAppId(appId);
		like.setProductId(productId);
		return Arrays.asList(like);
	}

	@Override
	public boolean isLike(String appId, String productId, String userId) {
		return false;
	}

}
