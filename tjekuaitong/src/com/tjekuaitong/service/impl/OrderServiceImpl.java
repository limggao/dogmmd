package com.tjekuaitong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.OrderDao;
import com.tjekuaitong.entity.Order;
import com.tjekuaitong.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;
	
	@Override
	public int insert(Order order) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.insert(order);
	}

	@Override
	public List<Order> selectList(Order order)throws Exception {
		// TODO Auto-generated method stub
		return orderDao.searchList(order);
	}

	@Override
	public int update(Order order)throws Exception {
		// TODO Auto-generated method stub
		return orderDao.update(order);
	}

}
