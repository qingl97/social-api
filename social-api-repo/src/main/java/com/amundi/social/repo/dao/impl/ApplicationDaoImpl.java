package com.amundi.social.repo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.Application;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.IApplicationDao;
import com.amundi.social.repo.dao.mappers.ApplicationMapper;

public class ApplicationDaoImpl implements IApplicationDao {

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

	@Override
	public List<Application> get() {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(ApplicationMapper.class).getAll();
		}
	}
}
