package com.amundi.social.repo.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.Application;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.IApplicationDao;
import com.amundi.social.repo.dao.ICommentDao;
import com.amundi.social.repo.dao.IFavoriteDao;
import com.amundi.social.repo.dao.IFollowDao;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.mappers.ApplicationMapper;

public class ApplicationDaoImpl implements IApplicationDao {
	
	private ILikeDao likeDao = new LikeDaoImpl();
	private IFollowDao followDao = new FollowDaoImpl();
	private IFavoriteDao favoriteDao = new FavoriteDaoImpl();
	private ICommentDao commentDao = new CommentDaoImpl();

	@Override
	public Application get(String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(ApplicationMapper.class).get(appId);
		}
	}

	@Override
	public void add(String appId, String userId, String desc) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(ApplicationMapper.class).add(appId, userId, desc);
			session.commit();
		}
	}

	@Override
	public void delete(String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(ApplicationMapper.class).delete(appId);
			session.commit();
		}
	}

}
