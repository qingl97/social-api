package com.amundi.social.rest.resources;

import javax.ws.rs.Path;

import com.amundi.social.common.model.IActivity.ActionType;

@Path("favorite")
public class FavoriteResource extends AbstractCommonResource {

	public FavoriteResource() {
		super(ActionType.FAVORITE);
	}

}
