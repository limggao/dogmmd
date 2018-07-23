package com.tjekuaitong.service;

import java.util.List;
import java.util.Map;

import com.tjekuaitong.entity.Link;
import com.tjekuaitong.entity.User;

public interface UserService {

	
	public List<User> getLimitUser(int page,int pageSize);

	public Integer countUser();

	
	int update(User user);
	
}
