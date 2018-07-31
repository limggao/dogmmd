package com.tjekuaitong.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjekuaitong.dao.UserDao;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	
	@Resource 
	private UserDao UserDao;
	
	public List<User> selectList(User user) throws Exception {
		
		List<User> list =UserDao.searchList(user);
		
		return list;
	}
	
	public int insert(User user) throws Exception {
		return UserDao.insert(user);
	}

	@Override
	public User selectOne(User user) throws Exception {
		// TODO Auto-generated method stub
		return UserDao.searchOne(user);
	}

	
}
