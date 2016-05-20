package com.amundi.social.common.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The entity that a social action is operated on.
 * 
 * @author liang
 *
 */
public class Product implements IProduct {
	
	@JsonIgnore
	private String id;
	private String appId;
	private String productId;
	private int nbLikes;
	private int nbFavorites;
	private int nbFollows;
	private int nbComments;

	public Product(String appId, String productId) {
		this.appId = appId;
		this.productId = productId;
		this.id = IdentityBuilder.build(appId, productId);
	}
	
	public Product(String appId, String productId, int nbLikes, int nbFavorites, int nbFollows, int nbComments) {
		this(appId, productId);
		this.nbLikes = nbLikes;
		this.nbFavorites = nbFavorites;
		this.nbFollows = nbFollows;
		this.nbComments = nbComments;
	}
	
	public Product(String appId, String productId, BigDecimal nbLikes, BigDecimal nbFavorites, BigDecimal nbFollows, BigDecimal nbComments) {
		this(appId, productId);
		this.nbLikes = nbLikes.intValue();
		this.nbFavorites = nbFavorites.intValue();
		this.nbFollows = nbFollows.intValue();
		this.nbComments = nbComments.intValue();
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

	@Override
	public int getNbLikes() {
		return nbLikes;
	}

	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}

	@Override
	public int getNbFavorites() {
		return nbFavorites;
	}

	public void setNbFavorites(int nbFavorites) {
		this.nbFavorites = nbFavorites;
	}

	@Override
	public int getNbFollows() {
		return nbFollows;
	}

	public void setNbFollows(int nbFollows) {
		this.nbFollows = nbFollows;
	}
	
	public void setNbComments(int nbComments) {
		this.nbComments = nbComments;
	}
	
	@Override
	public int getNbComments() {
		return nbComments;
	}

}
