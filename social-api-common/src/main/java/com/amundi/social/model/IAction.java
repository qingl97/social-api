package com.amundi.social.model;

import org.joda.time.DateTime;

public interface IAction {
	
	enum Action {
		LIKE, FOLLOW, FAVORITE, COMMENT
	}

	Action getType();
	String getProductId();
	String getAppId();
	String getUserId();
	DateTime getTimestamp();
}
