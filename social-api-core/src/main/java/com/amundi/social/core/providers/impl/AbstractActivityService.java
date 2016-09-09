package com.amundi.social.core.providers.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.providers.IActivityProvider;
import com.amundi.social.repo.dao.IActivityDao;

public abstract class AbstractActivityService<T extends IActivity> implements IActivityProvider {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractActivityService.class);
	
	protected IActivityDao<T> activityDao;
	
	protected AbstractActivityService(IActivityDao<T> activityDao) {
		this.activityDao = activityDao;
	}
	
	public void add(IActivity activity) {
		List<? extends IActivity> activities = activityDao.getActivitiesByUserApp(activity.getUserId(), activity.getAppId());
		for(IActivity ac : activities) {
			if(ac.getProductId().equalsIgnoreCase(activity.getProductId())) {
				LOGGER.debug("user already did " + activity.getType().toString() + ", operation ignored");
				return;
			}
		}
		activityDao.addActivity(activity);
	}

	@Override
	public void remove(IActivity activity) {
		activityDao.removeActivity(activity);
	}
	
	@Override
	public void remove(int activityId) {
		activityDao.removeActivity(activityId);
	}

	@Override
	public List<? extends IActivity> getAll() {
		return activityDao.getActivities();
	}
	
	@Override
	public List<? extends IActivity> getByUser(String userId) {
		return activityDao.getActivitiesByUser(userId);
	}
	
	@Override
	public List<? extends IActivity> getByUserApp(String userId, String appId) {
		return activityDao.getActivitiesByUserApp(userId, appId);
	}

	@Override
	public List<? extends IActivity> getByApp(String appId) {
		return activityDao.getActivitiesByApp(appId);
	}

	@Override
	public List<? extends IActivity> getByAppProduct(String appId, String productId) {
		return activityDao.getActivitiesByAppProduct(appId, productId);
	}
}
