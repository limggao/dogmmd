package com.tjekuaitong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.ProductDao;
import com.tjekuaitong.entity.Product;
import com.tjekuaitong.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao ductDao;
	@Override
	public List<Product> selectList(Product product) throws Exception {
		// TODO Auto-generated method stub
		return ductDao.searchList(product);
	}

}
