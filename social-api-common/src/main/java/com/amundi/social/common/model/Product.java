package com.amundi.social.common.model;

import java.math.BigDecimal;

/**
 * The entity that a social action is operated on.
 * 
 * @author liang
 *
 */
public class Product implements IProduct {
	
	private String id;
	private String appId;
	private String productId;
	private int nbLikes;
	private int nbFavorites;
	private int nbFollows;

	public Product(String appId, String productId) {
		this.appId = appId;
		this.productId = productId;
		this.id = IdentityBuilder.build(appId, productId);
	}
	
	public Product(String appId, String productId, int nbLikes, int nbFavorites, int nbFollows) {
		this(appId, productId);
		this.nbLikes = nbLikes;
		this.nbFavorites = nbFavorites;
		this.nbFollows = nbFollows;
	}
	
	public Product(String appId, String productId, BigDecimal nbLikes, BigDecimal nbFavorites, BigDecimal nbFollows) {
		this(appId, productId);
		this.nbLikes = nbLikes.intValue();
		this.nbFavorites = nbFavorites.intValue();
		this.nbFollows = nbFollows.intValue();
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public String getAppId() {
		return this.appId;
	}
	
	@Override
	public String getProductId() {
		return this.productId;
	}

	public int getNbLikes() {
		return nbLikes;
	}

	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}

	public int getNbFavorites() {
		return nbFavorites;
	}

	public void setNbFavorites(int nbFavorites) {
		this.nbFavorites = nbFavorites;
	}

	public int getNbFollows() {
		return nbFollows;
	}

	public void setNbFollows(int nbFollows) {
		this.nbFollows = nbFollows;
	}

}
