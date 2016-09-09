package com.amundi.social.repo.dao.mappers;

import org.apache.ibatis.annotations.Param;

import com.amundi.social.common.model.IActivity;

import java.util.List;

public interface CommonActivityMapper<T> {
	
	int add(IActivity activity);
	void remove(@Param("activityId") int activityId);
	void remove(IActivity activity);
	List<T> getAll();
	List<T> getByApp(@Param("appId") String appId);
	List<T> getByAppProduct(@Param("appId") String appId, @Param("productId") String productId);
	List<T> getByUser(@Param("userId") String userId);
	List<T> getByUserApp(@Param("userId") String userId, @Param("appId") String appId);
}
