package com.amundi.social.repo.dao;

import org.joda.time.DateTime;

import com.amundi.social.common.model.Application;

public interface IApplicationDao {

	Application get(String appId);
	void add(String appId, String userId, String desc, DateTime time);
	void delete(String appId);
	void clearData(String appId);
}
