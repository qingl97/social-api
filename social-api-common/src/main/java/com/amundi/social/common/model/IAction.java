package com.amundi.social.common.model;

import org.joda.time.DateTime;

public interface IAction {
	
	enum ActionType {
		LIKE, FOLLOW, FAVORITE, COMMENT
	}

	ActionType getType();
	String getAppId();
	String getProductId();
	String getUserId();
	DateTime getTimestamp();
}
