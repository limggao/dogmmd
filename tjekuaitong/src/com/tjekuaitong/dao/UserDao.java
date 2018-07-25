package com.tjekuaitong.dao;

import java.util.List;
import java.util.Map;

import com.tjekuaitong.base.IBaseDao;
import com.tjekuaitong.entity.User;

public interface UserDao extends IBaseDao<User>{
	
	int inserts(User user);
	
	//修改个人信息
	
}
