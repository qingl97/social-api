package com.amundi.social.common.model;

public enum ActivityType {
	LIKE(1), FOLLOW(2), FAVORITE(3), COMMENT(4);
	
	private int val;
	
	ActivityType(int val) {this.val = val;}
	
	public static ActivityType fromString(String val) {
		if(val != null) {
			for(ActivityType type : ActivityType.values())
				if(val.equalsIgnoreCase(type.name()))
					return type;
		}
		return null;
	}
	
	public static ActivityType fromInt(int val) {
		for(ActivityType type : ActivityType.values())
			if(val == type.val)
				return type;
		return null;
	}
}