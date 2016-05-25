package com.amundi.social.rest.resources;

import javax.ws.rs.Path;

import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.rest.resources.impl.AbstractCommonResource;

@Path("like")
public class LikeResource extends AbstractCommonResource {

	public LikeResource() {
		super(ActionType.LIKE);
	}

}
