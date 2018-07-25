package com.tjekuaitong.controller;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.tjekuaitong.dao.PictureDao;
import com.tjekuaitong.entity.Picture;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring.xml","classpath:config/spring-mvc.xml","classpath:config/spring-mybatis.xml"})
public class TestController {

	@Resource
	private PictureDao dao;
	@Test
	public void ss() {
		Picture picture =new Picture();
		picture.setProduct_id("1");
		List<Picture> list=null;
		try {
			list = dao.searchList(picture);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSON(list));
	}
}
