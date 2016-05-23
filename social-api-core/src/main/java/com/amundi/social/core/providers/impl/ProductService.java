package com.amundi.social.core.providers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.common.model.IProduct;
import com.amundi.social.common.providers.IProductProvider;
import com.amundi.social.repo.dao.IProductDao;
import com.amundi.social.repo.dao.impl.ProductDaoImpl;

public class ProductService extends AbstractService implements IProductProvider {
	
	private IProductDao productDao = new ProductDaoImpl();
	
	@Override
	public List<IProduct> getAll(ActionType type) {
		return productDao.getAll(type);
	}

	@Override
	public List<IProduct> getAll() {
		return productDao.getAll();
	}

	@Override
	public List<IProduct> get(String appId) {
		return productDao.get(appId);
	}

	@Override
	public IProduct get(String appId, String productId) {
		return productDao.get(appId, productId);
	}
	
	@Override
	public Map<ActionType, List<? extends IActivity>> getWithDetails(String appId) {
		Map<ActionType, List<? extends IActivity>> actions = new HashMap<>();
		for(ActionType type : ActionType.values()) {
			actions.put(type, getWithDetails(appId, type));
		}
		return actions;
	}
	
	@Override
	public List<? extends IActivity> getWithDetails(String appId, ActionType type) {
		return getConcreteDao(type).getByApplication(appId);
	}

	@Override
	public Map<ActionType, List<? extends IActivity>> getWithDetails(String appId, String productId) {
		Map<ActionType, List<? extends IActivity>> status = new HashMap<>();
		for(ActionType type : ActionType.values()) {
			status.put(type, getWithDetails(appId, productId, type));
		}
		return status;
	}

	@Override
	public List<? extends IActivity> getWithDetails(String appId, String productId, ActionType type) {
		return getConcreteDao(type).getByProduct(appId, productId);
	}

}
