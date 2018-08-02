package com.tjekuaitong.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tjekuaitong.entity.Address;
import com.tjekuaitong.service.AddressService;
import com.tjekuaitong.uitls.CommonUtils;
import com.tjekuaitong.uitls.OutString;

@Controller
@RequestMapping("/addressController")
public class AddressController {
	Logger log = Logger.getLogger(AddressController.class);
	@Resource
	private AddressService addressService;
	@RequestMapping(value="insertAddress")
	public void insertAddress(HttpServletResponse response,HttpServletRequest request) {
		String userid =request.getParameter("userid");
		String name =request.getParameter("name");
		String detailed_address =request.getParameter("detailed_address");
		String address =request.getParameter("address");
		String phone =request.getParameter("phone");
		Address addres =new Address();
		addres.setAdd_time(CommonUtils.Obtain_date());
		addres.setAddress(address);
		addres.setDetailed_address(detailed_address);
		addres.setIs_default(1);
		addres.setName(name);
		addres.setUserid(userid);
		addres.setPhone(phone);
		try {
			int i =addressService.insert(addres);
			if(i==1) {
				log.info("添加地址成功");
			}else {
				log.info("添加地址失败");
			}
			OutString.outString(response,i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="selectList")
	public void selectList(HttpServletResponse response,Address address) {
		try {
			List<Address> list =addressService.selectList(address);
			OutString.outString(response, JSON.toJSON(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="update")
	public void update(HttpServletResponse response,Address address) {
		try {
			List<Address> list =addressService.selectList(new Address());
			for (Address address2 : list) {
				Integer is_default =address2.getIs_default();
				if(address2.getId()==address.getId()) {
					if(is_default==1) {
						address.setIs_default(0);
						addressService.update(address);
					}else {
						address.setIs_default(1);
						addressService.update(address);
					}
				}else {
					address.setIs_default(0);
					addressService.update(address);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
