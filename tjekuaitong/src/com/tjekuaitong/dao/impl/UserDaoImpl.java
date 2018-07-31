package com.tjekuaitong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tjekuaitong.base.BaseDaoImpl;
import com.tjekuaitong.dao.UserDao;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.mapper.UserMapper;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{


	
	
	/*@Override
	public List<User> getLimitUser(int page,
			int pageSize) {
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> limitUser = mapper.getLimitUser((page)*pageSize, pageSize);
		
		return limitUser;
	}

	@Override
	public Integer countUser() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Integer countUser = mapper.countUser();
		
		return countUser;
	}

	@Override
	public boolean inserts(User user) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.inserts(user);
	}

	@Override
	public int update(User user) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.updates(user);
	}
*/

	
	
}
