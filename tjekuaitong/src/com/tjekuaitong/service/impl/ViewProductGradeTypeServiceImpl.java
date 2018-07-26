package com.tjekuaitong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.ViewProductGradeTypeDao;
import com.tjekuaitong.entity.ViewProductGradeType;
import com.tjekuaitong.service.ViewProductGradeTypeService;
@Service
public class ViewProductGradeTypeServiceImpl implements ViewProductGradeTypeService {

	@Resource
	private ViewProductGradeTypeDao ductGradeDao;
	@Override
	public List<ViewProductGradeType> selectList(ViewProductGradeType gradeType) throws Exception {
		
		List<ViewProductGradeType> ductGradeList=ductGradeDao.searchList(gradeType);
		
		return ductGradeList;
	}

}
