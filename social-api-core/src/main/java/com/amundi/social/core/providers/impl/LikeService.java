package com.amundi.social.core.providers.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.Like;
import com.amundi.social.common.providers.ILikeProvider;
import com.amundi.social.repo.dao.ILikeDao;

public class LikeService implements ILikeProvider {
	
	private static final Logger LOGGER = Logger.getLogger(LikeService.class);
	
	private ILikeDao likeDao;

	public void setLikeDao(ILikeDao likeDao) {
		this.likeDao = likeDao;
	}

	@Override
	public void doLike(String userId, String appId, String productId) {
		likeDao.add(appId, userId, userId);
	}

	@Override
	public List<Like> getUserLikes(String userId) {
		return likeDao.getLikesByUser(userId);
	}

	@Override
	public List<Like> getLikes() {
		return likeDao.getAll();
	}

	@Override
	public List<Like> getLikes(String appId) {
		return likeDao.getLikesByApplication(appId);
	}

	@Override
	public List<Like> getLikes(String appId, String productId) {
		return likeDao.getLikesByProduct(appId, productId);
	}

	@Override
	public boolean isLike(String appId, String productId, String userId) {
		List<Like> likes = getLikes(appId, productId);
		for(Like like : likes) 
			if(like.getUserId() == userId)
				return true;
		return false;
	}

}
