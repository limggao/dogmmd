package com.tjekuaitong.service;

import java.util.List;

import com.tjekuaitong.entity.Address;

public interface AddressService {

	int insert(Address address) throws Exception;
	
	List<Address> selectList(Address address)throws Exception;
	
	int update(Address address)throws Exception;
}
