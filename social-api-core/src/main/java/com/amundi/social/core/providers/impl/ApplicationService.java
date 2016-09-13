package com.amundi.social.core.providers.impl;

import java.util.List;

import com.amundi.social.common.model.Application;
import com.amundi.social.common.providers.IApplicationProvider;
import com.amundi.social.repo.dao.IApplicationDao;
import com.amundi.social.repo.dao.impl.ApplicationDaoImpl;

public class ApplicationService implements IApplicationProvider {

	private IApplicationDao dao = new ApplicationDaoImpl();

	@Override
	public String generateId(int refIt) {
		return "APP-" + refIt;
	}

	@Override
	public Application getById(String appId) {
		return dao.get(appId);
	}

	@Override
	public void newApp(String appId, String userId, String desc) {
		dao.add(appId, userId, desc);
	}

	@Override
	public void delete(String appId) {
		dao.delete(appId);
	}

	@Override
	public List<Application> getApps() {
		return dao.get();
	}
}
