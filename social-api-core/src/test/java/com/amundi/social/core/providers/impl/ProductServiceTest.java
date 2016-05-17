package com.amundi.social.core.providers.impl;

import org.junit.Test;

public class ProductServiceTest {
	
	private ProductService productService = new ProductService();

	@Test
	public void testGetProductsByApplication() {
		String appId = "DGC";
		productService.getProductsByApplication(appId);
	}

	@Test
	public void testGetProduct() {
		String appId = "DGC";
		String productId = "DGC-001";
		productService.getProduct(appId, productId);
	}

}
