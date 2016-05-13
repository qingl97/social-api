package com.amundi.social.common.model;

public class IdentityBuilder {

	public static String build(String appId, String productId) {
		return new StringBuilder().append(appId).append("-").append(productId).toString();
	}

}
