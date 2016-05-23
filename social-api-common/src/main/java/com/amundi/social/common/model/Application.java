package com.amundi.social.common.model;

import org.joda.time.DateTime;

public class Application {

	private String id;
	private String creatorId;
	private String description;
	private DateTime timeCreated;
	
	public Application() {
		
	}
	
	public Application(String id, String creatorId, String desc, DateTime timeCreated) {
		this.id = id;
		this.creatorId = creatorId;
		this.description = desc;
		this.timeCreated = timeCreated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(DateTime timeCreated) {
		this.timeCreated = timeCreated;
	}

}
