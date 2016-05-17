package com.amundi.social.repo.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amundi.social.common.model.Like;

public interface LikeMapper {
	
	List<Like> getAll();
	List<Like> getByApplication(@Param("appId") String appId);
	List<Like> getByProduct(@Param("appId") String appId, @Param("productId") String productId);
	List<Like> getByUser(@Param("userId") String userId);
	List<Like> getByUserApplication(@Param("userId") String userId, @Param("appId") String appId);
	
	int add(@Param("appId") String appId, @Param("productId") String productId, @Param("userId") String userId);
	void delete(@Param("appId") String appId, @Param("productId") String productId, @Param("userId") String userId);
}
