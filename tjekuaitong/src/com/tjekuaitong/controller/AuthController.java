/*package com.tjekuaitong.controller;

import com.alibaba.fastjson.JSON;
import com.qianmi.open.api.ApiException;
import com.qianmi.open.api.response.TokenResponse;
import com.qianmi.open.api.tool.util.OAuthUtils;
import com.qianmi.open.api.tool.util.QianmiContext;
import com.tjekuaitong.uitls.Constants;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletResponse;

*//**
 * 应用授权
 *//*
@Controller
@RequestMapping("/authController")
public class AuthController extends BaseController {

	Logger log = Logger.getLogger(AuthController.class);
    *//**
     * 接收回调地址中的code参数用来获取token
     * @param code
     * @return
     *//*
    @RequestMapping("/callback")
    public void getToken(String code, Model model,HttpServletResponse responses) {
    	log.info("来了！！！！！");
        try {
            QianmiContext context = OAuthUtils.getToken(APP_KEY, APP_SECRET, code);
            TokenResponse response = context.getTokenResponse();
            log.info("response:"+JSON.toJSONString(response));
            if (response.isSuccess()) {
            	//动态修改配置文件的数据
                updateToken(response);
              //动态刷新token
                //startRefreshToken();
                responses.sendRedirect("pages/auth-success.jsp");
            } else {
            	log.info("errMsg"+response.getErrorCode()+":"+response.getMsg());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    //动态刷新token
    private void startRefreshToken() {
        // 刷新Token任务
        TimerTask refreshTokenTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    QianmiContext context = OAuthUtils.refreshToken(APP_KEY, APP_SECRET, Constants.readCommonPropertiesFile().getProperty("refreshToken"));
                    updateToken(context.getTokenResponse());
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        };
        // 每天7点刷新Token，每隔12个小时刷新一次
        new Timer("refresh-token-timer", true).schedule(refreshTokenTask, getFirstTime(), 12 * 60 * 60 * 1000);
    }

    *//**
     * 获取第一次执行任务的时间
     * @return
     *//*
    private Date getFirstTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();
        if (date.after(new Date())) {
            return date;
        }
        calendar.add(Calendar.HOUR, 12);
        return calendar.getTime();
    }
  //动态修改配置文件的数据
    private void updateToken(TokenResponse response) {
        // 设置refreshToken
    	Properties properties =new Properties();
    	properties.put("refreshToken", response.getRefreshToken());
    	properties.put("accessToken", response.getAccessToken());
    	Constants.setProperty(properties);
    }

}
*/