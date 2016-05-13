package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.Like;

public interface ILikeProvider {
	
	/**
	 * User do a like on a product of an application.
	 * 
	 * @param userId
	 * @param appId
	 * @param productId
	 */
	void doLike(String userId, String appId, String productId);
	
	/**
	 * Get all likes.
	 * 
	 * @return
	 */
	List<Like> getLikes();
	
	/**
	 * Get likes an application earns.
	 * 
	 * @param appId
	 * @return
	 */
	List<Like> getLikes(String appId);
	
	/**
	 * Get likes a product within the application earns.
	 * 
	 * @param appId
	 * @param productId
	 * @return
	 */
	List<Like> getLikes(String appId, String productId);
	
	/**
	 * Get likes a user did. 
	 * 
	 * @param userId
	 * @return
	 */
	List<Like> getUserLikes(String userId);
	
	/**
	 * Check if the user liked the product.
	 * 
	 * @param appId
	 * @param productId
	 * @param userId
	 * @return
	 */
	boolean isLike(String appId, String productId, String userId);
}
