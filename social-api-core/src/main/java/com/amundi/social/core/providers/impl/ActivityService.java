package com.amundi.social.core.providers.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.common.providers.IActivityProvider;
import com.amundi.social.repo.dao.IGenericActivityDao;

public class ActivityService extends AbstractActivityService implements IActivityProvider {
	
	private static final Logger LOGGER = Logger.getLogger(ActivityService.class);

	@Override
	public void add(String userId, String appId, String productId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		List<? extends IActivity> activities = dao.getByUserApplication(userId, appId);
		for(IActivity activity : activities) {
			if(activity.getProductId().equalsIgnoreCase(productId)) {
				LOGGER.debug("user already did " + type.toString() + ", operation ignored");
				return;
			}
		}
		dao.add(appId, productId, userId);
	}
	
	@Override
	public void remove(String userId, String appId, String productId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		List<? extends IActivity> activities = dao.getByUserApplication(userId, appId);
		for(IActivity activity : activities) {
			if(activity.getProductId().equalsIgnoreCase(productId)) {
				dao.delete(appId, productId, userId);
				LOGGER.debug("undo " + type.toString() + " on product " + productId + " of app " + appId);
				return;
			}
		}
		LOGGER.debug("activity not found, operation ignored");
	}
	
	@Override
	public List<? extends IActivity> getAll() {
		List<IActivity> activities = new ArrayList<>();
		for(ActionType type : ActionType.values()) {
			activities.addAll(getAll(type));
		}
		return activities;
	}
	
	@Override
	public List<? extends IActivity> getAll(ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		return dao.getAll();
	}
	
	@Override
	public List<? extends IActivity> getByUser(String userId, String appId, String productId) {
		List<IActivity> activities = new ArrayList<>();
		for(ActionType type : ActionType.values()) {
			IActivity ac = getByUser(userId, appId, productId, type);
			if(ac != null)
				activities.add(ac);
		}
		return activities;
	}
	
	@Override
	public IActivity getByUser(String userId, String appId, String productId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		List<? extends IActivity> activities = dao.getByProduct(appId, productId);
		for(IActivity activity : activities) {
			if(activity.getUserId().equals(userId))
				return activity;
		}
		return null;
	}
	
	@Override
	public List<? extends IActivity> getByUser(String userId, String appId) {
		List<IActivity> activities = new ArrayList<>();
		for(ActionType type : ActionType.values()) {
			activities.addAll(getByUser(userId, appId, type));
		}
		return activities;
	}
	
	@Override
	public List<? extends IActivity> getByUser(String userId, String appId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		return dao.getByUserApplication(userId, appId);
	}
	
	@Override
	public List<? extends IActivity> getByUser(String userId) {
		List<IActivity> activities = new ArrayList<>();
		for(ActionType type : ActionType.values()) {
			activities.addAll(getByUser(userId, type));
		}
		return activities;
	}
	
	@Override
	public List<? extends IActivity> getByUser(String userId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		return dao.getByUser(userId);
	}
	
	@Override
	public List<? extends IActivity> get(String appId) {
		List<IActivity> activities = new ArrayList<>();
		for(ActionType type : ActionType.values()) {
			activities.addAll(get(appId, type));
		}
		return activities;
	}
	
	@Override
	public List<? extends IActivity> get(String appId, ActionType type) {
		return getConcreteDao(type).getByApplication(appId);
	}

	@Override
	public List<? extends IActivity> get(String appId, String productId) {
		List<IActivity> activities = new ArrayList<>();
		for(ActionType type : ActionType.values()) {
			activities.addAll(get(appId, productId, type));
		}
		return activities;
	}

	@Override
	public List<? extends IActivity> get(String appId, String productId, ActionType type) {
		return getConcreteDao(type).getByProduct(appId, productId);
	}
}
