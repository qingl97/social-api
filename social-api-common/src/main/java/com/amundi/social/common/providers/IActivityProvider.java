package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;

public interface IActivityProvider {
	
	/**
	 * 
	 * @param activity
	 */
	void add(IActivity activity);
	
	/**
	 * Remove an activity.
	 * 
	 * @param userId
	 * @param appId
	 * @param productId
	 * @param type
	 */
	void remove(IActivity activity);
	
	/**
	 * Get all activities. 
	 * 
	 * @return
	 */
	List<? extends IActivity> getAll();
	
	/**
	 * Get all activities for that type.
	 * 
	 * @param type
	 * @return
	 */
	List<? extends IActivity> getAll(ActionType type);
	
	/**
	 * Get activities that are produced by a certain user on a product.
	 * 
	 * @param userId
	 * @param appId
	 * @param productId
	 * @return
	 */
	List<? extends IActivity> getByUser(String userId, String appId, String productId);
	IActivity getByUser(String userId, String appId, String productId, ActionType type);
	
	List<? extends IActivity> getByUser(String userId);
	List<? extends IActivity> getByUser(String userId, ActionType type);
	
	List<? extends IActivity> getByUser(String userId, String appId);
	List<? extends IActivity> getByUser(String userId, String appId, ActionType type);
	
	List<? extends IActivity> get(String appId);
	List<? extends IActivity> get(String appId, ActionType type);

	List<? extends IActivity> get(String appId, String productId);
	List<? extends IActivity> get(String appId, String productId, ActionType type);
}
