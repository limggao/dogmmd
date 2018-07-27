package com.tjekuaitong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.ExpressDao;
import com.tjekuaitong.entity.Express;
import com.tjekuaitong.service.ExpressService;
@Service
public class ExpressServiceImpl implements ExpressService {

	@Resource
	private ExpressDao espressDao;
	@Override
	public List<Express> selectList(Express express) throws Exception {
		// TODO Auto-generated method stub
		return espressDao.searchList(express);
	}

}
