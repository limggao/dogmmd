package com.tjekuaitong.service;

import java.util.List;

import com.tjekuaitong.entity.ViewProductGradeType;

public interface ViewProductGradeTypeService {

	List<ViewProductGradeType> selectList(ViewProductGradeType gradeType) throws Exception;
}
