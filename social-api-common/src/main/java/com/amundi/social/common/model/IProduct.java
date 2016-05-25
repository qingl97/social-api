package com.amundi.social.common.model;

public interface IProduct {

	String getAppId();
	String getProductId();
	String getId();
	int getNbLikes();
	int getNbFavorites();
	int getNbFollows();
	int getNbComments();
	double getScore();
//	IProductCount transferToCount(ActionType type);
}
