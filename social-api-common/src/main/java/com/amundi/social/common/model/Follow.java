package com.amundi.social.common.model;

public class Follow extends AbstractAction {

	public Follow(IEntity target, String userId) {
		super(target, userId);
	}

	@Override
	public ActionType getType() {
		return ActionType.FOLLOW;
	}

}
