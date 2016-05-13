package com.amundi.social.common.model;

/**
 * An entity is what a social action is operated on.
 * 
 * @author liang
 *
 */
public class Entity implements IEntity {
	
	private String id;
	private String appId;
	private String productId;

	public Entity(String appId, String productId) {
		this.appId = appId;
		this.productId = productId;
		this.id = IdentityBuilder.build(appId, productId);
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	public String getAppId() {
		return this.appId;
	}
	
	public String getProductId() {
		return this.productId;
	}

}
