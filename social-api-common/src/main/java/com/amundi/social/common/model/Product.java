package com.amundi.social.common.model;

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

//	@Override
//	public IProductCount transferToCount(ActionType type) {
//		ProductActivityCount prdCount = new ProductActivityCount();
//		prdCount.setAppId(appId);
//		prdCount.setProductId(productId);
//		prdCount.setType(type);
//		if(type == ActionType.COMMENT)
//			prdCount.setCount(nbComments);
//		if(type == ActionType.LIKE)
//			prdCount.setCount(nbLikes);
//		if(type == ActionType.FAVORITE)
//			prdCount.setCount(nbFavorites);
//		if(type == ActionType.FOLLOW)
//			prdCount.setCount(nbFollows);
//		return prdCount;
//	}

}
