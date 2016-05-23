package com.amundi.social.core.providers.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.common.providers.IUserActivityProvider;
import com.amundi.social.repo.dao.IGenericActivityDao;

public class UserActivityService extends AbstractService implements IUserActivityProvider {
	
	private static final Logger LOGGER = Logger.getLogger(UserActivityService.class);

	@Override
	public void doAction(String userId, String appId, String productId, ActionType type) {
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
	public void undoAction(String userId, String appId, String productId, ActionType type) {
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
	public List<? extends IActivity> get(ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		return dao.getAll();
	}
	
	@Override
	public IActivity get(String userId, String appId, String productId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		List<? extends IActivity> activities = dao.getByProduct(appId, productId);
		for(IActivity activity : activities) {
			if(activity.getUserId().equals(userId))
				return activity;
		}
		return null;
	}
	
	@Override
	public List<? extends IActivity> get(String userId, String appId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		return dao.getByUserApplication(userId, appId);
	}
	
	@Override
	public List<? extends IActivity> get(String userId, ActionType type) {
		IGenericActivityDao<? extends IActivity> dao = getConcreteDao(type);
		return dao.getByUser(userId);
	}
}
