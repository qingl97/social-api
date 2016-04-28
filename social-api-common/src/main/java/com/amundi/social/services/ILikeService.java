package com.amundi.social.services;

import java.util.List;

import com.amundi.social.model.Like;

public interface ILikeService {

	List<Like> getAllLikes();
	
	List<Like> getApplicationLikes();
	
	List<Like> getProductLikes(String appId);
	
	List<Like> getUserLikes(String userId);
}
