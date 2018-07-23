package com.tjekuaitong.uitls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

public class OutString {

	/**
	 * 成功
	 * @param response
	 * @throws IOException
	 */
	public static void outTrue(HttpServletResponse response)
			throws IOException {
		 JSONObject json=new JSONObject();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		json.put("result", "0");
		json.put("msg", "成功");
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 失败
	 * @param response
	 * @throws IOException
	 */
	public static void outFalse(HttpServletResponse response)
			throws IOException {
		 JSONObject json=new JSONObject();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		json.put("result", "1");
		json.put("msg", "失败");
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 输出json
	 * @param response
	 * @param str
	 * @throws IOException
	 */
	public static void outString(HttpServletResponse response,Object str)
			throws IOException {
		Gson gson=new Gson();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(str));
		out.flush();
		out.close();
	}
	public static void outStrings(HttpServletResponse response,JSONObject json)
		throws IOException {
		byte[] jsonBytes;
		try {
			jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);  
	        response.getOutputStream().write(jsonBytes);  
	        response.getOutputStream().flush();  
	        response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}  
	}
	
}
