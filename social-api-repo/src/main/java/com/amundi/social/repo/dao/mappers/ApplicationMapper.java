package com.amundi.social.repo.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amundi.social.common.model.Application;

public interface ApplicationMapper {

	Application get(@Param("appId") String appId);
	List<Application> getAll();
	int add(@Param("appId") String appId, @Param("userId") String creatorId, @Param("desc") String desc);
	int delete(@Param("appId") String appId);
}
