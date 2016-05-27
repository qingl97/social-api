package com.amundi.social.repo.dao.mappers;

import com.amundi.social.common.model.Comment;

public interface CommentMapper extends GenericActivityMapper<Comment> {

	void addActivity(Comment fav);
	void addNoteContent(Comment fav);
}
