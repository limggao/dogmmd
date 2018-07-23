package com.tjekuaitong.dao;

import java.util.List;
import java.util.Map;

import com.tjekuaitong.entity.Link;
import com.tjekuaitong.entity.User;

public interface UserDao {

	public List<User> getLimitUser(int page,int pageSize);

	public Integer countUser();
	
	//修改个人信息
	int update(User user);
	
}
