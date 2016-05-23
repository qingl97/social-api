package com.amundi.social.repo.dao;

import java.util.List;
import java.util.Map;

public interface IGenericActivityDao<T> {

	List<T> getAll();
	List<T> getByUser(String userId);
	List<T> getByUserApplication(String userId, String appId);
	T getByUserProduct(String userId, String appId, String productId);
	List<T> getByApplication(String appId);
	List<T> getByProduct(String appId, String productId);
	
	int add(String appId, String productId, String userId);
	void delete(String appId, String productId, String userId);
	void clear(String appId);
	
	Map<String, List<T>> getByUsers(List<String> userIds);
}
