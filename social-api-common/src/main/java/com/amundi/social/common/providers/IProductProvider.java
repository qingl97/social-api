package com.amundi.social.common.providers;

import java.util.List;
import java.util.Map;

import com.amundi.social.common.model.IAction;
import com.amundi.social.common.model.IAction.ActionType;
import com.amundi.social.common.model.IProduct;

public interface IProductProvider {

	List<IProduct> getAll();
	List<IProduct> getAll(ActionType type);
	List<IProduct> get(String appId);
	IProduct get(String appId, String productId);
	Map<ActionType, List<? extends IAction>> getWithDetails(String appId, String productId);
	List<? extends IAction> getWithDetails(String appId, String productId, ActionType type);
	Map<ActionType, List<? extends IAction>> getWithDetails(String appId);
	List<? extends IAction> getWithDetails(String appId, ActionType type);
}
