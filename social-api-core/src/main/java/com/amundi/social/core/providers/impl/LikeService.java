package com.amundi.social.core.providers.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.Like;
import com.amundi.social.common.providers.ILikeProvider;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.impl.LikeDaoImpl;

public class LikeService implements ILikeProvider {
	
	private static final Logger LOGGER = Logger.getLogger(LikeService.class);
	
	private ILikeDao likeDao = new LikeDaoImpl();

	public void setLikeDao(ILikeDao likeDao) {
		this.likeDao = likeDao;
	}

	@Override
	public void doLike(String userId, String appId, String productId) {
		if(!isLike(appId, productId, userId)) {
			likeDao.add(appId, productId, userId);
		}
		else {
			LOGGER.info("Like operation ignored. User " + userId + " already liked product " + productId + " of application " + appId);
		}
	}
	
	@Override
	public void undoLike(String userId, String appId, String productId) {
		likeDao.delete(appId, userId, userId);
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
			if(like.getUserId().equals(userId))
				return true;
		return false;
	}

}
