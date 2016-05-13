package com.amundi.social.common.model;

public class Like extends AbstractAction {

	public Like(IEntity target, String userId) {
		super(target, userId);
	}

	public ActionType getType() {
		return ActionType.LIKE;
	}
}
