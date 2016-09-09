package com.amundi.social.core.providers.impl;

import com.amundi.social.common.model.Comment;
import com.amundi.social.repo.dao.ICommentDao;

/**
 * Created by liang on 07/09/2016.
 */
public class CommentService extends AbstractActivityService<Comment> {
	
	public CommentService(ICommentDao dao) {
		super(dao);
	}
}
