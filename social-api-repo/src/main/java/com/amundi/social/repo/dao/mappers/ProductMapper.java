package com.amundi.social.repo.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amundi.social.common.model.IProduct;

public interface ProductMapper {

	IProduct getByProduct(@Param("appId") String appId, @Param("productId") String productId);
	List<IProduct> getByApplication(@Param("appId") String appId);
	List<IProduct> getAll();
	List<IProduct> getAllByType(@Param("type") int type);
}
