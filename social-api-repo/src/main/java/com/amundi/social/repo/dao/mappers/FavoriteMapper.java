package com.amundi.social.repo.dao.mappers;

import com.amundi.social.common.model.Favorite;

public interface FavoriteMapper extends GenericActivityMapper<Favorite> {

	void add(Favorite fav);
}
