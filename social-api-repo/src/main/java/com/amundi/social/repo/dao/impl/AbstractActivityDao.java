package com.amundi.social.repo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.IGenericActivityDao;
import com.amundi.social.repo.dao.mappers.GenericActivityMapper;

public abstract class AbstractActivityDao<T> implements IGenericActivityDao<T> {
	
	protected Class<? extends GenericActivityMapper<T>> mapper;
	
	
	public AbstractActivityDao(Class<? extends GenericActivityMapper<T>> mapper) {
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
	public int add(String appId, String productId, String userId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(mapper).add(userId, appId, productId);
		}
	}

	@Override
	public void delete(String appId, String productId, String userId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(mapper).delete(userId, appId, productId);
		}
	}

	@Override
	public Map<String, List<T>> getByUsers(List<String> userIds) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			Map<String, List<T>> rst = new HashMap<>();
			for(String userId : userIds) {
				rst.put(userId, session.getMapper(mapper).fetchByUser(userId));
			}
			return rst;
		} 
	}

}
