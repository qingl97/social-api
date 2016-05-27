package com.amundi.social.common.model;

import org.joda.time.DateTime;

public abstract class AbstractAction implements IActivity {

	private int id;
	private String appId;
	private String productId;
	private String userId;
	private DateTime timestamp;
	
	@Override
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public DateTime getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(DateTime ts) {
		this.timestamp = ts;
	}
}
