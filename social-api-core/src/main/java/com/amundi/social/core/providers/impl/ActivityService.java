package com.amundi.social.core.providers.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.repo.dao.IGenericActivityDao;

public class ActivityService extends AbstractActivityService {
	
	private static final Logger LOGGER = Logger.getLogger(ActivityService.class);
	
	@Override
	public void add(IActivity activity) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(activity.getType());
		List<? extends IActivity> activities = dao.getByUserApplication(activity.getUserId(), activity.getAppId());
		for(IActivity ac : activities) {
			if(ac.getProductId().equalsIgnoreCase(activity.getProductId())) {
				LOGGER.debug("user already did " + activity.getType().toString() + ", operation ignored");
				return;
			}
		}
		try {
			for(Method m : dao.getClass().getDeclaredMethods()) {
				if("add".equals(m.getName())) {
					m.invoke(dao, activity);
					return;
				}
			}
			throw new NoSuchMethodException();
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void remove(IActivity activity) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(activity.getType());
		dao.delete(activity);
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
	public List<? extends IActivity> getByUser(String userId, String appId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		return dao.getByUserApplication(userId, appId);
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
