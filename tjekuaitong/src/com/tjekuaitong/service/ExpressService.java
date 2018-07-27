package com.tjekuaitong.service;

import java.util.List;

import com.tjekuaitong.entity.Express;

public interface ExpressService {

	List<Express> selectList(Express express) throws Exception;
}
