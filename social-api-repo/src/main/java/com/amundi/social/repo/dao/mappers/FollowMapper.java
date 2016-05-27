package com.amundi.social.repo.dao.mappers;

import com.amundi.social.common.model.Follow;

public interface FollowMapper extends GenericActivityMapper<Follow> {
	void add(Follow follow);
}
