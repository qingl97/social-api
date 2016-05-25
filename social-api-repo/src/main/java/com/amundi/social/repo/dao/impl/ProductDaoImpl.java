package com.amundi.social.repo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.amundi.social.common.model.IProduct;
import com.amundi.social.repo.SqlSessionProvider;
import com.amundi.social.repo.dao.IProductDao;
import com.amundi.social.repo.dao.mappers.ProductMapper;

public class ProductDaoImpl implements IProductDao {
	
	@Override
	public List<IProduct> getAll() {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(ProductMapper.class).getAll();
		}
	}

	@Override
	public List<IProduct> get(String appId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(ProductMapper.class).getByApplication(appId);
		}
	}

	@Override
	public IProduct get(String appId, String productId) {
		try(SqlSession session = SqlSessionProvider.openSession()) {
			return session.getMapper(ProductMapper.class).getByProduct(appId, productId);
		}
	}
}
