package com.amundi.social.common.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IAction {
	
	public enum ActionType {
		LIKE, FOLLOW, FAVORITE, COMMENT
	}

	@JsonIgnore
	ActionType getType();
	String getAppId();
	String getProductId();
	String getUserId();
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	DateTime getTimestamp();
}
