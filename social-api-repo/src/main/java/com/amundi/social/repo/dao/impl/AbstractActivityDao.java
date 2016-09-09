package com.amundi.social.repo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.IActivityDao;
import com.amundi.social.repo.dao.mappers.CommonActivityMapper;

public abstract class AbstractActivityDao<T extends IActivity> implements IActivityDao<T> {
	
	protected Class<? extends CommonActivityMapper<T>> mapper;

	public AbstractActivityDao(Class<? extends CommonActivityMapper<T>> mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<T> getActivities() {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).getAll();
		}
	}

	@Override
	public List<T> getActivitiesByUser(String userId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).getByUser(userId);
		}
	}

	@Override
	public List<T> getActivitiesByUserApp(String userId, String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).getByUserApp(userId, appId);
		}
	}

	@Override
	public List<T> getActivitiesByApp(String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).getByApp(appId);
		}
	}
	
	@Override
	public List<T> getActivitiesByAppProduct(String appId, String productId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).getByAppProduct(appId, productId);
		}
	}
	
	@Override
	public int addActivity(IActivity activity) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			int activityId = session.getMapper(mapper).add(activity);
			session.commit();
			return activityId;
		}
	}
	
	@Override
	public void removeActivity(int activityId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(mapper).remove(activityId);
			session.commit();
		}
	}
	
	@Override
	public void removeActivity(IActivity activity) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(mapper).remove(activity);
			session.commit();
		}
	}
}
