package com.amundi.social.repo.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.Favorite;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.IFavoriteDao;
import com.amundi.social.repo.dao.mappers.FavoriteMapper;

public class FavoriteDaoImpl extends AbstractActivityDao<Favorite> implements IFavoriteDao {

	public FavoriteDaoImpl() {
		super(FavoriteMapper.class);
	}
	
	@Override
	public void add(Favorite fav) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			session.getMapper(FavoriteMapper.class).add(fav);
			session.commit();
		}
	}
}
