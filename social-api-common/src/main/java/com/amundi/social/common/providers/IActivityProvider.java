package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.IAction;
import com.amundi.social.common.model.IAction.ActionType;

public interface IActivityProvider {
	
	void doAction(String userId, String appId, String productId, ActionType type);
	void undoAction(String userId, String appId, String productId, ActionType type);
	
	List<? extends IAction> get(ActionType type);
	IAction get(String userId, String appId, String productId, ActionType type);
	List<? extends IAction> get(String userId, String appId, ActionType type);
	List<? extends IAction> get(String userId, ActionType type);
}
