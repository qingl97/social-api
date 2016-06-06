package com.amundi.social.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The entity that a social action is operated on.
 * 
 * @author liang
 *
 */
public class Product implements IProduct {
	
	@JsonIgnore
	private String id;
	@JsonProperty("app_id")
	private String appId;
	@JsonProperty("product_id")
	private String productId;
	@JsonProperty("count_likes")
	private int nbLikes;
	@JsonProperty("count_favorites")
	private int nbFavorites;
	@JsonProperty("count_follows")
	private int nbFollows;
	@JsonProperty("count_comments")
	private int nbComments;
	@JsonProperty("note")
	private double score;
	
	@Override
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
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
