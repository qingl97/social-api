package com.amundi.social.repo.dao.impl;

import com.amundi.social.common.model.Follow;
import com.amundi.social.repo.dao.IFollowDao;
import com.amundi.social.repo.dao.mappers.FollowMapper;

public class FollowDaoImpl extends AbstractActivityDao<Follow> implements IFollowDao {

	public FollowDaoImpl() {
		super(FollowMapper.class);
	}
}
