package com.amundi.social.repo.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amundi.social.common.model.IActivity;

public interface GenericActivityMapper<T> {
	
	List<T> fetchAll();
	
	List<T> fetchByApplication(@Param("appId") String appId);
	List<T> fetchByProduct(@Param("appId") String appId, @Param("productId") String productId);
	
	List<T> fetchByUser(@Param("userId") String userId);
	List<T> fetchByUserApplication(@Param("userId") String userId, @Param("appId") String appId);
	T fetchByUserProduct(@Param("userId") String userId, @Param("appId") String appId, @Param("productId") String productId);
	
	void delete(IActivity activity);
	void clear(@Param("appId") String appId);
}
