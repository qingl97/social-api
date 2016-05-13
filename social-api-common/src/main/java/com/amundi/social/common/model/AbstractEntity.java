package com.amundi.social.common.model;

public abstract class AbstractEntity implements IEntity {
	
	public String getId() {
		return IdentityBuilder.build(getAppId(), getProductId());
	}
}
