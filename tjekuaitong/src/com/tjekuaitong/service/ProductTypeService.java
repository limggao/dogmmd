package com.tjekuaitong.service;

import java.util.List;

import com.tjekuaitong.entity.ProductType;

public interface ProductTypeService {

	List<ProductType> selectList(ProductType productType) throws Exception;
}

