package com.amundi.social.common.model;

import org.joda.time.DateTime;

public abstract class AbstractAction implements IAction {

	private String appId;
	private String productId;
	private String userId;
	private DateTime timestamp;
	
	public AbstractAction() {
		
	}
	
	public AbstractAction(String appId, String productId, String userId) {
		this.appId = appId;
		this.productId = productId;
		this.userId = userId;
		this.timestamp = DateTime.now();
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
