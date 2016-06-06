package com.amundi.social.repo.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.Like;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.mappers.LikeMapper;

public class LikeDaoImpl extends GenericCommonActivityDao<Like> implements ILikeDao {
	
	public LikeDaoImpl() {
		super(LikeMapper.class);
	}
	
	@Override
	public void add(Like like) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(LikeMapper.class).add(like);
			session.commit();
		}
	}
}
