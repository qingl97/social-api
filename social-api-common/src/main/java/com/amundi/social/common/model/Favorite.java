package com.amundi.social.common.model;

public class Favorite extends AbstractAction {

	public Favorite(IEntity target, String userId) {
		super(target, userId);
	}

	@Override
	public ActionType getType() {
		return ActionType.FAVORITE;
	}

}
