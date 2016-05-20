package com.amundi.social.core.providers.impl;

import com.amundi.social.common.model.IAction;
import com.amundi.social.common.model.IAction.ActionType;
import com.amundi.social.repo.dao.ICommentDao;
import com.amundi.social.repo.dao.IFavoriteDao;
import com.amundi.social.repo.dao.IFollowDao;
import com.amundi.social.repo.dao.IGenericActivityDao;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.impl.CommentDaoImpl;
import com.amundi.social.repo.dao.impl.FavoriteDaoImpl;
import com.amundi.social.repo.dao.impl.FollowDaoImpl;
import com.amundi.social.repo.dao.impl.LikeDaoImpl;

public abstract class AbstractService {
	
	private ILikeDao likeDao = new LikeDaoImpl();
	private IFollowDao followDao = new FollowDaoImpl();
	private IFavoriteDao favoriteDao = new FavoriteDaoImpl();
	private ICommentDao commentDao = new CommentDaoImpl();

	protected IGenericActivityDao<? extends IAction> getConcreteDao(ActionType type) {
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