package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.IProduct;

public interface IProductProvider {

	List<IProduct> getProductsByApplication(String appId);
	IProduct getProduct(String appId, String productId);
}
