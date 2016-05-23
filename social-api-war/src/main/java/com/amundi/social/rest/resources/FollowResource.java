package com.amundi.social.rest.resources;

import javax.ws.rs.Path;

import com.amundi.social.common.model.IActivity.ActionType;

@Path("follow")
public class FollowResource extends AbstractCommonResource {
	
	public FollowResource() {
		super(ActionType.FOLLOW);
	}
}