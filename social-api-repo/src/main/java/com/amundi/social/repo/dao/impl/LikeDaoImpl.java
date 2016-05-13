package com.amundi.social.repo.dao.impl;

import java.util.List;
import java.util.Map;

import com.amundi.social.common.model.Like;
import com.amundi.social.repo.dao.ILikeDao;

public class LikeDaoImpl implements ILikeDao {

	@Override
	public List<Like> getLikesByUser(String userId) {
		return null;
	}

	@Override
	public void add(String appId, String productId, String userId) {
		
	}

	@Override
	public void delete(String appId, String productId, String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, List<Like>> getLikesByUsers(List<String> userIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Like> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Like> getLikesByApplication(String appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Like> getLikesByProduct(String appId, String productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
