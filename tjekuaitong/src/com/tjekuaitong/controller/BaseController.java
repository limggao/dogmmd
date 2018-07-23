package com.tjekuaitong.controller;


import com.qianmi.open.api.DefaultOpenClient;
import com.qianmi.open.api.OpenClient;
import com.tjekuaitong.uitls.Constants;

/**
 * Created by qmopen on 16/1/9.
 * 读取配置文件的数据
 */
public class BaseController {
    private static final String API_URL = "http://api.bm001.com/api";
    protected static final String APP_KEY = Constants.readCommonPropertiesFile().getProperty("appKey").trim();
    protected static final String APP_SECRET = Constants.readCommonPropertiesFile().getProperty("appSecret").trim();

    protected static String accessToken = Constants.readCommonPropertiesFile().getProperty("accessToken").trim();
    //异步通知地址
    protected static String notify_url = Constants.readCommonPropertiesFile().getProperty("notify_url").trim();
    protected static String notify_url1 = Constants.readCommonPropertiesFile().getProperty("notify_url1").trim();
    //下游商户号
    protected static String merchantId = Constants.readCommonPropertiesFile().getProperty("merchantId").trim();
    //protected static String callback_url = Constants.readCommonPropertiesFile().getProperty("callback_url").trim();
    // 创建一个客户端，默认连接超时时间为3秒，请求超时时间为15秒。
    protected static final OpenClient client = new DefaultOpenClient(API_URL, APP_KEY, APP_SECRET);

}
