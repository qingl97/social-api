package com.amundi.social.repo.dao.mappers;

import com.amundi.social.common.model.Comment;

public interface CommentMapper extends CommonActivityMapper<Comment> {

	int addNoteContent(Comment fav);
	void delete(int commentId);
	int getActivityId(int commentId);
}
