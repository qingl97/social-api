package com.amundi.social.repo.dao.impl;

import com.amundi.social.common.model.Comment;
import com.amundi.social.repo.dao.ICommentDao;
import com.amundi.social.repo.dao.mappers.CommentMapper;

public class CommentDaoImpl extends AbstractActivityDao<Comment> implements ICommentDao {

	public CommentDaoImpl() {
		super(CommentMapper.class);
	}
}
