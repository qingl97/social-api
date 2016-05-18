package com.amundi.social.common.providers;

import java.util.List;
import java.util.Map;

import com.amundi.social.common.model.AbstractAction;
import com.amundi.social.common.model.IAction.ActionType;
import com.amundi.social.common.model.IProduct;

public interface IProductProvider {

	List<IProduct> getAll();
	List<IProduct> get(String appId);
	IProduct get(String appId, String productId);
	Map<ActionType, List<? extends AbstractAction>> getSocialStatus(String appId, String productId);
	List<? extends AbstractAction> getSocialStatus(String appId, String productId, ActionType type);
}
