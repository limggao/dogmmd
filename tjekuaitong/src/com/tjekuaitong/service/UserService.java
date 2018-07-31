package com.tjekuaitong.service;

import java.util.List;
import java.util.Map;

import com.tjekuaitong.entity.User;

public interface UserService {

	public List<User> selectList(User user) throws Exception;
	public User selectOne(User user) throws Exception;
	public int insert(User user) throws Exception;
}
