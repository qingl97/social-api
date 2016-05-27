package com.amundi.social.repo.dao;

import com.amundi.social.common.model.Like;

public interface ILikeDao extends IGenericActivityDao<Like> {

	void add(Like like);
}
