package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.IProduct;

public interface IProductProvider {

	List<IProduct> getAll();
	List<IProduct> get(String appId);
	IProduct get(String appId, String productId);
}
