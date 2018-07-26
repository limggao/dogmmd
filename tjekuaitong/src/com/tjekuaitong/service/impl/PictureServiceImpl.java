package com.tjekuaitong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.PictureDao;
import com.tjekuaitong.entity.Picture;
import com.tjekuaitong.service.PictureService;
@Service
public class PictureServiceImpl implements PictureService {

	@Resource
	private PictureDao pictureDao;
	
	public List<Picture> selectList(Picture picture) throws Exception{
		List<Picture> picList =pictureDao.searchList(picture);
		
		return  picList;
	}
}
