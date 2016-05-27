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
			// To insert a comment in database, first insert a record in table 'activities'; then 
			// insert a record in table 'comments'. Since the id for the newly inserted activity 
			// for this comment is not yet generated until the transation commits, the second insert
			// will fail due to the foreign key constraint (on delete cascade, on update cascade) 
			// that 'comments' have a foreign key 'activity_id' which references the column 'id' 
			// in 'activities'.
			// Here we make the insertion of comment to happen in two transations and the new activity 
			// will be deleted once there is an exception thrown. 
			LOGGER.error(e.getMessage(), e);
			if(session == null)
				session = SqlSessionProvider.openSession();
			session.getMapper(CommentMapper.class).delete(cmt);
		} finally {
			session.close();
		}
	}
}
