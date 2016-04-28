package com.amundi.social.model;

import org.joda.time.DateTime;

public abstract class AbstractAction implements IAction {
	
	private String productId;
	private String appId;
	private String userId;
	private DateTime ts;
	
	@Override
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Override
	public String getAppId() {
		return appId;
	}
	
	public void setAppId(String appId) {
		this.appId = appId;
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
		return ts;
	}
	
	public void setTimestamp(DateTime ts) {
		this.ts = ts;
	}
}
