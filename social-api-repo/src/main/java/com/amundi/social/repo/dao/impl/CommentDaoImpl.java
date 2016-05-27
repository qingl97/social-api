package com.amundi.social.repo.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.amundi.social.common.model.Comment;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.ICommentDao;
import com.amundi.social.repo.dao.mappers.CommentMapper;

public class CommentDaoImpl extends AbstractActivityDao<Comment> implements ICommentDao {
	
	private static final Logger LOGGER = Logger.getLogger(CommentDaoImpl.class);

	public CommentDaoImpl() {
		super(CommentMapper.class);
	}
	
	@Override
	public void add(Comment cmt) {
		SqlSession session = null;
		try {
			session = SqlSessionProvider.openSession();
			session.getMapper(CommentMapper.class).addActivity(cmt);
			session.commit();
			session.getMapper(CommentMapper.class).addNoteContent(cmt);
			session.commit();
		} catch(Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			session.getMapper(CommentMapper.class).delete(cmt);
		} finally {
			session.close();
		}
	}
}
