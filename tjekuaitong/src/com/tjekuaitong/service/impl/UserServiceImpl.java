package com.tjekuaitong.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.UserDao;
import com.tjekuaitong.entity.Link;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	
	@Resource 
	private UserDao UserDao;
	
	
	
	@Override
	public List<User> getLimitUser(int page,
			int pageSize) {
		// TODO Auto-generated method stub
		return UserDao.getLimitUser(page, pageSize);
	}



	@Override
	public Integer countUser() {
		// TODO Auto-generated method stub
		return UserDao.countUser();
	}







	@Override
	public int update(User user) {
	int i;
	i =UserDao.update(user);
	return i;
	}







	
	
}
