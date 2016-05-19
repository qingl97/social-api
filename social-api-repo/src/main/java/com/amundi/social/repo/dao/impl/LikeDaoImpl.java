package com.amundi.social.repo.dao.impl;

import com.amundi.social.common.model.Like;
import com.amundi.social.repo.dao.ILikeDao;
import com.amundi.social.repo.dao.mappers.LikeMapper;

public class LikeDaoImpl extends AbstractActivityDao<Like> implements ILikeDao {
	
	public LikeDaoImpl() {
		super(LikeMapper.class);
	}
}
