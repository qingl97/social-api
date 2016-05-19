package com.amundi.social.core.providers.impl;

import java.util.List;

import com.amundi.social.common.model.Comment;
import com.amundi.social.common.model.Favorite;
import com.amundi.social.common.model.Follow;
import com.amundi.social.common.model.Like;
import com.amundi.social.common.providers.IUserProvider;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.impl.LikeDaoImpl;

public class UserService implements IUserProvider {

	private ILikeDao likeDao = new LikeDaoImpl();

	@Override
	public List<Like> getLikes(String userId) {
		return likeDao.getLikesByUser(userId);
	}

	@Override
	public List<Favorite> getFavorites(String userId) {
		return null;
	}

	@Override
	public List<Follow> getFollows(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getComments(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Like> getLikes(String userId, String appId) {
		return likeDao.getLikesByUserApplication(userId, appId);
	}

	@Override
	public List<Favorite> getFavorites(String userId, String appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Follow> getFollows(String userId, String appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getComments(String userId, String appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doLike(String userId, String appId, String productId) {
		List<Like> likes = likeDao.getLikesByUserApplication(userId, appId);
		for(Like like : likes) {
			if(like.getProductId().equalsIgnoreCase(productId))
				return;
		}
		likeDao.add(appId, productId, userId);
	}

	@Override
	public void doFavorite(String userId, String appId, String productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFollow(String userId, String appId, String productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void comment(String userId, String appId, String productId, String content, int note) {
		// TODO Auto-generated method stub

	}

	@Override
	public void undoLike(String userId, String appId, String productId) {
		List<Like> likes = likeDao.getLikesByUserApplication(userId, appId);
		for(Like like : likes) {
			if(like.getProductId().equalsIgnoreCase(productId))
				likeDao.delete(appId, productId, userId);
		}
	}

	@Override
	public void undoFavorite(String userId, String appId, String productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void undoFollow(String userId, String appId, String productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Like> getLikes() {
		return likeDao.getAll();
	}

	@Override
	public List<Favorite> getFavorites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Follow> getFollows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Like getLike(String userId, String appId, String productId) {
		List<Like> likes = likeDao.getLikesByProduct(appId, productId);
		for(Like like : likes) {
			if(like.getUserId().equals(userId))
				return like;
		}
		return null;
	}

	@Override
	public Favorite getFavorite(String userId, String appId, String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Follow getFollow(String userId, String appId, String productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
