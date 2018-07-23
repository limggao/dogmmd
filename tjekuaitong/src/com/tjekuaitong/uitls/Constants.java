package com.tjekuaitong.uitls;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Properties;




/**
 * Created by qmopen on 16/1/9.
 */
public final class Constants {

    private Constants() {}

    /**
     * open相关的配置信息
     */
    //读取配置文件数据
    public static Properties readCommonPropertiesFile() {
    Properties props =new Properties();
    InputStream in = Constants.class.getResourceAsStream("/config/config.properties");
    BufferedReader bf;
	try {
		bf = new BufferedReader(new InputStreamReader(in,"utf-8"));
		props.load(bf);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    return props;
    }
    
    //向配置文件加入accessToken，refreshToken
    public static void setProperty(Properties properties){
    	Properties props =new Properties();
    	InputStream in;
    	 
		try {
			in = new FileInputStream("F:\\workSpace\\tjekuaitong\\src\\config\\config.properties");
			props.load(in);  
			props.setProperty("accessToken", properties.getProperty("accessToken"));
			props.setProperty("refreshToken", properties.getProperty("refreshToken"));
			OutputStream out = new FileOutputStream("F:\\workSpace\\tjekuaitong\\src\\config\\config.properties");  
			props.store(out, null);  
			in.close();  
            out.close();  
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	
    	
    }
   /* public static void loadProps(Properties props) {
        Constants.props = props;
    }

    public static String getProperty(final String key) {
        return props.getProperty(key);
    }
    public static void setProperty(final String key, final String value) {
        props.put(key, value);
    }*/

}
