/*package com.tjekuaitong.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjekuaitong.entity.AccessToken;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.entity.UserId;
import com.tjekuaitong.entity.Users;
import com.tjekuaitong.service.IPhoneRecharge;
import com.tjekuaitong.service.UserService;
import com.tjekuaitong.uitls.OutString;
import com.tjekuaitong.uitls.TokenThread;
import com.tjekuaitong.uitls.WeixinUtil;

@Controller
@RequestMapping("/UserController")
public class UserController {

	Logger log = Logger.getLogger(MobileController.class);
	@Resource
	private UserService userService;
	@Resource
	private IPhoneRecharge phoneRechargeService;

	@RequestMapping(value = "login")
	public void login(String userName, String passWord,
			HttpServletResponse response,HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		Users users = phoneRechargeService.select(userName);
		System.out.println(users);
		if (users != null && users.getPassWord().equals(passWord)) {
			request.getSession().setAttribute("user", users);
			System.out.println("111111");
			map.put("msg", "成功");
			map.put("r", "1");
		} else {
			map.put("msg", "失败");
			map.put("r", "0");
		}
		try {
			System.out.println("----------------");
			OutString.outString(response, JSON.toJSON(map));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	//分页查询
	@RequestMapping(value="userPage")
	public void userPage(int pageIndex, int pageSize,HttpServletResponse response){
		
		List<User> lsit =userService.getLimitUser(pageIndex, pageSize);
		try {
			OutString.outString(response, JSON.toJSON(lsit));
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取总数
	@RequestMapping(value="index")
	public void index(HttpServletResponse response){
		Integer count = userService.countUser();
		try {
			OutString.outString(response, count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 获取微信个人信息index界面
	@RequestMapping(value = "weixinName")
	public void weiixnName(HttpServletRequest request,
			HttpServletResponse response) {
		log.info("weiixnName--------------------来了！");
		String url = "http://wx.tjaxej.com/tjekuaitong/UserController/token";

		String code_url;
		try {
			code_url = WeixinUtil.openId(url, log);
			response.sendRedirect(code_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 返回微信个人信息index界面
	@RequestMapping(value = "token")
	public void token(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		log.info("token-code-------------------来了！" + code);
		AccessToken accessToken=WeixinUtil.userAll1(code);
		//AccessToken accessToken = WeixinUtil.getAccessTokens(code);
		log.info("来了accessToken:" + JSON.toJSONString(accessToken));
		//自己数据库获取来的信息
		User user = userService.selects(accessToken.getOpenid());
		if(user==null){
			log.info("现在的token:"+accessToken.getAccess_token());
			User users=WeixinUtil.userWuXian(accessToken.getOpenid(), accessToken.getAccess_token());
			log.info("来了users:" + JSON.toJSONString(users));
			Random random =new Random();
			log.info(random.nextInt(100));
			users.setOpenid(accessToken.getOpenid());
			users.setUserId("A"+new SimpleDateFormat("dd").format(new Date())+random.nextInt(10000));
			users.setVip_j("0");
			log.info("来了啊！1");
			log.info("微信用户名字:"+JSON.toJSON(users.getNickname()));
			boolean l =phoneRechargeService.insert(users);
			log.info("添加状态l:"+l);	
			user = userService.selects(accessToken.getOpenid());
		}
		//微信那边获取来的信息
		log.info("来了user:" + JSON.toJSONString(user));
		log.info("token:" + JSON.toJSONString(accessToken));
		try {
			log.info("Openid:" + accessToken.getOpenid());
			request.getSession().setAttribute("headimgurl", user.getHeadimgurl());
			request.getSession().setAttribute("data", user.getUserId());
			request.getSession().setAttribute("name", user.getNickname());
			request.getSession().setAttribute("vip_j", user.getVip_j());
			request.getSession().setAttribute("openId", user.getOpenid());
			request.getRequestDispatcher("/pages/index.jsp").forward(request,
					response);
			log.info("来吧:111111111111");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取微信个人信息member_center界面
	@RequestMapping(value = "memberCenter")
	public void memberCenter(HttpServletRequest request,
			HttpServletResponse response) {
		log.info("memberCenter--------------------来了！");
		String url = "http://wx.tjaxej.com/tjekuaitong/UserController/token1";

		String code_url;
		try {
			code_url = WeixinUtil.openId(url, log);
			response.sendRedirect(code_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 返回微信个人信息member_center界面
	@RequestMapping(value = "token1")
	public void token1(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		log.info("token1-code-------------------来了！" + code);
		AccessToken accessToken = WeixinUtil.getAccessTokens(code);
		//微信那边获取来的信息
		//User users=WeixinUtil.userAll(accessToken.getOpenid(), accessToken.getAccess_token());
		//自己数据库获取来的信息
		User user = userService.selects(accessToken.getOpenid());
		log.info("token:" + JSON.toJSONString(accessToken));
		try {
			log.info("Openid:" + accessToken.getOpenid());
			request.getSession().setAttribute("headimgurl", user.getHeadimgurl());
			request.getSession().setAttribute("data", user.getUserId());
			request.getSession().setAttribute("name", user.getNickname());
			request.getSession().setAttribute("vip_j", user.getVip_j());
			request.getSession().setAttribute("openId", user.getOpenid());
			request.getRequestDispatcher("/pages/member_center.jsp").forward(
					request, response);
			log.info("来吧:111111111111");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取微信个人信息pending_payment.jsp界面
	@RequestMapping(value = "pendingPayment")
	public void pendingPayment(HttpServletRequest request,
			HttpServletResponse response) {
		log.info("pendingPayment--------------------来了！");
		String url = "http://wx.tjaxej.com/tjekuaitong/UserController/token2";

		String code_url;
		try {
			code_url = WeixinUtil.openId(url, log);
			response.sendRedirect(code_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 返回微信个人信息pending_payment.jsp界面
	@RequestMapping(value = "token2")
	public void token2(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		log.info("token2-code-------------------来了！" + code);
		AccessToken accessToken = WeixinUtil.getAccessTokens(code);
		//微信那边获取来的信息
		//User users=WeixinUtil.userAll(accessToken.getOpenid(), accessToken.getAccess_token());
		//自己数据库获取来的信息
		User user = userService.selects(accessToken.getOpenid());
		log.info("token:" + JSON.toJSONString(accessToken));
		try {
			log.info("Openid:" + accessToken.getOpenid());
			request.getSession().setAttribute("headimgurl",
					user.getHeadimgurl());
			request.getSession().setAttribute("data", user.getUserId());
			request.getSession().setAttribute("name", user.getNickname());
			request.getSession().setAttribute("vip_j", user.getVip_j());
			request.getSession().setAttribute("openId", user.getOpenid());
			request.getRequestDispatcher("/recharge_record/pending_payment.jsp")
					.forward(request, response);
			log.info("来吧:111111111111");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	*//**
	 * 获取一个用户的信息
	 *//*
	@RequestMapping(value = "getAll")
	public void getAll(String orderId, HttpServletResponse response) {
		User user = userService.selects(orderId);
		try {
			OutString.outString(response, JSON.toJSON(user));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
*/