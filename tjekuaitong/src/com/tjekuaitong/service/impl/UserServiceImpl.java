package com.tjekuaitong.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.UserDao;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	
	@Resource 
	private UserDao UserDao;


	
	
}
