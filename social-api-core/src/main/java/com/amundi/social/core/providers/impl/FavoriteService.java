package com.amundi.social.core.providers.impl;

import com.amundi.social.common.model.Favorite;
import com.amundi.social.repo.dao.IFavoriteDao;

/**
 * Created by liang on 07/09/2016.
 */
public class FavoriteService extends AbstractActivityService<Favorite> {
	
	public FavoriteService(IFavoriteDao dao) {
		super(dao);
	}
}
