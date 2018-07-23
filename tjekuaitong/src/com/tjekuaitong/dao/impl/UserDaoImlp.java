package com.tjekuaitong.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tjekuaitong.base.BaseDaoImpl;
import com.tjekuaitong.dao.UserDao;
import com.tjekuaitong.entity.Link;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.mapper.UserMapper;

@Repository
public class UserDaoImlp extends BaseDaoImpl<User> implements UserDao{

	@Override
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
	public int update(User user){
		int i ;
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		i=mapper.update(user);
		return 0;
	}


	
}
