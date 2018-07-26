package com.tjekuaitong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.ProductTypeDao;
import com.tjekuaitong.entity.ProductType;
import com.tjekuaitong.service.ProductTypeService;
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Resource
	private ProductTypeDao ductTypeDao;
	@Override
	public List<ProductType> selectList(ProductType productType) throws Exception {
		// TODO Auto-generated method stub
		return ductTypeDao.searchList(productType);
	}

}
