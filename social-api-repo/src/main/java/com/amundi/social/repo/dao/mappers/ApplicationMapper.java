package com.amundi.social.repo.dao.mappers;

import org.apache.ibatis.annotations.Param;

import com.amundi.social.common.model.Application;

public interface ApplicationMapper {

	Application get(@Param("appId") String appId);
	int add(@Param("appId") String appId, @Param("userId") String creatorId, @Param("desc") String desc);
	int delete(@Param("appId") String appId);
}
