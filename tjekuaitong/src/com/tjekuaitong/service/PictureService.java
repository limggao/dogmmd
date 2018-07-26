package com.tjekuaitong.service;

import java.util.List;

import com.tjekuaitong.entity.Picture;

public interface PictureService {
	public List<Picture> selectList(Picture picture) throws Exception;
}
