package com.tjekuaitong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.entity.ProductGrade;
import com.tjekuaitong.entity.ProductGradeDao;
import com.tjekuaitong.service.ProductGradeService;
@Service
public class ProductGradeServiceImpl implements ProductGradeService {

	@Resource
	private ProductGradeDao ductGradeDao;
	@Override
	public List<ProductGrade> selectList(ProductGrade productGrade) throws Exception {
		
		return ductGradeDao.searchList(productGrade);
	}

}
