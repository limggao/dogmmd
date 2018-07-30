package com.tjekuaitong.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjekuaitong.service.UserService;
import com.tjekuaitong.uitls.WeixinUtil;

@Controller
@RequestMapping("/UserController")
public class UserController {

	Logger log = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;

	@RequestMapping(value = "getWxUserInfo")
	public void getWxUserInfo(HttpServletResponse response,HttpServletRequest request) {
		
		String code=request.getParameter("code");
		String iv=request.getParameter("iv");
		String encryptedData=request.getParameter("encryptedData");
		String sessionkey = WeixinUtil.getSessionKey(code);
		JSONObject userInfo = WeixinUtil.getUserInfo(encryptedData, sessionkey, iv);
		System.out.println(JSON.toJSON(userInfo));
	}

	
}
