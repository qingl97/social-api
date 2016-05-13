package com.amundi.social.common.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractAction implements IAction {

	private IEntity target;
	@JsonProperty("userId")
	private String userId;
	@JsonProperty("timestamp")
	private DateTime ts;
	
	public AbstractAction(IEntity target, String userId) {
		this.target = target;
		this.userId = userId;
		this.ts = DateTime.now();
	}
	
	@Override
	public IEntity getTarget() {
		return target;
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
