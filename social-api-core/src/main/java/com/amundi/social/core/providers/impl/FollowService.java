package com.amundi.social.core.providers.impl;

import com.amundi.social.common.model.Follow;
import com.amundi.social.repo.dao.IFollowDao;

/**
 * Created by liang on 07/09/2016.
 */
public class FollowService extends AbstractActivityService<Follow> {
	
	public FollowService(IFollowDao dao) {
		super(dao);
	}
}
