package com.tjekuaitong.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.tjekuaitong.dao.AddressDao;
import com.tjekuaitong.dao.UserDao;
import com.tjekuaitong.entity.Address;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {

	@Resource
	private AddressDao addressDao;
	@Resource
	private UserDao userDao;
	@Override
	public int insert(Address address) throws Exception {
		User user =new User();
		int i =0;
		if(!"".equals(address.getUserid())&&address.getUserid()!=null) {
			user.setUserid(address.getUserid());
			user =userDao.searchOne(user);
			address.setOpenid(user.getOpenid());
			i =addressDao.insert(address);
		}
		return i;
	}

	@Override
	public List<Address> selectList(Address address) throws Exception {
		// TODO Auto-generated method stub
		return addressDao.searchList(address);
	}

	@Override
	public int update(Address address) throws Exception {
		// TODO Auto-generated method stub
		return addressDao.update(address);
	}

}
