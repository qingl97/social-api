package com.amundi.social.common.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IActivity {
	
	public enum ActionType {
		LIKE(1), FOLLOW(2), FAVORITE(3), COMMENT(4);
		
		public int val;
		
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
//	@JsonIgnore
	ActionType getType();
	String getAppId();
	String getProductId();
	String getUserId();
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	DateTime getTimestamp();
}
