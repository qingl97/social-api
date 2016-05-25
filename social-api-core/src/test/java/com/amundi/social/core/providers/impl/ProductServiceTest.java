package com.amundi.social.core.providers.impl;

import org.junit.Test;

import com.amundi.social.common.providers.IProductProvider;

public class ProductServiceTest {
	
	private IProductProvider productService = new ProductService();

	@Test
	public void testGetProductsByApplication() {
		String appId = "APP-1";
		productService.get(appId);
	}

	@Test
	public void testGetProduct() {
		String appId = "APP-1";
		String productId = "DGC-001";
		productService.get(appId, productId);
	}

}
