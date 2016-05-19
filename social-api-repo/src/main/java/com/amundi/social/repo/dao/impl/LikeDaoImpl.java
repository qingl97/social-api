package com.amundi.social.repo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.Like;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.mappers.LikeMapper;

public class LikeDaoImpl implements ILikeDao {
	
	@Override
	public List<Like> getLikesByUser(String userId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(LikeMapper.class).getByUser(userId);
		}
	}
	
	@Override
	public List<Like> getLikesByUserApplication(String userId, String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(LikeMapper.class).getByUserApplication(userId, appId);
		} 
	}

	@Override
	public Map<String, List<Like>> getLikesByUsers(List<String> userIds) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			Map<String, List<Like>> rst = new HashMap<>();
			for(String userId : userIds) {
				rst.put(userId, session.getMapper(LikeMapper.class).getByUser(userId));
			}
			return rst;
		} 
	}

	@Override
	public List<Like> getAll() {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(LikeMapper.class).getAll();
		} 
	}

	@Override
	public List<Like> getLikesByApplication(String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(LikeMapper.class).getByApplication(appId);
		} 
	}

	@Override
	public List<Like> getLikesByProduct(String appId, String productId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			List<Like> rst = session.getMapper(LikeMapper.class).getByProduct(appId, productId);
			return rst;
		}
	}
	
	@Override
	public int add(String appId, String productId, String userId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			int id = session.getMapper(LikeMapper.class).add(appId, productId, userId);
			session.commit();
			return id;
		}
	}

	@Override
	public void delete(String appId, String productId, String userId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(LikeMapper.class).delete(appId, productId, userId);
		}
	}
	
}
