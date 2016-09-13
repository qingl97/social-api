package com.amundi.social.repo.dao;

import java.util.List;

import com.amundi.social.common.model.Application;

public interface IApplicationDao {

	Application get(String appId);
	List<Application> get();
	void add(String appId, String userId, String desc);
	void delete(String appId);
}
