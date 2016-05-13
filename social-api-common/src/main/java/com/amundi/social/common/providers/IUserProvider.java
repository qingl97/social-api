package com.amundi.social.common.providers;

import java.util.List;

import com.amundi.social.common.model.Comment;
import com.amundi.social.common.model.Favorite;
import com.amundi.social.common.model.Follow;
import com.amundi.social.common.model.Like;

public interface IUserProvider {

	String getUserId();
	List<Like> getLikes();
	List<Favorite> getFavorites();
	List<Follow> getFollows();
	List<Comment> getComments();
}
