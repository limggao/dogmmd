package com.tjekuaitong.dao;

import java.util.List;

import com.tjekuaitong.entity.Picture;

public interface PictureDao {

	public boolean insert(Picture picture) ;
	List<Picture> selectlist(String picture_id);
	int update(Integer id); 
}
