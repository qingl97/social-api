package com.amundi.social.repo.dao.impl;

import com.amundi.social.common.model.Favorite;
import com.amundi.social.repo.dao.mappers.FavoriteMapper;

public class FavoriteDaoImpl extends AbstractActivityDao<Favorite> {

	public FavoriteDaoImpl() {
		super(FavoriteMapper.class);
	}
}
