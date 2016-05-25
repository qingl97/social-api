package com.amundi.social.common.model;

import com.amundi.social.common.model.IActivity.ActionType;

public class ProductActivityCount implements IProductCount {
	
	private String appId;
	private String productId;
	private ActionType type;
	private int count;
	
//	public ProductActivityCount() {
//		
//	}
//	
//	public ProductActivityCount(String appId, String productId, int count, ActionType type) {
//		this.id = IdentityBuilder.build(appId, productId);
//		this.appId = appId;
//		this.productId = productId;
//		this.count = count;
//		this.type = type;
//	}
	
	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String getAppId() {
		return appId;
	}

	@Override
	public String getProductId() {
		return productId;
	}

	@Override
	public String getId() {
		return IdentityBuilder.build(appId, productId);
	}

	@Override
	public String getType() {
		return type.name();
	}

	@Override
	public int getCount() {
		return count;
	}

}
