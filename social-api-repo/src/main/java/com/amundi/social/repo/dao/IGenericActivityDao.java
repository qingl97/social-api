package com.amundi.social.repo.dao;

import java.util.List;

import com.amundi.social.common.model.IActivity;

public interface IGenericActivityDao<T> {

	List<T> getAll();
	List<T> getByUser(String userId);
	List<T> getByUserApplication(String userId, String appId);
	T getByUserProduct(String userId, String appId, String productId);
	List<T> getByApplication(String appId);
	List<T> getByProduct(String appId, String productId);

	void delete(IActivity activity);
	void clear(String appId);
}
