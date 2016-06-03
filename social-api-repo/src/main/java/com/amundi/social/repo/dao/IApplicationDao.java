package com.amundi.social.repo.dao;

import com.amundi.social.common.model.Application;

public interface IApplicationDao {

	Application get(String appId);
	void add(String appId, String userId, String desc);
	void delete(String appId);
}
