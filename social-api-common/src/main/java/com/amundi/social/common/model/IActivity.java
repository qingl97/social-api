package com.amundi.social.common.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface IActivity {
	
	enum ActionType {
		LIKE(1), FOLLOW(2), FAVORITE(3), COMMENT(4);
		
		private int val;
		
		ActionType(int val) {this.val = val;}
		
		public static ActionType fromString(String val) {
			if(val != null) {
				for(ActionType type : ActionType.values())
					if(val.equalsIgnoreCase(type.name()))
						return type;
			}
			return null;
		}
		
		public static ActionType fromInt(int val) {
			for(ActionType type : ActionType.values())
				if(val == type.val)
					return type;
			return null;
		}
	}

	@JsonIgnore
	int getId();
	@JsonIgnore
	ActionType getType();
	@JsonProperty("app_id")
	String getAppId();
	@JsonProperty("product_id")
	String getProductId();
	@JsonProperty("user_id")
	String getUserId();
	@JsonProperty("ts")
	DateTime getTimestamp();
}
