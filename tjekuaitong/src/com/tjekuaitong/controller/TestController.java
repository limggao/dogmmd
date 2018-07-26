package com.tjekuaitong.controller;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.tjekuaitong.dao.PictureDao;
import com.tjekuaitong.dao.ViewProductGradeTypeDao;
import com.tjekuaitong.entity.Picture;
import com.tjekuaitong.entity.ViewProductGradeType;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring.xml","classpath:config/spring-mvc.xml","classpath:config/spring-mybatis.xml"})
public class TestController {

	@Resource
	private PictureDao dao;
	@Resource
	private ViewProductGradeTypeDao typeDao;
	@Test
	public void ss() {
		ViewProductGradeType gradeType=new ViewProductGradeType();
		gradeType.setProduct_type(1);
		List<ViewProductGradeType> list=null;
		try {
			list = typeDao.searchList(gradeType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSON(list));
	}
}
