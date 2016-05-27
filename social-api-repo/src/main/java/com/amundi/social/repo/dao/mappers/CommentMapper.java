package com.amundi.social.repo.dao.mappers;

import com.amundi.social.common.model.Comment;

public interface CommentMapper extends GenericActivityMapper<Comment> {

	int addActivity(Comment fav);
	int addNoteContent(Comment fav);
}
