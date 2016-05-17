package com.amundi.social.repo.dao;

import java.util.List;

import com.amundi.social.common.model.IProduct;

public interface IProductDao {

	List<IProduct> get(String appId);
	IProduct get(String appId, String productId);
}
