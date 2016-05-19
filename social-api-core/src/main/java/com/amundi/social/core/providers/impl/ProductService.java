package com.amundi.social.core.providers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amundi.social.common.model.AbstractAction;
import com.amundi.social.common.model.IAction.ActionType;
import com.amundi.social.common.model.IProduct;
import com.amundi.social.common.providers.IProductProvider;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.IProductDao;
import com.amundi.social.repo.dao.impl.LikeDaoImpl;
import com.amundi.social.repo.dao.impl.ProductDaoImpl;

public class ProductService implements IProductProvider {
	
	private IProductDao productDao = new ProductDaoImpl();
	private ILikeDao likeDao = new LikeDaoImpl();

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
	public Map<ActionType, List<? extends AbstractAction>> getSocialStatus(String appId, String productId) {
		Map<ActionType, List<? extends AbstractAction>> status = new HashMap<>();
		for(ActionType type : ActionType.values()) {
			status.put(type, getSocialStatus(appId, productId, type));
		}
		return status;
	}

	@Override
	public List<? extends AbstractAction> getSocialStatus(String appId, String productId, ActionType type) {
		switch(type) {
			case LIKE:
				return likeDao.getByProduct(appId, productId);
			case FAVORITE:
				
			case FOLLOW:
				
			case COMMENT:
			
			default:
				throw new IllegalArgumentException("no action type matched");
		}
	}

}
