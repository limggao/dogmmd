package com.tjekuaitong.uitls;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * 
 * @Description 验签
 * @author Shiwen .Li
 * @date 2016年9月26日 下午11:14:47
 * @version V1.3.1
 */
public class PuFaSignUtil {

	/**
	 * 
	 * @Description 签名
	 * @author Administrator
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public static String sign(Map<String, String> param) throws Exception {

		String result = commSign(param);
		return result;
	}

	/**
	 * 公用
	 * 
	 * @Description
	 * @author Administrator
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	private static String commSign(Map<String, String> param) throws Exception {
		String result = null;
		param = BeanToMapUtil.map2TreeMap(param);
		System.out.println("param:"+param);
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
		System.out.println("sb:"+sb);
		System.out.println("数据"+sb.toString().substring(0,sb.toString().length() - 1));
		result = Base64.getBase64(MD5.encryption(sb.toString().substring(0,sb.toString().length() - 1)));
		System.out.println("sign:"+result);
		
		return result;
	}

	/**
	 * 
	 * @Description 验证签名
	 * @author Administrator
	 * @param param
	 * @param sign
	 * @return
	 * @throws Exception 
	 */
	public static boolean signVerify(Map<String, String> param, String sign) throws Exception {
		String result = commSign(param);
		return result.equals(sign);
	}
}
