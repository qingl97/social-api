package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;

public interface IUserActivityProvider {
	
	void add(String userId, String appId, String productId, ActionType type);
	void remove(String userId, String appId, String productId, ActionType type);
	
	List<? extends IActivity> get(ActionType type);
	IActivity get(String userId, String appId, String productId, ActionType type);
	List<? extends IActivity> get(String userId, String appId, ActionType type);
	List<? extends IActivity> get(String userId, ActionType type);
}
