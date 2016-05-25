package com.amundi.social.common.model;

import com.amundi.social.common.model.IActivity.ActionType;

public interface IProduct {

	String getAppId();
	String getProductId();
	String getId();
	int getNbLikes();
	int getNbFavorites();
	int getNbFollows();
	int getNbComments();
	IProductCount transferToCount(ActionType type);
}
