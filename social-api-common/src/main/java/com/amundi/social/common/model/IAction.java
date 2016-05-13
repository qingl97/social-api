package com.amundi.social.common.model;

import org.joda.time.DateTime;

public interface IAction {
	
	enum ActionType {
		LIKE, FOLLOW, FAVORITE, COMMENT
	}

	ActionType getType();
	IEntity getTarget();
	String getUserId();
	DateTime getTimestamp();
}
