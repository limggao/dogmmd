package com.tjekuaitong.service;

import java.util.List;

import com.tjekuaitong.entity.Order;

public interface OrderService {

	int insert(Order order) throws Exception;
	
	List<Order> selectList(Order order)throws Exception;
	
	int update(Order order)throws Exception;
}
