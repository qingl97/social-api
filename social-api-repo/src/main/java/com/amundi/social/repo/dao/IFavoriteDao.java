package com.amundi.social.repo.dao;

import com.amundi.social.common.model.Favorite;

public interface IFavoriteDao extends IGenericActivityDao<Favorite> {

	void add(Favorite fav);
}
