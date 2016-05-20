package com.amundi.social.common.model;

public class Favorite extends AbstractAction {
	
	public Favorite() {
		super();
	}

	public Favorite(String appId, String productId, String userId) {
		super(appId, productId, userId);
	}

	@Override
	public ActionType getType() {
		return ActionType.FAVORITE;
	}

}
