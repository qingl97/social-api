package com.amundi.social.core.providers.impl;

import java.util.List;

import com.amundi.social.common.model.IAction;
import com.amundi.social.common.model.IAction.ActionType;
import com.amundi.social.common.providers.IActivityProvider;
import com.amundi.social.repo.dao.ICommentDao;
import com.amundi.social.repo.dao.IFavoriteDao;
import com.amundi.social.repo.dao.IFollowDao;
import com.amundi.social.repo.dao.IGenericActivityDao;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.impl.CommentDaoImpl;
import com.amundi.social.repo.dao.impl.FavoriteDaoImpl;
import com.amundi.social.repo.dao.impl.FollowDaoImpl;
import com.amundi.social.repo.dao.impl.LikeDaoImpl;

public class ActivityService implements IActivityProvider {

	private ILikeDao likeDao = new LikeDaoImpl();
	private IFollowDao followDao = new FollowDaoImpl();
	private IFavoriteDao favoriteDao = new FavoriteDaoImpl();
	private ICommentDao commentDao = new CommentDaoImpl();

//	@Override
//	public List<Like> getLikes(String userId) {
//		return likeDao.getByUser(userId);
//	}
//
//	@Override
//	public List<Favorite> getFavorites(String userId) {
//		return favoriteDao.getByUser(userId);
//	}
//
//	@Override
//	public List<Follow> getFollows(String userId) {
//		return followDao.getByUser(userId);
//	}
//
//	@Override
//	public List<Comment> getComments(String userId) {
//		return commentDao.getByUser(userId);
//	}
//
//	@Override
//	public List<Like> getLikes(String userId, String appId) {
//		return likeDao.getByUserApplication(userId, appId);
//	}
//
//	@Override
//	public List<Favorite> getFavorites(String userId, String appId) {
//		return favoriteDao.getByUserApplication(userId, appId);
//	}
//
//	@Override
//	public List<Follow> getFollows(String userId, String appId) {
//		return followDao.getByUserApplication(userId, appId);
//	}
//
//	@Override
//	public List<Comment> getComments(String userId, String appId) {
//		return commentDao.getByUserApplication(userId, appId);
//	}

//	@Override
//	public void doLike(String userId, String appId, String productId) {
//		List<Like> likes = likeDao.getByUserApplication(userId, appId);
//		for(Like like : likes) {
//			if(like.getProductId().equalsIgnoreCase(productId))
//				return;
//		}
//		likeDao.add(appId, productId, userId);
//	}
//
//	@Override
//	public void doFavorite(String userId, String appId, String productId) {
//		List<Favorite> favs = favoriteDao.getByUserApplication(userId, appId);
//		for(Favorite fav : favs) {
//			if(fav.getProductId().equalsIgnoreCase(productId))
//				return;
//		}
//		favoriteDao.add(appId, productId, userId);
//	}
//
//	@Override
//	public void doFollow(String userId, String appId, String productId) {
//		List<Follow> fols = followDao.getByUserApplication(userId, appId);
//		for(Follow fol : fols) {
//			if(fol.getProductId().equalsIgnoreCase(productId))
//				return;
//		}
//		followDao.add(appId, productId, userId);
//	}
//
//	@Override
//	public void comment(String userId, String appId, String productId, String content, int note) {
//		List<Comment> comments = commentDao.getByUserApplication(userId, appId);
//		for(Comment comment : comments) {
//			if(comment.getProductId().equalsIgnoreCase(productId))
//				return;
//		}
//		commentDao.add(appId, productId, userId);
//	}
	
	

//	@Override
//	public List<Like> getLikes() {
//		return likeDao.getAll();
//	}
//
//	@Override
//	public List<Favorite> getFavorites() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Follow> getFollows() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Comment> getComments() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Like getLike(String userId, String appId, String productId) {
//		List<Like> likes = likeDao.getByProduct(appId, productId);
//		for(Like like : likes) {
//			if(like.getUserId().equals(userId))
//				return like;
//		}
//		return null;
//	}
//
//	@Override
//	public Favorite getFavorite(String userId, String appId, String productId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Follow getFollow(String userId, String appId, String productId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public void doAction(String userId, String appId, String productId, ActionType type) {
		IGenericActivityDao<? extends IAction> dao = getConcreteDao(type);
		List<? extends IAction> activities = dao.getByUserApplication(userId, appId);
		for(IAction activity : activities) {
			if(activity.getProductId().equalsIgnoreCase(productId))
				return;
		}
		dao.add(appId, productId, userId);
	}
	
	@Override
	public void undoAction(String userId, String appId, String productId, ActionType type) {
		IGenericActivityDao<? extends IAction> dao = getConcreteDao(type);
		List<? extends IAction> activities = dao.getByUserApplication(userId, appId);
		for(IAction activity : activities) {
			if(activity.getProductId().equalsIgnoreCase(productId))
				dao.delete(appId, productId, userId);
		}
	}
	
	@Override
	public List<? extends IAction> get(ActionType type) {
		IGenericActivityDao<? extends IAction> dao = getConcreteDao(type);
		return dao.getAll();
	}
	
	@Override
	public IAction get(String userId, String appId, String productId, ActionType type) {
		IGenericActivityDao<? extends IAction> dao = getConcreteDao(type);
		List<? extends IAction> activities = dao.getByProduct(appId, productId);
		for(IAction activity : activities) {
			if(activity.getUserId().equals(userId))
				return activity;
		}
		return null;
	}
	
	@Override
	public List<? extends IAction> get(String userId, String appId, ActionType type) {
		IGenericActivityDao<? extends IAction> dao = getConcreteDao(type);
		return dao.getByUserApplication(userId, appId);
	}
	
	@Override
	public List<? extends IAction> get(String userId, ActionType type) {
		IGenericActivityDao<? extends IAction> dao = getConcreteDao(type);
		return dao.getByUser(userId);
	}
	
	private IGenericActivityDao<? extends IAction> getConcreteDao(ActionType type) {
		if(type == ActionType.LIKE)
			return likeDao;
		if(type == ActionType.FAVORITE)
			return favoriteDao;
		if(type == ActionType.FOLLOW)
			return followDao;
		if(type == ActionType.COMMENT)
			return commentDao;
		throw new IllegalArgumentException();
	}
}
