package com.amundi.social.repo.dao.mappers;

import com.amundi.social.common.model.Like;

public interface LikeMapper extends GenericActivityMapper<Like> {

	int add(Like like);
}
