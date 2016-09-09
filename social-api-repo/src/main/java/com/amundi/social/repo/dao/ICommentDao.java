package com.amundi.social.repo.dao;

import com.amundi.social.common.model.Comment;

public interface ICommentDao extends IActivityDao<Comment>{

	void addComment(Comment comment);
	void removeComment(int commentId);
}
