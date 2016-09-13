package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.IActivity;

public interface IActivityProvider {
	
	void addActivity(IActivity activity);
	
	void removeActivity(IActivity activity);
	void removeActivity(int activityId);
	
	List<? extends IActivity> getAll();
	List<? extends IActivity> getByUser(String userId);
	List<? extends IActivity> getByUserApp(String userId, String appId);
	List<? extends IActivity> getByApp(String appId);
	List<? extends IActivity> getByAppProduct(String appId, String productId);
}
