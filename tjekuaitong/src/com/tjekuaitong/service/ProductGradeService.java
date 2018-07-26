package com.tjekuaitong.service;

import java.util.List;

import com.tjekuaitong.entity.ProductGrade;

public interface ProductGradeService {

	List<ProductGrade> selectList(ProductGrade productGrade) throws Exception;
}
