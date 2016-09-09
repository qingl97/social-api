package com.amundi.social.repo.dao;

import com.amundi.social.common.model.IActivity;

import java.util.List;

/**
 * Created by liang on 07/09/2016.
 */
public interface IActivityDao<T extends IActivity> {
	
    List<T> getActivities();
    List<T> getActivitiesByUserApp(String userId, String appId);
    List<T> getActivitiesByUser(String userId);
    List<T> getActivitiesByApp(String appId);
    int addActivity(IActivity activity);
    void removeActivity(int activityId);
    void removeActivity(IActivity activity);
	List<T> getActivitiesByAppProduct(String appId, String productId);
}
