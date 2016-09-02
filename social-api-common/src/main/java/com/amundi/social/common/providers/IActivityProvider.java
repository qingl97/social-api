package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;

public interface IActivityProvider {
	
	void add(IActivity activity);
	
	void remove(IActivity activity);
	
	List<? extends IActivity> getAll();
	List<? extends IActivity> getAll(ActionType type);
	
	IActivity getByUser(String userId, String appId, String productId, ActionType type);
	
	List<? extends IActivity> getByUser(String userId, ActionType type);
	
	List<? extends IActivity> getByUser(String userId, String appId, ActionType type);
	
	List<? extends IActivity> get(String appId);
	List<? extends IActivity> get(String appId, ActionType type);

	List<? extends IActivity> get(String appId, String productId);
	List<? extends IActivity> get(String appId, String productId, ActionType type);
}
