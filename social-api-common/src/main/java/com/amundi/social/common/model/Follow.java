package com.amundi.social.common.model;

public class Follow extends AbstractAction {
	
//	public Follow() {
//		super();
//	}
//
//	public Follow(String appId, String productId, String userId) {
//		super(appId, productId, userId);
//	}

	@Override
	public ActionType getType() {
		return ActionType.FOLLOW;
	}

}
