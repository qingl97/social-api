package com.amundi.social.repo.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GenericActivityMapper<T> {
	
	List<T> fetchAll();
	
	List<T> fetchByApplication(@Param("appId") String appId);
	List<T> fetchByProduct(@Param("appId") String appId, @Param("productId") String productId);
	
	List<T> fetchByUser(@Param("userId") String userId);
	List<T> fetchByUserApplication(@Param("userId") String userId, @Param("appId") String appId);
	T fetchByUserProduct(@Param("userId") String userId, @Param("appId") String appId, @Param("productId") String productId);
	
	int add(@Param("userId") String userId, @Param("appId") String appId, @Param("productId") String productId);
	void delete(@Param("userId") String userId, @Param("appId") String appId, @Param("productId") String productId);
	void clear(@Param("appId") String appId);
}
