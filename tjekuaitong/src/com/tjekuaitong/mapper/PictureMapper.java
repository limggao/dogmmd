package com.tjekuaitong.mapper;

import java.util.List;

import com.tjekuaitong.entity.Picture;

public interface PictureMapper {

	public boolean insert(Picture picture) ;
	List<Picture> selectlist(String picture_id);
	int update(Integer id); 
}
