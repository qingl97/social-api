package com.amundi.social.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public interface IActivity {
	
	@JsonIgnore
	int getId();
	@JsonIgnore
	ActivityType getType();
	@JsonProperty("app_id")
	String getAppId();
	@JsonProperty("product_id")
	String getProductId();
	@JsonProperty("user_id")
	String getUserId();
	@JsonProperty("ts")
	Date getTimestamp();
}
