package com.amundi.social.rest.resources;

import javax.ws.rs.Path;

import com.amundi.social.common.model.IAction.ActionType;

@Path("comment")
public class CommentResource extends AbstractCommonResource {

	public CommentResource() {
		super(ActionType.COMMENT);
	}

}
