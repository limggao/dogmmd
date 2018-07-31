package com.tjekuaitong.controller;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.service.UserService;
import com.tjekuaitong.uitls.CommonUtils;
import com.tjekuaitong.uitls.OutString;
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
		User user =new User();
		user.setOpenid(userInfo.getString("openId"));
		List<User> list =null;
		try {
			 list =userService.selectList(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.size()<1) {
			 user.setNickname(userInfo.getString("nickName"));
			 user.setAvatarUrl(userInfo.getString("avatarUrl"));
			 user.setCity(userInfo.getString("city"));
			 user.setGender(userInfo.getString("gender"));
			 user.setCountry(userInfo.getString("country"));
			 user.setLanguage(userInfo.getString("language"));
			 user.setProvince(userInfo.getString("province"));
			 String watermark =userInfo.getString("watermark");
			 JSONObject watermark1=JSONObject.parseObject(watermark);
			 user.setAppid(watermark1.getString("appid"));
			 user.setUserid(CommonUtils.get10RandomNumber());
			 int i=0;
			try {
				i = userService.insert(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 log.info("插入用户信息状态："+i);
			 list.add(user);
		 }
		try {
			OutString.outString(response, JSON.toJSON(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="login")
	public void login(HttpServletResponse response,HttpServletRequest request) {
		
		String openid=request.getParameter("openid");
		String phone=request.getParameter("phone");
		String userid=request.getParameter("userid");
		User user =new User();
		user.setOpenid(openid);
		user.setUserid(userid);
		try {
			user =userService.selectOne(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			OutString.outString(response, JSON.toJSON(user));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
