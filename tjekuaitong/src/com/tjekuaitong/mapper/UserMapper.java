package com.tjekuaitong.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tjekuaitong.entity.Link;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.entity.Users;

public interface UserMapper {

	//插入用户信息
		public boolean insert(User user) ;
		
		Users select(String userName);
		
		public List<User> getLimitUser(@Param("page")int page,@Param("pageSize")int pageSize);

		public Integer countUser();
		
		
		int update(User user);
}
