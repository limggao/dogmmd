package com.tjekuaitong.uitls;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;









import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.xfire.util.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjekuaitong.entity.User;
import com.tjekuaitong.entity.button.Button;
import com.tjekuaitong.entity.button.ClickButton;
import com.tjekuaitong.entity.button.Menu;
import com.tjekuaitong.entity.button.ViewButton;
import com.tjekuaitong.entity.rans.Data;
import com.tjekuaitong.entity.rans.Parts;
import com.tjekuaitong.entity.rans.Symbols;
import com.tjekuaitong.entity.rans.TransResult;
import com.tjekuaitong.entity.token.AccessToken;

public class WeixinUtil {
	//充值缴费
	private static final String VOUCHER_CENTER_URL="http://wx.tjaxej.com/tjekuaitong/NewFile3.jsp";
	//会员中心
	private static final String MEMBER_CENTER_URL="http://wx.tjaxej.com/tjekuaitong/NewFile4.jsp";
	//我的订单
	private static final String MY_ORDER_URL="http://wx.tjaxej.com/tjekuaitong/NewFile5.jsp";
	//客服中心
	private static final String CALL_CENTER_URL="http://www.baidu.com/";
	
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	//按钮生成
	private static final String CREATE_MENE_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//appid
	private static final String APPID="wx0bbdff5953b7b1cd";
	//AppSecret
	private static final String APPSECRET="8e92135db8afeadedebb7be1d57ce086";
	//token
	private static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	//code
	private static final String CODE_URL="http://oauth.qianmi.com/authorize";
	
	//获取用户openId
	private static final String USERID_URL="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	
	//获取用户基本信息
	private static final String USER_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//用户同意授权，获取code
	private static final String CODE1_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	//用户获取token无限次
	private static final String ACCESS_TOKEN_URL1="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//根据无限次的token获取用户信息
	
	private static final String USER_URL1="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//获取无限制的ACCESS_TOKEN_URL
	private static final String ACCESS_TOKEN1_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";	
	//
	/**
	 * get请求
	 * @param url
	 * @return
	 */
	public static JSONObject doGetStr(String url){
		CloseableHttpClient httpClient  =HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject =null;
	    try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity =response.getEntity();
			if(entity!=null){
				
				String result=EntityUtils.toString(entity,"UTF-8");
				jsonObject =JSON.parseObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * post请求
	 * @param url
	 * @param outStr
	 * @return
	 */
	public static JSONObject doPostStr(String url,String outStr){
		System.out.println("-------------------------");
		CloseableHttpClient httpClient  =HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject =null;
		try {
			httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
			System.out.println("httpPost"+httpPost);
			HttpResponse response =httpClient.execute(httpPost);
			String result=EntityUtils.toString(response.getEntity(),"UTF-8");
			jsonObject =JSON.parseObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * 向上游发送数据
	 */
	public static String sendPost(String url, Map<String, String> param5)
    {
    	OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            // 发送请求参数
            String paramStr=parseParams(param5);
            System.out.println(paramStr);
            //paramStr=new String(paramStr.getBytes("UTF-8"));
            out.write(paramStr);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            System.out.println(conn.getInputStream());
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null)
            {
            	System.out.println("line:"+line);
                result += line;
                System.out.println("result:"+result);
            }
        }
        catch (Exception e)
        {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }
	/**
	 * map转化字符串
	 * @param map
	 * @return
	 */
	  public static String toJson2(Map<String,String> map){
			Set<Map.Entry<String, String>> entrys = map.entrySet();
			Map.Entry<String, String> entry = null;
		    String key = "";
		    String value = "";
		    StringBuffer jsonBuffer = new StringBuffer();
		    jsonBuffer.append("{");    
		    for(Iterator<Map.Entry<String, String>> it = entrys.iterator();it.hasNext();){
		    	entry =  (Map.Entry<String, String>)it.next();
		    	key = entry.getKey();
		        value = entry.getValue();
		        jsonBuffer.append(key+":"+value);
		        if(it.hasNext()){
		             jsonBuffer.append(",");
		        }
		    }
		    jsonBuffer.append("}");
		    return jsonBuffer.toString();
		}
	  /**
	   * map转化字符串
	   * @param map
	   * @return
	   */
	  public static String toJson3(Map<String,String> map){
	    	Set<Map.Entry<String, String>> entrys = map.entrySet();
	    	Map.Entry<String, String> entry = null;
	    	String key = "";
	    	String value = "";
	    	StringBuffer jsonBuffer = new StringBuffer();
	    	jsonBuffer.append("{");    
	    	for(Iterator<Map.Entry<String, String>> it = entrys.iterator();it.hasNext();){
	    		entry =  (Map.Entry<String, String>)it.next();
	    		key = entry.getKey();
	    		value = entry.getValue();
	    		jsonBuffer.append("\""+key+"\":\""+value+"\"");
	    		if(it.hasNext()){
	    			jsonBuffer.append(",");
	    		}
	    	}
	    	jsonBuffer.append("}");
	    	return jsonBuffer.toString();
	    }

	
	/**
	 * 获取AccessToken
	 * @return
	 */
	
	public static AccessToken getAccessToken(){
		AccessToken token =new AccessToken();
		String url =ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject =doGetStr(url);
		if(jsonObject!=null){
			token.setExpiresIn(jsonObject.getString("expires_in"));
			token.setToken(jsonObject.getString("access_token"));
		}
		return token;
	}
	public static AccessToken getAccessToken1(String appId,String appSecret){
		AccessToken token =new AccessToken();
		String url =ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appSecret);
		JSONObject jsonObject =doGetStr(url);
		if(jsonObject!=null){
			token.setExpiresIn(jsonObject.getString("expires_in"));
			token.setToken(jsonObject.getString("access_token"));
		}
		return token;
	}
	public static com.tjekuaitong.entity.AccessToken getAccessTokens(String code){
		com.tjekuaitong.entity.AccessToken token =new com.tjekuaitong.entity.AccessToken();
		String url =ACCESS_TOKEN1_URL.replace("APPID", APPID).replace("SECRET", APPSECRET).replace("CODE", code);
		JSONObject jsonObject =doGetStr(url);
		if(jsonObject!=null){
			token.setAccess_token(jsonObject.getString("access_token"));
			token.setExpires_in(jsonObject.getString("expires_in"));
			token.setOpenid(jsonObject.getString("openid"));
			token.setRefresh_token(jsonObject.getString("refresh_token"));
			token.setScope(jsonObject.getString("scope"));
		}
		return token;
	}
	
	//获取openId
	
	public static String openId(String url ,Logger log ) throws IOException{
		String code_url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+APPID
				+ "&redirect_uri="+URLEncoder.encode(url)
				+ "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		
		//String ss =CODE1_URL.replace("APPID", APPID).replace("REDIRECT_URI", URLEncoder.encode(url));
		log.info("yy:"+code_url);
		return code_url;
	}
	/**
	 * 获取所有用户
	 * @return
	 *//*
	public static UserId userAllId(String ACCESSTOKEN){
		UserId user =new UserId();
		String url =USERID_URL.replace("ACCESS_TOKEN", ACCESSTOKEN).replace("NEXT_OPENID", "");
		JSONObject jsonObject =doGetStr(url);
		System.out.println("1=====-----------"+com.gexin.fastjson.JSON.toJSON(jsonObject));
		if(jsonObject!=null){
			user.setCount(jsonObject.getString("total"));
			user.setData(jsonObject.getString("data"));
			user.setTotal(jsonObject.getString("total"));
			user.setNext_openid(jsonObject.getString("next_openid"));
		}
		return user;
	}*/
/*	//获取一个用户所有信息
	public static User userAll(String openId,String ACCESSTOKEN){
		User user =new User();
		String url =USER_URL.replace("ACCESS_TOKEN", ACCESSTOKEN).replace("OPENID",openId);
		JSONObject jsonObject =doGetStr(url);
		if(jsonObject!=null){
			user.setCity(jsonObject.getString("city"));
			user.setCountry(jsonObject.getString("country"));
			user.setGroupid(jsonObject.getString("groupid"));
			user.setHeadimgurl(jsonObject.getString("headimgurl"));
			user.setLanguage(jsonObject.getString("language"));
			user.setNickname(jsonObject.getString("nickname"));
			user.setOpenid(jsonObject.getString("openid"));
			user.setProvince(jsonObject.getString("province"));
			user.setSex(jsonObject.getString("sex"));
			user.setRemark(jsonObject.getString("remark"));
			user.setSubscribe(jsonObject.getString("subscribe"));
			user.setSubscribe_time(jsonObject.getString("subscribe_time"));
			user.setTagid_list(jsonObject.getString("tagid_list"));
			user.setUnionid(jsonObject.getString("unionid"));
		}
		return user;
	}
*/	public static com.tjekuaitong.entity.AccessToken userAll1(String code){
		com.tjekuaitong.entity.AccessToken token =new com.tjekuaitong.entity.AccessToken();
		String url =ACCESS_TOKEN_URL1.replace("APPID", APPID).replace("CODE",code).replace("SECRET",APPSECRET);
		JSONObject jsonObject =doGetStr(url);
		if(jsonObject!=null){
			token.setAccess_token(jsonObject.getString("access_token"));
			token.setExpires_in(jsonObject.getString("expires_in"));
			token.setOpenid(jsonObject.getString("openid"));
			token.setRefresh_token(jsonObject.getString("refresh_token"));
			token.setScope(jsonObject.getString("scope"));
		}
		return token;
	}
	//根据无限次的token获取用户信息
	/*
	public static User userWuXian(String openId,String ACCESSTOKEN){
		User user =new User();
		String url =USER_URL1.replace("ACCESS_TOKEN", ACCESSTOKEN).replace("OPENID",openId);
		JSONObject jsonObject =doGetStr(url);
		if(jsonObject!=null){
			user.setCity(jsonObject.getString("city"));
			user.setCountry(jsonObject.getString("country"));
			user.setGroupid(jsonObject.getString("groupid"));
			user.setHeadimgurl(jsonObject.getString("headimgurl"));
			user.setLanguage(jsonObject.getString("language"));
			user.setNickname(jsonObject.getString("nickname"));
			user.setOpenid(jsonObject.getString("openid"));
			user.setProvince(jsonObject.getString("province"));
			user.setSex(jsonObject.getString("sex"));
			user.setRemark(jsonObject.getString("remark"));
			user.setSubscribe(jsonObject.getString("subscribe"));
			user.setSubscribe_time(jsonObject.getString("subscribe_time"));
			user.setTagid_list(jsonObject.getString("tagid_list"));
			user.setUnionid(jsonObject.getString("unionid"));
		}
		return user;
	}*/
	
	/**
	 * 文件上传
	 * @param filePath
	 * @param accessToken
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public static String upload(String filePath, String accessToken,String type) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE",type);
		
		URL urlObj = new URL(url);
		//连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		con.setRequestMethod("POST"); 
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); 

		//设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		//设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		//获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		//输出表头
		out.write(head);

		//文件正文部分
		//把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		//结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");//定义最后数据分隔线

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			//定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSON.parseObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if(!"image".equals(type)){
			typeName = type + "_media_id";
		}
		String mediaId = jsonObj.getString(typeName);
		return mediaId;
	}
	/**
	 * 组装菜单
	 * @return
	 */
	public static Menu initMenu(){
		Menu menu =new Menu();
		ClickButton clickButton =new ClickButton();
		clickButton.setName("精品阅读");
		clickButton.setType("click");
		clickButton.setKey("111");
		
		ViewButton viewButton11 =new ViewButton();
		viewButton11.setName("充值缴费");
		viewButton11.setType("view");
		viewButton11.setUrl(VOUCHER_CENTER_URL);
		
		ViewButton viewButton21 =new ViewButton();
		viewButton21.setName("会员中心");
		viewButton21.setType("view");
		viewButton21.setUrl(MEMBER_CENTER_URL);
		
		ViewButton viewButton22 =new ViewButton();
		viewButton22.setName("我的订单");
		viewButton22.setType("view");
		viewButton22.setUrl(MY_ORDER_URL);
		
		ClickButton clickButton23 =new ClickButton();
		clickButton23.setName("客服中心");
		clickButton23.setType("click");
		clickButton23.setKey("222");
		
		Button button =new Button();
		button.setName("分销中心");
		
		button.setSub_button(new Button[]{viewButton21,viewButton22,clickButton23});
		menu.setButton(new Button[]{viewButton11,button,clickButton});
		return menu;
	}
	
	public static int creatMenu(String token,String menu){
		int result=0;
		String  url =CREATE_MENE_URL.replace("ACCESS_TOKEN", token);
		System.out.println("url:"+url);
		JSONObject jsonObject = doPostStr(url, menu);
		if(jsonObject!=null){
			result=jsonObject.getInteger("errcode");
		}
		return result;
	}
	
	public static JSONObject queryMenu(String token) throws ParseException, IOException{
		String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}
	
	public static int deleteMenu(String token) throws ParseException, IOException{
		String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		int result = 0;
		if(jsonObject != null){
			result = jsonObject.getInteger("errcode");
		}
		return result;
	}
	
	public static String translate(String source) throws ParseException, IOException{
		String url = "http://openapi.baidu.com/public/2.0/translate/dict/simple?client_id=jNg0LPSBe691Il0CG5MwDupw&q=KEYWORD&from=auto&to=auto";
		url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
		JSONObject jsonObject = doGetStr(url);
		String errno = jsonObject.getString("errno");
		Object obj = jsonObject.get("data");
		StringBuffer dst = new StringBuffer();
		if("0".equals(errno) && !"[]".equals(obj.toString())){
			/**
			 * 待测试
			 */
			TransResult transResult = (TransResult) JSON.toJavaObject(jsonObject, TransResult.class);
			Data data = transResult.getData();
			Symbols symbols = data.getSymbols()[0];
			String phzh = symbols.getPh_zh()==null ? "" : "中文拼音："+symbols.getPh_zh()+"\n";
			String phen = symbols.getPh_en()==null ? "" : "英式英标："+symbols.getPh_en()+"\n";
			String pham = symbols.getPh_am()==null ? "" : "美式英标："+symbols.getPh_am()+"\n";
			dst.append(phzh+phen+pham);
			
			Parts[] parts = symbols.getParts();
			String pat = null;
			for(Parts part : parts){
				pat = (part.getPart()!=null && !"".equals(part.getPart())) ? "["+part.getPart()+"]" : "";
				String[] means = part.getMeans();
				dst.append(pat);
				for(String mean : means){
					dst.append(mean+";");
				}
			}
		}else{
			dst.append(translateFull(source));
		}
		return dst.toString();
	}
	
	public static String translateFull(String source) throws ParseException, IOException{
		String url = "http://openapi.baidu.com/public/2.0/bmt/translate?client_id=jNg0LPSBe691Il0CG5MwDupw&q=KEYWORD&from=auto&to=auto";
		url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
		JSONObject jsonObject = doGetStr(url);
		StringBuffer dst = new StringBuffer();
		List<Map> list = (List<Map>) jsonObject.get("trans_result");
		for(Map map : list){
			dst.append(map.get("dst"));
		}
		return dst.toString();
	}
	/**
	 * 获取签名
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String commSign(Map<String, String> param) throws UnsupportedEncodingException {
		String result = null;

		StringBuffer sb = new StringBuffer();
		Set<Entry<String, String>> set = param.entrySet();
		Iterator<Entry<String, String>>  interator = set.iterator();
		while (interator.hasNext()) {
			Entry<String, String> entry =  interator.next();
			if (!"sign".equals(entry.getKey())) {
				if(!entry.getValue().isEmpty()){
					sb.append(entry.getKey());
					sb.append("=");
					sb.append(entry.getValue());
					sb.append("&");
				}
			}
		}
		result = com.tjekuaitong.uitls.Base64.getBase64(MD5.encryption(sb.toString().substring(0,sb.toString().length() - 1)));
		
		return result;
	}
	
	/**
	 * 数据拼接
	 * @param params
	 * @return
	 */
	public static String parseParams(Map<String, String> params)  {
        int i = 0;
        String param = "";
        if (params.containsKey("content")) {
            params.put("content", params.get("content"));
        }
        for (String key : params.keySet()) {
            if (i > 0) {
                param += "&";
            }
            param += key + "=" + params.get(key);
            i++;
        }
        return param;
    }
	
	public static String getSessionKey(String code) {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + TokenThread.appid + "&secret="
				+ TokenThread.appsecret + "&js_code=" + code + "&grant_type=authorization_code";
		JSONObject oppidObj = WeixinUtil.doGetStr(url);
		String openid = (String) oppidObj.get("openid");
		String session_key = (String) oppidObj.get("session_key");
		return session_key;
	}
	
	/**
     * 获取信息
     */
    public static JSONObject getUserInfo(String encryptedData,String sessionkey,String iv){
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionkey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
               // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return null;
    }
 
}
