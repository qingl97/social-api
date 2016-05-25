package com.amundi.social.common.model;

import org.joda.time.DateTime;

public class GenericActivity implements IActivity {
	
	private int id;
	private String appId;
	private String productId;
	private String userId;
	private DateTime timestamp;
	private ActionType type;

	public GenericActivity() {
		// TODO Auto-generated constructor stub
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setTimestamp(DateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public ActionType getType() {
		return type;
	}

	@Override
	public String getAppId() {
		return appId;
	}

	@Override
	public String getProductId() {
		return productId;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public DateTime getTimestamp() {
		return timestamp;
	}

}
