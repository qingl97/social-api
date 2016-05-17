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
		SqlSession session = SqlSessionProvider.openSession();
		try {
			return session.getMapper(LikeMapper.class).getByUser(userId);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Like> getLikesByUserApplication(String userId, String appId) {
		SqlSession session = SqlSessionProvider.openSession();
		try {
			return session.getMapper(LikeMapper.class).getByUserApplication(userId, appId);
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, List<Like>> getLikesByUsers(List<String> userIds) {
		SqlSession session = SqlSessionProvider.openSession();
		try {
			Map<String, List<Like>> rst = new HashMap<>();
			for(String userId : userIds) {
				rst.put(userId, session.getMapper(LikeMapper.class).getByUser(userId));
			}
			return rst;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Like> getAll() {
		SqlSession session = SqlSessionProvider.openSession();
		try {
			return session.getMapper(LikeMapper.class).getAll();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Like> getLikesByApplication(String appId) {
		SqlSession session = SqlSessionProvider.openSession();
		try {
			return session.getMapper(LikeMapper.class).getByApplication(appId);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Like> getLikesByProduct(String appId, String productId) {
		SqlSession session = SqlSessionProvider.openSession();
		try {
			List<Like> rst = session.getMapper(LikeMapper.class).getByProduct(appId, productId);
			return rst;
		} finally {
			session.close();
		}
	}
	
	@Override
	public int add(String appId, String productId, String userId) {
		SqlSession session = SqlSessionProvider.openSession();
		try {
			int id = session.getMapper(LikeMapper.class).add(appId, productId, userId);
			session.commit();
			return id;
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(String appId, String productId, String userId) {
		SqlSession session = SqlSessionProvider.openSession();
		try {
			session.getMapper(LikeMapper.class).delete(appId, productId, userId);
		} finally {
			session.close();
		}
	}
	
}
