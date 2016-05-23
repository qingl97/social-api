package com.amundi.social.repo.dao.mappers;

import org.apache.ibatis.annotations.Param;
import org.joda.time.DateTime;

import com.amundi.social.common.model.Application;

public interface ApplicationMapper {

	Application get(@Param("appId") String appId);
	void add(@Param("appId") String appId, @Param("userId") String creatorId, @Param("desc") String desc, @Param("time") DateTime time);
	void delete(@Param("appId") String appId);
	void clearData(@Param("appId") String appId);
}
