package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.Comment;
import com.amundi.social.common.model.Favorite;
import com.amundi.social.common.model.Follow;
import com.amundi.social.common.model.Like;

public interface IUserProvider {

	List<Like> getLikes();
	List<Favorite> getFavorites();
	List<Follow> getFollows();
	List<Comment> getComments();
	
	List<Like> getLikes(String userId);
	List<Favorite> getFavorites(String userId);
	List<Follow> getFollows(String userId);
	List<Comment> getComments(String userId);
	
	List<Like> getLikes(String userId, String appId);
	List<Favorite> getFavorites(String userId, String appId);
	List<Follow> getFollows(String userId, String appId);
	List<Comment> getComments(String userId, String appId);
	
	Like getLike(String userId, String appId, String productId);
	Favorite getFavorite(String userId, String appId, String productId);
	Follow getFollow(String userId, String appId, String productId);
	
	void doLike(String userId, String appId, String productId);
	void doFavorite(String userId, String appId, String productId);
	void doFollow(String userId, String appId, String productId);
	void comment(String userId, String appId, String productId, String content, int note);
	
	void undoLike(String userId, String appId, String productId);
	void undoFavorite(String userId, String appId, String productId);
	void undoFollow(String userId, String appId, String productId);
}
