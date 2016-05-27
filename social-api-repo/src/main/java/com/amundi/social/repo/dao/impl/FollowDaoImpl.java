package com.amundi.social.repo.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.Follow;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.IFollowDao;
import com.amundi.social.repo.dao.mappers.FollowMapper;

public class FollowDaoImpl extends AbstractActivityDao<Follow> implements IFollowDao {

	public FollowDaoImpl() {
		super(FollowMapper.class);
	}
	
	@Override
	public void add(Follow follow) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(FollowMapper.class).add(follow);
			session.commit();
		}
	}

}
