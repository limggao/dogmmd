package com.tjekuaitong.service;

import java.util.List;

import com.tjekuaitong.entity.Product;

public interface ProductService {

	List<Product> selectList(Product product)throws Exception;
}
