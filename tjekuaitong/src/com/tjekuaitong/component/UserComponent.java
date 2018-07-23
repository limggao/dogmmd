/*package com.tjekuaitong.component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjekuaitong.controller.BaseController;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.entity.UserId;
import com.tjekuaitong.service.IPhoneRecharge;
import com.tjekuaitong.service.UserService;
import com.tjekuaitong.uitls.TokenThread;
import com.tjekuaitong.uitls.WeixinUtil;
//定时获取用户信息
@Component
public class UserComponent extends BaseController{
	Logger log = Logger.getLogger(UserComponent.class);
	@Resource 
	private UserService userService;
	@Resource
	private IPhoneRecharge phoneRechargeService;
	
	public void userAll(){
		UserId userId = WeixinUtil.userAllId(TokenThread.accessToken.getToken());
		JSONObject json =JSON.parseObject(userId.getData());
		String[] s=	json.get("openid").toString().replace("\"", "").replace("[", "").replace("]", "").split(",");
		for (int i = 0; i < s.length; i++) {
			User user1 =userService.selects(s[i]);
			User user =WeixinUtil.userAll(s[i], TokenThread.accessToken.getToken());
			if(user1==null){
				log.info(s[i]);
				//数据库升级以下增加编码utf8mb4
				log.info(JSON.toJSON(user));
				Random random =new Random();
				log.info(random.nextInt(100));
				user.setUserId("A1"+new SimpleDateFormat("ss").format(new Date())+random.nextInt(1000));
				user.setVip_j("0");
				log.info("微信用户名字:"+JSON.toJSON(user.getNickname()));
				boolean l =phoneRechargeService.insert(user);
				log.info(l);
			}else{
				int i1 =userService.update(user);
				log.info("sweqwe:"+i1);
			}
			
		}
		
	}
	 
     * 将时间戳转换为时间
     
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    
   
}
*/