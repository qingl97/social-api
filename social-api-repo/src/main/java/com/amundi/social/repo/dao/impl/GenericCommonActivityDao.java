package com.amundi.social.repo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.IGenericActivityDao;
import com.amundi.social.repo.dao.mappers.GenericActivityMapper;

public abstract class GenericCommonActivityDao<T> implements IGenericActivityDao<T> {
	
	protected Class<? extends GenericActivityMapper<T>> mapper;
	
	
	public GenericCommonActivityDao(Class<? extends GenericActivityMapper<T>> mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<T> getAll() {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).fetchAll();
		}
	}

	@Override
	public List<T> getByUser(String userId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).fetchByUser(userId);
		}
	}

	@Override
	public List<T> getByUserApplication(String userId, String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).fetchByUserApplication(userId, appId);
		}
	}

	@Override
	public T getByUserProduct(String userId, String appId, String productId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).fetchByUserProduct(userId, appId, productId);
		}
	}

	@Override
	public List<T> getByApplication(String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).fetchByApplication(appId);
		}
	}

	@Override
	public List<T> getByProduct(String appId, String productId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).fetchByProduct(appId, productId);
		}
	}

	@Override
	public void delete(IActivity activity) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(mapper).delete(activity);
			session.commit();
		}
	}
	
	@Override
	public void clear(String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(mapper).clear(appId);
			session.commit();
		}
	}
}
