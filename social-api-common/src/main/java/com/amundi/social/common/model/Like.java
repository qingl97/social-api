package com.amundi.social.common.model;

public class Like extends AbstractAction {
	
	public Like() {
		super();
	}

	public Like(String appId, String productId, String userId) {
		super(appId, productId, userId);
	}

	public ActionType getType() {
		return ActionType.LIKE;
	}
}
