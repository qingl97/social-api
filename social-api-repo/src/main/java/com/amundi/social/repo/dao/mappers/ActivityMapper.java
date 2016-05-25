package com.amundi.social.repo.dao.mappers;

import java.util.List;

import com.amundi.social.common.model.IActivity;

public interface ActivityMapper {
	
	List<IActivity> fetchAll();
	IActivity fetchByUserProduct(String userId, String appId, String productId);
	List<? extends IActivity> fetchByUserApplicaton(String userId, String appId);
	List<? extends IActivity> fetchByUser(String userId);
}
