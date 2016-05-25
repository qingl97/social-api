package com.amundi.social.core.providers.impl;

import java.util.List;

import com.amundi.social.common.model.IProduct;
import com.amundi.social.common.providers.IProductProvider;
import com.amundi.social.repo.dao.IProductDao;
import com.amundi.social.repo.dao.impl.ProductDaoImpl;

public class ProductService extends AbstractActivityService implements IProductProvider {
	
	private IProductDao productDao = new ProductDaoImpl();

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
}
