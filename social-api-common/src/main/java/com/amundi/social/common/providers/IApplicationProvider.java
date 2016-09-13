package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.Application;

public interface IApplicationProvider {

	String generateId(int refIt);
	Application getById(String appId);
	void newApp(String appId, String userId, String desc);
	void delete(String appId);
	List<Application> getApps();
}
