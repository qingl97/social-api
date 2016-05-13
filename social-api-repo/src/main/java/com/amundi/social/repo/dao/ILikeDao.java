package com.amundi.social.repo.dao;

import java.util.List;
import java.util.Map;

import com.amundi.social.common.model.Like;

public interface ILikeDao {

	List<Like> getAll();
	List<Like> getLikesByUser(String userId);
	List<Like> getLikesByApplication(String appId);
	List<Like> getLikesByProduct(String appId, String productId);
	
	void add(String appId, String productId, String userId);
	void delete(String appId, String productId, String userId);
	
	Map<String, List<Like>> getLikesByUsers(List<String> userIds); 
}
