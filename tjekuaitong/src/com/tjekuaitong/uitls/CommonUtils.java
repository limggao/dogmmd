package com.tjekuaitong.uitls;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import Decoder.BASE64Decoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * 导入这个工具类需要配置如下
 */

/*<bean id="multipartResolver"
class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
<property name="defaultEncoding" value="UTF-8" />
<property name="maxUploadSize" value="32505856" /><!-- 上传文件大小限制为31M，31*1024*1024 -->
<property name="maxInMemorySize" value="4096" />
</bean> 

<bean id="exceptionResolver" class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
<property name="exceptionMappings">
<props>
    <!-- 遇到MaxUploadSizeExceededException异常时,自动跳转到/WEB-INF/jsp/error.jsp页面 -->
    <prop key="org.springframework.web.multipart.MaxUploadSizeExceededException">/errorpage/error_500</prop>
</props>
</property>
</bean>*/





/**
 * 工具类
 * 
 * @ClassName: CommonUtils
 * @Description: TODO
 * @author Lan
 * @date 2015年9月7日 下午8:09:17
 * 
 */
public class CommonUtils {

	HttpServletResponse response;

	/**
	 * 时间格式
	 */
	public static final String GENERAL_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String CHINAWEEK = "EEEE";// 中文格式的“星期几”
	public static final String CHINAMONTH = "MMMM";// 中文格式的“十几月”

	/**
	 * 能见度转换成文字
	 * 
	 * @param vis
	 * @return
	 */
	public String changeVis(double vis) {
		String v = "";
		if (vis < 1) {
			v = "不足一公里";
		} else if (vis >= 1 && vis < 2) {
			v = "1-2公里";
		} else if (vis >= 2 && vis < 3) {
			v = "2-3公里";
		} else if (vis >= 3 && vis < 4) {
			v = "3-4公里";
		} else if (vis >= 4 && vis < 5) {
			v = "4-5公里";
		} else if (vis >= 5 && vis < 6) {
			v = "5-6公里";
		} else if (vis >= 6 && vis < 7) {
			v = "6-7公里";
		} else if (vis >= 7 && vis < 8) {
			v = "7-8公里";
		} else if (vis >= 8 && vis < 9) {
			v = "8-9公里";
		} else if (vis >= 9 && vis < 10) {
			v = "9-10公里";
		} else if (vis >= 10 && vis < 11) {
			v = "10-11公里";
		} else if (vis >= 11 && vis < 12) {
			v = "11-12公里";
		} else if (vis >= 12 && vis < 13) {
			v = "12-13公里";
		} else if (vis >= 13 && vis < 14) {
			v = "13-14公里";
		} else if (vis >= 14 && vis < 15) {
			v = "14-15公里";
		} else if (vis >= 15 && vis < 16) {
			v = "15-16公里";
		} else if (vis >= 16 && vis < 17) {
			v = "16-17公里";
		} else if (vis >= 17 && vis < 18) {
			v = "17-18公里";
		} else if (vis >= 18 && vis < 19) {
			v = "18-19公里";
		} else if (vis >= 19 && vis < 20) {
			v = "19-20公里";
		}
		return v;
	}

	/**
	 * 风速转风力
	 * 
	 * @param {Object} speed
	 */
	public static String speedToForce(double speed) {
		String force = "";
		if (speed <= 0.2) {
			force = "无风";
		} else if (speed > 0.2 && speed <= 3.3) {
			force = "微风";
		} else if (speed > 1.5 && speed <= 3.3) {
			force = "1-2级";
		} else if (speed > 3.3 && speed <= 5.4) {
			force = "2-3级";
		} else if (speed > 5.4 && speed <= 7.9) {
			force = "3-4级";
		} else if (speed > 7.9 && speed <= 10.7) {
			force = "4-5级";
		} else if (speed > 10.7 && speed <= 13.8) {
			force = "5-6级";
		} else if (speed > 13.8 && speed <= 17.1) {
			force = "6-7级";
		} else if (speed > 17.1 && speed <= 20.7) {
			force = "7-8级";
		} else if (speed > 20.7 && speed <= 24.4) {
			force = "8-9级";
		} else if (speed > 24.4 && speed <= 28.4) {
			force = "9-10级";
		} else if (speed > 28.4 && speed <= 32.6) {
			force = "10-11级";
		} else {
			force = "11-12级";
		}
		return force;
	}

	/**
	 * 获取UUID替换里面的-字符
	 * 
	 * @return
	 */
	public final static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	/**
	 * 是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		return org.apache.commons.lang.StringUtils.isNumeric(str);
	}

	/**
	 * 判断一个字符串是否为double long 是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		try {
			double db = Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 字符串加上UUID
	 * 
	 * @param pre
	 *            字符串类型参数
	 * @return
	 */
	public final static String getUUID(String pre) {
		return pre + getUUID();
	}

	/**
	 * 返回20 number char
	 * 
	 * @return 20 number char
	 */
	public synchronized final static String getKey() {
		long l = System.currentTimeMillis();
		double d = Math.random();
		StringBuffer sb = new StringBuffer();
		sb.append(d);
		sb.delete(0, sb.length() - 7);
		sb.insert(0, l);
		return sb.toString();
	}

	public synchronized final static Long getLongKey() {
		return new Double(System.currentTimeMillis()
				+ Math.ceil(Math.random() * 10000)).longValue();
	}

	public synchronized final static String getKey(String str) {
		return str + getKey();
	}

	/**
	 * null字符串的处理
	 * 
	 * @param str
	 * @return
	 */
	public final static String getStr(String str) {
		// String back = "";
		// back = (CommonUtils.isNull(str)) ? "" : str;
		// return back;
		return CommonUtils.isNull(str) ? "" : str;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            需判断的字符串
	 * @return boolean
	 */
	public final static boolean isNull(String str) {
		return str == null || str.isEmpty() || "null".equalsIgnoreCase(str);
	}

	public final static boolean isNotNull(String str) {
		return !CommonUtils.isNull(str);
	}

	public final static boolean isNullWithTrim(String str) {
		return str == null || str.trim().isEmpty()
				|| "null".equalsIgnoreCase(str.trim());
	}

	public final static boolean isNotNullWithTrim(String str) {
		return !CommonUtils.isNotNullWithTrim(str);
	}

	/**
	 * 判断数组是否为空
	 * 
	 * @param s
	 *            需判断的数组
	 * @return boolean
	 * @author Guan
	 */
	@SuppressWarnings("rawtypes")
	public final static boolean isNull(Collection collection) {
		return collection == null || collection.isEmpty();
	}

	@SuppressWarnings("rawtypes")
	public final static boolean isNotNull(Collection collection) {
		return !CommonUtils.isNull(collection);
	}

	@SuppressWarnings("rawtypes")
	public final static boolean isNull(Map m) {
		return m == null || m.isEmpty();
	}

	@SuppressWarnings("rawtypes")
	public final static boolean isNotNull(Map m) {
		return !CommonUtils.isNull(m);
	}

	/**
	 * 日期类型,转换成字符串
	 * 
	 * @param d
	 *            日期
	 * @param format
	 *            格式 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public final static String dateToString(Date d, String format) {
		return DateFormatUtils.format(d, format);
	}

	// 获取时间格式的字符串
	public static String Obtain_date(String format) {
		SimpleDateFormat dft = new SimpleDateFormat(format);
		Date date = new Date();
		return dft.format(date);
	}

	// 获取时间格式的时间
	public static Date Obtain_time(String format) throws ParseException {
		SimpleDateFormat dft = new SimpleDateFormat(format);
		Date date = new Date();
		return dft.parse(dft.format(date));
	}

	// 获取时间格式的字符串
	public static String Obtain_date() {
		SimpleDateFormat dft = new SimpleDateFormat(GENERAL_TIME);
		Date date = new Date();
		return dft.format(date);
	}

	// 获取时间格式的时间
	public static Date Obtain_time() throws ParseException {
		SimpleDateFormat dft = new SimpleDateFormat(GENERAL_TIME);
		Date date = new Date();
		return dft.parse(dft.format(date));
	}

	// 获取格式化字符串的时间
	public static Date Vert_time(String date) throws ParseException {
		SimpleDateFormat dft = new SimpleDateFormat(GENERAL_TIME);
		return dft.parse(date);
	}

	// 枷锁时间戳生成ID
	public synchronized static String getKeys() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		return str;
	}

	/**
	 * 字符串,转换成日期类型
	 * 
	 * @param dateString
	 *            日期格式字符串
	 * @param format
	 *            格式 yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 */
	public final static Date stringToDate(String dateString, String format)
			throws ParseException {
		if (CommonUtils.isNull(dateString))
			throw new IllegalArgumentException("dateString can not be null!");
		if (!CommonUtils.isNull(format))
			return DateUtils.parseDate(dateString, format);

		String[] parsePatterns = { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd",
				"yyyy/MM/dd", "yyyy-MM-dd HH:mm", "yyyy/MM/dd HH:mm",
				"yyyy/MM/dd HH:mm:ss" };
		return DateUtils.parseDate(dateString, parsePatterns);
	}

	/**
	 * 加减时间<br>
	 * 在原来的时间上，根据传递过来的类型，加减时间指定时间
	 * 
	 * @param time
	 *            原时间
	 * @param type
	 *            加减时间类型<br>
	 *            year:年，month:月，day:日，hour:时，minute:分，second:秒，millisecond:毫秒，
	 *            其他默认毫秒
	 * @param modified
	 *            原时间
	 * @return Date 新时间
	 */
	public final static Date modifiedTime(Date time, String type, int modified) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		if ("year".equals(type)) {
			calendar.add(Calendar.YEAR, modified);
		} else if ("month".equals(type)) {
			calendar.add(Calendar.MONTH, modified);
		} else if ("day".equals(type)) {
			calendar.add(Calendar.DAY_OF_YEAR, modified);
		} else if ("hour".equals(type)) {
			calendar.add(Calendar.HOUR, modified);
		} else if ("minute".equals(type)) {
			calendar.add(Calendar.MINUTE, modified);
		} else if ("second".equals(type)) {
			calendar.add(Calendar.SECOND, modified);
		} else {
			calendar.add(Calendar.MILLISECOND, modified);
		}
		Date addDate = calendar.getTime();
		return addDate;
	}

	/**
	 * 计算两个时间差
	 * 
	 * @Title: calculateTimeDiff
	 * @Description: TODO
	 * @param first
	 *            第一个时间
	 * @param second
	 *            第二个时间，被减时间
	 * @param type
	 *            计算类型<br>
	 *            day:日，hour:时，minute:分，second:秒，millisecond:毫秒，其他默认毫秒
	 * @return int
	 */
	public final static long calculateTimeDiff(Date first, Date second,
			String type) {
		// 设置时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(first);
		long timeMillis1 = cal.getTimeInMillis();
		cal.setTime(second);
		long timeMillis2 = cal.getTimeInMillis();

		long diff = 0;
		if ("day".equals(type)) {
			diff = (timeMillis1 - timeMillis2) / (24 * 60 * 60 * 1000);
		} else if ("hour".equals(type)) {
			diff = (timeMillis1 - timeMillis2) / (60 * 60 * 1000);
		} else if ("minute".equals(type)) {
			diff = (timeMillis1 - timeMillis2) / (60 * 1000);
		} else if ("second".equals(type)) {
			diff = (timeMillis1 - timeMillis2) / (1000);
		} else {
			diff = (timeMillis1 - timeMillis2) / (1000);
		}

		return diff;
	}

	/**
	 * 计算某个时间是否在2个时间段之间（包含开始时间和结束时间）
	 * 
	 * @Title: calculateTimeDiff
	 * @Description: TODO
	 * @param first
	 *            第一个时间，开始时间(小)
	 * @param second
	 *            第二个时间，结束时间(大)
	 * @param diff
	 *            第三个时间，判断时间(中间)
	 * @return boolean
	 */
	public final static boolean calculateTimeIn(Date first, Date second,
			Date diff) {
		// 设置时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(first);
		long timeMillis1 = cal.getTimeInMillis();
		cal.setTime(second);
		long timeMillis2 = cal.getTimeInMillis();

		cal.setTime(diff);
		long timeMillis3 = cal.getTimeInMillis();

		if (timeMillis1 <= timeMillis3 && timeMillis2 >= timeMillis3) {
			return true;
		} else {
			return false;
		}
	}

	
	//需要配置<bean id = "SpringContextUtil" class = "com.tjekuaitong.uitls.SpringContextUtil"/>
	/*需要这个方法然后在spring.xml配置上面的
	 * package com.tjekuaitong.uitls;

	import org.springframework.beans.BeansException;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.ApplicationContextAware;
	import org.springframework.stereotype.Component;

	*//** 
	 * 获取spring容器，以访问容器中定义的其他bean 
	 *//*  
	@Component
	public class SpringContextUtil implements ApplicationContextAware {

	         private static ApplicationContext applicationContext; // Spring应用上下文环境

	         
	          * 实现了ApplicationContextAware 接口，必须实现该方法；
	          *通过传递applicationContext参数初始化成员变量applicationContext
	          
	         @Override
	         public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	               SpringContextUtil.applicationContext = applicationContext;
	         }

	         public static ApplicationContext getApplicationContext() {
	                return applicationContext;
	         }

	          public static Object getBean(String name) throws BeansException {
	                     return applicationContext.getBean(name);
	           }

	}*/
	/**
	 * 从Spring容器取组件
	 * 
	 * @param name
	 *            组件名称
	 * @return
	 * @add_by:Juno.Guan
	 * @date:2015年1月13日 下午12:12:26
	 * 需要配置上面的东西才能用
	 */
	public final static Object getBean(String name) {
		return SpringContextUtil.getBean(name);
	}

	/**
	 * 对传入的日期对象，设置其当天的时分秒为00:00:00:000
	 * 
	 * @param d
	 *            日期
	 * @return 时分秒为00:00:00 的Calendar 对象
	 * @add_by:Juno.Guan
	 * @date:2014年12月15日 上午11:34:59
	 */
	public final static Calendar getDayZeroTimeForCal(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return setDayZeroTimeForCal(cal);
	}

	/**
	 * 获取N个区域后的0点时间
	 * 
	 * @param d
	 * @param field
	 *            Calendar.DAY_OF_YEAR等
	 * @param n
	 *            N
	 * @return
	 */
	public final static Calendar getNDayZeroTimeForCal(Date d, int field, int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, n);
		cal.setTime(d);
		return setDayZeroTimeForCal(cal);
	}

	/**
	 * 设置时间为一天的零极值
	 * 
	 * @param cal
	 * @return
	 */
	public final static Calendar setDayZeroTimeForCal(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	/**
	 * 设置时间为一天的极值
	 * 
	 * @param cal
	 * @return
	 */
	public final static Calendar setDayTwentyfourTimeForCal(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal;
	}

	/**
	 * 对传入的日期对象，设置其当天的时分秒为23:59:59:999
	 * 
	 * @param d
	 *            日期
	 * @return 时分秒为23:59:59:999 的Calendar 对象
	 * @add_by:Juno.Guan
	 * @date:2014年12月15日 上午11:34:59
	 */
	private final static Calendar getDayTwentyfourTimeForCal(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return setDayTwentyfourTimeForCal(cal);
	}

	/**
	 * 获取今天00:00:00:000 的cal对象
	 * 
	 * @return
	 * @add_by:Juno.Guan
	 * @date:2014年12月15日 上午11:37:17
	 */
	public final static Calendar getTodayZeroTimeForCal() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	/**
	 * 获取今天00:00:00:000
	 */
	public final static Date getThisHourZeroForDate() {
		return getThisHourZeroForCal().getTime();
	}

	/**
	 * 获取当前小时的零值 的cal对象
	 * 
	 * @return
	 * @add_by:Juno.Guan
	 * @date:2014年12月15日 上午11:37:17
	 */
	public final static Calendar getThisHourZeroForCal() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	/**
	 * 对传入的日期对象，设置其当天的时分秒为00:00:00:000
	 */
	public final static long getDayZeroTimeForLong(Date d) {
		return getDayZeroTimeForCal(d).getTimeInMillis();
	}

	/**
	 * 对传入的日期对象，设置其当天的时分秒为00:00:00:000
	 */
	public final static Date getDayZeroTimeForDate(Date d) {
		return getDayZeroTimeForCal(d).getTime();
	}

	/**
	 * 对传入的日期对象，设置其当天的时分秒为00:00:00:000
	 */
	public final static Date getNDayZeroTimeForDate(Date d, int field, int n) {
		return getNDayZeroTimeForCal(d, field, n).getTime();
	}

	/**
	 * 对传入的日期对象，设置其当天的时分秒为23:59:59:999
	 */
	public final static long getDayTwentyfourTimeForLong(Date d) {
		return getDayTwentyfourTimeForCal(d).getTimeInMillis();
	}

	/**
	 * 对传入的日期对象，设置其当天的时分秒为23:59:59:999
	 */
	public final static Date getDayTwentyfourTimeForDate(Date d) {
		return getDayTwentyfourTimeForCal(d).getTime();
	}

	/**
	 * 获取今天00:00:00:000
	 */
	public final static long getTodayZeroTimeForLong() {
		return getTodayZeroTimeForCal().getTimeInMillis();
	}

	/**
	 * 获取今天00:00:00:000
	 */
	public final static Date getTodayZeroTimeForDate() {
		return getTodayZeroTimeForCal().getTime();
	}

	/**
	 * 判断两天是否为同一天
	 */
	public final static boolean isSameDate(Date d1, Date d2) {
		return DateUtils.isSameDay(d1, d2);
	}

	/**
	 * 将秒数转成 HH:MM:SS格式的字符串
	 * 
	 * @param seconds
	 * @return
	 * @add_by:Juno.Guan
	 * @date:2014年9月16日 下午5:12:05
	 */
	public final static String secondToTimeStr(long seconds) {
		long hours = seconds / 3600;
		long tmps = seconds % 3600;
		long mins = tmps / 60;
		long second = 0;
		if (mins == 0)
			second = tmps;
		else
			second = tmps % 60;
		return (hours < 10 ? ("0" + hours) : hours) + ":"
				+ (mins < 10 ? ("0" + mins) : mins) + ":"
				+ (second < 10 ? ("0" + second) : second);
	}

	/**
	 * 将两个日期对象转成 连接字符串，同一日则合并日期，非同一天，直接拼接
	 * 
	 * @param d1
	 *            开始日期
	 * @param d2
	 *            结束日期
	 * @return
	 * @add_by:Juno.Guan
	 * @date:2014年9月16日 下午5:24:08
	 */
	public final static String twoDateToStr(Date d1, Date d2) {
		if (isSameDate(d1, d2))
			return dateToString(d1, "yyyy-MM-dd   HH:mm:ss") + " - "
					+ dateToString(d2, "HH:mm:ss");
		else
			return dateToString(d1, "yyyy-MM-dd HH:mm:ss") + " - "
					+ dateToString(d2, "yyyy-MM-dd HH:mm:ss");

	}

	private final static Date setSameDay(Calendar cal, Date d1, Date d2) {
		// Calendar c = Calendar.getInstance();
		cal.setTime(d2);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(d1);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_YEAR, day);
		return cal.getTime();
	}

	/**
	 * 针对日期类型事件判断是否在时间范围内
	 * 
	 * @param s
	 *            范围开始时间
	 * @param e
	 *            范围结束时间
	 * @param time
	 *            校验的时间
	 * @return
	 */
	public final static boolean inRange(Date s, Date e, Date time) {
		return s.compareTo(time) <= 0 && e.compareTo(time) >= 0;
	}

	/**
	 * 判断cal time 是否在s-e范围内
	 * 
	 * @param s
	 * @param e
	 * @param time
	 * @return
	 * @add_by:Juno.Guan
	 * @date:2015年1月13日 上午11:27:30
	 */
	public final static boolean inRange(Calendar s, Calendar e, Calendar time) {
		return s.compareTo(time) <= 0 && e.compareTo(time) >= 0;
	}

	/**
	 * 针对时分秒校验是否在区间范围内
	 * 
	 * @param s
	 *            范围开始时间
	 * @param e
	 *            范围结束时间
	 * @param time
	 *            校验的时间
	 * @return
	 */
	public final static boolean inRangeTimeOnly(Date s, Date e, Date time) {
		Calendar cal = Calendar.getInstance();
		return CommonUtils.inRange(setSameDay(cal, s, time),
				setSameDay(cal, e, time), time);
	}

	/**
	 * 
	 * @Title: isConnect
	 * @Description: 功能：检测当前URL是否可连接或是否有效
	 * @Description: 已加锁，只能单线程运行调用
	 * @param @param urlStr 指定URL网络地址
	 * @return int HTTP状态码(200)-正常访问，(404)-资源不存在，(500)–服务器错误，(-1)-URL无效
	 * @author Tyrone.Li
	 * @throws
	 */
	public synchronized static int isConnect(String urlStr) {
		URL url;
		HttpURLConnection con;
		// 返回页面代码
		int state = -1;
		// 如果传递进来的URL为空或者长度为0，则无效
		if (urlStr == null || urlStr.length() <= 0) {
			return state;
		}
		try {
			url = new URL(urlStr);
			con = (HttpURLConnection) url.openConnection();
			// 设置连接主机超时
			con.setConnectTimeout(5000);
			// 设置从主机读取数据超时
			con.setReadTimeout(5000);
			state = con.getResponseCode();
		} catch (Exception ex) {
		}
		return state;
	}

	/**
	 * Ping IP地址
	 * 
	 * @Title: ping
	 * @Description: 当返回值是true时，说明host是可用的，false则不可。
	 * @param ipAddress
	 *            IP地址
	 * @param timeOut
	 *            超时毫秒
	 * @return
	 * @throws Exception
	 *             boolean
	 */
	public synchronized static boolean ping(String ipAddress, int timeOut)
			throws Exception {
		boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);
		return status;
	}

	/**
	 * 
	 * @Title: isPing
	 * @Description: 功能：检测当前Ip地址和端口是否可连接或是否有效
	 * @param ip
	 * @param port
	 * @param timeOut
	 *            超时时间(毫秒)
	 * @return boolean 是否能连通
	 * @author Tyrone.Li
	 * @throws
	 */
	public static boolean isPing(String ip, int port, int timeOut) {
		boolean status = false;
		Socket connect = new Socket();
		try {
			connect.connect(new InetSocketAddress(ip, port), timeOut);
			boolean res = connect.isConnected();
			if (res)
				status = true;
		} catch (IOException e) {
			// e.printStackTrace();
		} finally {
			try {
				connect.close();
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
		return status;
	}

	/**
	 * 获取包含数字字母4位随机数
	 * 
	 * @return
	 */
	public static String get4RandomNumber() {

		String[] beforeShuffle = new String[] { "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z" };

		List<String> list = Arrays.asList(beforeShuffle);

		Collections.shuffle(list);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {

			sb.append(list.get(i));
		}

		String afterShuffle = sb.toString();
		String result = afterShuffle.substring(5, 9);

		return result;
	}

	/**
	 * 获取包含数字字母10位随机数
	 * 
	 * @return
	 */
	public static String get10RandomNumber() {

		String[] beforeShuffle = new String[] { "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z" };

		List<String> list = Arrays.asList(beforeShuffle);

		Collections.shuffle(list);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}

		String afterShuffle = sb.toString();
		String result = afterShuffle.substring(0, 10);

		return result;
	}

	public static char getRandomCode() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return chars.charAt((int) (Math.random() * 26));
	}

	/**
	 * @Title: subAdd
	 * @Description: 字符串加减(末端必须未数字)
	 * @param String
	 *            str 字符串，最末端必须为数字
	 * @param int length 截取尾数(倒数多少位)
	 * @param int add 再原来基础加多少
	 * @return String 返回增加后的字符串
	 * @add_by:Tyrone.Li
	 */
	public static String subAdd(String str, int length, int add) {
		String substring = str.substring(str.length() - length, str.length());
		String format = "";
		for (int i = 0; i < length; i++) {
			format += "0";
		}
		DecimalFormat df = new DecimalFormat(format);
		String last = df.format(Integer.parseInt(substring) + add);
		String strReturn = str.substring(str.length() - str.length(),
				str.length() - length)
				+ last;
		return strReturn;
	}

	public static String getCronExp(Date time, int delay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.SECOND, delay);
		StringBuilder sb = new StringBuilder();
		sb.append(cal.get(Calendar.SECOND)).append(" ")
				.append(cal.get(Calendar.MINUTE)).append(" ")
				.append(cal.get(Calendar.HOUR_OF_DAY)).append(" ")
				.append(cal.get(Calendar.DAY_OF_MONTH)).append(" ")
				.append((cal.get(Calendar.MONTH) + 1)).append(" ? ")
				.append(cal.get(Calendar.YEAR));
		return sb.toString();
	}

	/**
	 * 字符串转换成long类型
	 * 
	 * @param String
	 * @return long
	 * @author Lan
	 */
	public final static long stringTolong(String longString) {
		return Long.valueOf(getStr(longString)).longValue();
	}

	/**
	 * 
	 * @Title: randomName
	 * @Description: 随机取名字
	 * @param simple
	 *            是否单姓
	 * @param len
	 *            生成姓名长度
	 * @return String 名字
	 * @author Tyrone.Li
	 */
	public static String randomName(boolean simple, int len) {
		String surName[] = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",
				"楮", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕",
				"施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢",
				"邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范",
				"彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任",
				"袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺",
				"倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于",
				"时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟",
				"平", "黄", "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛",
				"禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋",
				"茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮",
				"蓝", "闽", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童",
				"颜", "郭", "梅", "盛", "林", "刁", "锺", "徐", "丘", "骆", "高", "夏",
				"蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管",
				"卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣",
				"贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉",
				"钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊",
				"於", "惠", "甄", "麹", "家", "封", "芮", "羿", "储", "靳", "汲", "邴",
				"糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗",
				"山", "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲",
				"伊", "宫", "宁", "仇", "栾", "暴", "甘", "斜", "厉", "戎", "祖", "武",
				"符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎",
				"蓟", "薄", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸",
				"籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能",
				"苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申",
				"扶", "堵", "冉", "宰", "郦", "雍", "郤", "璩", "桑", "桂", "濮", "牛",
				"寿", "通", "边", "扈", "燕", "冀", "郏", "浦", "尚", "农", "温", "别",
				"庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾",
				"鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居",
				"衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄",
				"阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩",
				"厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简",
				"饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关",
				"蒯", "相", "查", "后", "荆", "红", "游", "竺", "权", "逑", "盖", "益",
				"桓", "公", "晋", "楚", "阎", "法", "汝", "鄢", "涂", "钦", "岳", "帅",
				"缑", "亢", "况", "后", "有", "琴", "商", "牟", "佘", "佴", "伯", "赏",
				"墨", "哈", "谯", "笪", "年", "爱", "阳", "佟" };

		String doubleSurName[] = { "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人",
				"东方", "赫连", "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政", "濮阳", "淳于",
				"单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "锺离", "宇文", "长孙",
				"慕容", "鲜于", "闾丘", "司徒", "司空", "丌官", "司寇", "仉", "督", "子车", "颛孙",
				"端木", "巫马", "公西", "漆雕", "乐正", "壤驷", "公良", "拓拔", "夹谷", "宰父",
				"谷梁", "段干", "百里", "东郭", "南门", "呼延", "归", "海", "羊舌", "微生", "梁丘",
				"左丘", "东门", "西门", "南宫" };

		String[] word = { "一", "乙", "二", "十", "丁", "厂", "七", "卜", "人", "入",
				"八", "九", "几", "儿", "了", "力", "乃", "刀", "又", "三", "于", "干",
				"亏", "士", "工", "土", "才", "寸", "下", "大", "丈", "与", "万", "上",
				"小", "口", "巾", "山", "千", "乞", "川", "亿", "个", "勺", "久", "凡",
				"及", "夕", "丸", "么", "广", "亡", "门", "义", "之", "尸", "弓", "己",
				"已", "子", "卫", "也", "女", "飞", "刃", "习", "叉", "马", "乡", "丰",
				"王", "井", "开", "夫", "天", "无", "元", "专", "云", "扎", "艺", "木",
				"五", "支", "厅", "不", "太", "犬", "区", "历", "尤", "友", "匹", "车",
				"巨", "牙", "屯", "比", "互", "切", "瓦", "止", "少", "日", "中", "冈",
				"贝", "内", "水", "见", "午", "牛", "手", "毛", "气", "升", "长", "仁",
				"什", "片", "仆", "化", "仇", "币", "仍", "仅", "斤", "爪", "反", "介",
				"父", "从", "今", "凶", "分", "乏", "公", "仓", "月", "氏", "勿", "欠",
				"风", "丹", "匀", "乌", "凤", "勾", "文", "六", "方", "火", "为", "斗",
				"忆", "订", "计", "户", "认", "心", "尺", "引", "丑", "巴", "孔", "队",
				"办", "以", "允", "予", "劝", "双", "书", "幻", "玉", "刊", "示", "末",
				"未", "击", "打", "巧", "正", "扑", "扒", "功", "扔", "去", "甘", "世",
				"古", "节", "本", "术", "可", "丙", "左", "厉", "右", "石", "布", "龙",
				"平", "灭", "轧", "东", "卡", "北", "占", "业", "旧", "帅", "归", "且",
				"旦", "目", "叶", "甲", "申", "叮", "电", "号", "田", "由", "史", "只",
				"央", "兄", "叼", "叫", "另", "叨", "叹", "四", "生", "失", "禾", "丘",
				"付", "仗", "代", "仙", "们", "仪", "白", "仔", "他", "斥", "瓜", "乎",
				"丛", "令", "用", "甩", "印", "乐", "句", "匆", "册", "犯", "外", "处",
				"冬", "鸟", "务", "包", "饥", "主", "市", "立", "闪", "兰", "半", "汁",
				"汇", "头", "汉", "宁", "穴", "它", "讨", "写", "让", "礼", "训", "必",
				"议", "讯", "记", "永", "司", "尼", "民", "出", "辽", "奶", "奴", "加",
				"召", "皮", "边", "发", "孕", "圣", "对", "台", "矛", "纠", "母", "幼",
				"丝", "式", "刑", "动", "扛", "寺", "吉", "扣", "考", "托", "老", "执",
				"巩", "圾", "扩", "扫", "地", "扬", "场", "耳", "共", "芒", "亚", "芝",
				"朽", "朴", "机", "权", "过", "臣", "再", "协", "西", "压", "厌", "在",
				"有", "百", "存", "而", "页", "匠", "夸", "夺", "灰", "达", "列", "死",
				"成", "夹", "轨", "邪", "划", "迈", "毕", "至", "此", "贞", "师", "尘",
				"尖", "劣", "光", "当", "早", "吐", "吓", "虫", "曲", "团", "同", "吊",
				"吃", "因", "吸", "吗", "屿", "帆", "岁", "回", "岂", "刚", "则", "肉",
				"网", "年", "朱", "先", "丢", "舌", "竹", "迁", "乔", "伟", "传", "乒",
				"乓", "休", "伍", "伏", "优", "伐", "延", "件", "任", "伤", "价", "份",
				"华", "仰", "仿", "伙", "伪", "自", "血", "向", "似", "后", "行", "舟",
				"全", "会", "杀", "合", "兆", "企", "众", "爷", "伞", "创", "肌", "朵",
				"杂", "危", "旬", "旨", "负", "各", "名", "多", "争", "色", "壮", "冲",
				"冰", "庄", "庆", "亦", "刘", "齐", "交", "次", "衣", "产", "决", "充",
				"妄", "闭", "问", "闯", "羊", "并", "关", "米", "灯", "州", "汗", "污",
				"江", "池", "汤", "忙", "兴", "宇", "守", "宅", "字", "安", "讲", "军",
				"许", "论", "农", "讽", "设", "访", "寻", "那", "迅", "尽", "导", "异",
				"孙", "阵", "阳", "收", "阶", "阴", "防", "奸", "如", "妇", "好", "她",
				"妈", "戏", "羽", "观", "欢", "买", "红", "纤", "级", "约", "纪", "驰",
				"巡", "寿", "弄", "麦", "形", "进", "戒", "吞", "远", "违", "运", "扶",
				"抚", "坛", "技", "坏", "扰", "拒", "找", "批", "扯", "址", "走", "抄",
				"坝", "贡", "攻", "赤", "折", "抓", "扮", "抢", "孝", "均", "抛", "投",
				"坟", "抗", "坑", "坊", "抖", "护", "壳", "志", "扭", "块", "声", "把",
				"报", "却", "劫", "芽", "花", "芹", "芬", "苍", "芳", "严", "芦", "劳",
				"克", "苏", "杆", "杠", "杜", "材", "村", "杏", "极", "李", "杨", "求",
				"更", "束", "豆", "两", "丽", "医", "辰", "励", "否", "还", "歼", "来",
				"连", "步", "坚", "旱", "盯", "呈", "时", "吴", "助", "县", "里", "呆",
				"园", "旷", "围", "呀", "吨", "足", "邮", "男", "困", "吵", "串", "员",
				"听", "吩", "吹", "呜", "吧", "吼", "别", "岗", "帐", "财", "针", "钉",
				"告", "我", "乱", "利", "秃", "秀", "私", "每", "兵", "估", "体", "何",
				"但", "伸", "作", "伯", "伶", "佣", "低", "你", "住", "位", "伴", "身",
				"皂", "佛", "近", "彻", "役", "返", "余", "希", "坐", "谷", "妥", "含",
				"邻", "岔", "肝", "肚", "肠", "龟", "免", "狂", "犹", "角", "删", "条",
				"卵", "岛", "迎", "饭", "饮", "系", "言", "冻", "状", "亩", "况", "床",
				"库", "疗", "应", "冷", "这", "序", "辛", "弃", "冶", "忘", "闲", "间",
				"闷", "判", "灶", "灿", "弟", "汪", "沙", "汽", "沃", "泛", "沟", "没",
				"沈", "沉", "怀", "忧", "快", "完", "宋", "宏", "牢", "究", "穷", "灾",
				"良", "证", "启", "评", "补", "初", "社", "识", "诉", "诊", "词", "译",
				"君", "灵", "即", "层", "尿", "尾", "迟", "局", "改", "张", "忌", "际",
				"陆", "阿", "陈", "阻", "附", "妙", "妖", "妨", "努", "忍", "劲", "鸡",
				"驱", "纯", "纱", "纳", "纲", "驳", "纵", "纷", "纸", "纹", "纺", "驴",
				"纽", "奉", "玩", "环", "武", "青", "责", "现", "表", "规", "抹", "拢",
				"拔", "拣", "担", "坦", "押", "抽", "拐", "拖", "拍", "者", "顶", "拆",
				"拥", "抵", "拘", "势", "抱", "垃", "拉", "拦", "拌", "幸", "招", "坡",
				"披", "拨", "择", "抬", "其", "取", "苦", "若", "茂", "苹", "苗", "英",
				"范", "直", "茄", "茎", "茅", "林", "枝", "杯", "柜", "析", "板", "松",
				"枪", "构", "杰", "述", "枕", "丧", "或", "画", "卧", "事", "刺", "枣",
				"雨", "卖", "矿", "码", "厕", "奔", "奇", "奋", "态", "欧", "垄", "妻",
				"轰", "顷", "转", "斩", "轮", "软", "到", "非", "叔", "肯", "齿", "些",
				"虎", "虏", "肾", "贤", "尚", "旺", "具", "果", "味", "昆", "国", "昌",
				"畅", "明", "易", "昂", "典", "固", "忠", "咐", "呼", "鸣", "咏", "呢",
				"岸", "岩", "帖", "罗", "帜", "岭", "凯", "败", "贩", "购", "图", "钓",
				"制", "知", "垂", "牧", "物", "乖", "刮", "秆", "和", "季", "委", "佳",
				"侍", "供", "使", "例", "版", "侄", "侦", "侧", "凭", "侨", "佩", "货",
				"依", "的", "迫", "质", "欣", "征", "往", "爬", "彼", "径", "所", "舍",
				"金", "命", "斧", "爸", "采", "受", "乳", "贪", "念", "贫", "肤", "肺",
				"肢", "肿", "胀", "朋", "股", "肥", "服", "胁", "周", "昏", "鱼", "兔",
				"狐", "忽", "狗", "备", "饰", "饱", "饲", "变", "京", "享", "店", "夜",
				"庙", "府", "底", "剂", "郊", "废", "净", "盲", "放", "刻", "育", "闸",
				"闹", "郑", "券", "卷", "单", "炒", "炊", "炕", "炎", "炉", "沫", "浅",
				"法", "泄", "河", "沾", "泪", "油", "泊", "沿", "泡", "注", "泻", "泳",
				"泥", "沸", "波", "泼", "泽", "治", "怖", "性", "怕", "怜", "怪", "学",
				"宝", "宗", "定", "宜", "审", "宙", "官", "空", "帘", "实", "试", "郎",
				"诗", "肩", "房", "诚", "衬", "衫", "视", "话", "诞", "询", "该", "详",
				"建", "肃", "录", "隶", "居", "届", "刷", "屈", "弦", "承", "孟", "孤",
				"陕", "降", "限", "妹", "姑", "姐", "姓", "始", "驾", "参", "艰", "线",
				"练", "组", "细", "驶", "织", "终", "驻", "驼", "绍", "经", "贯", "奏",
				"春", "帮", "珍", "玻", "毒", "型", "挂", "封", "持", "项", "垮", "挎",
				"城", "挠", "政", "赴", "赵", "挡", "挺", "括", "拴", "拾", "挑", "指",
				"垫", "挣", "挤", "拼", "挖", "按", "挥", "挪", "某", "甚", "革", "荐",
				"巷", "带", "草", "茧", "茶", "荒", "茫", "荡", "荣", "故", "胡", "南",
				"药", "标", "枯", "柄", "栋", "相", "查", "柏", "柳", "柱", "柿", "栏",
				"树", "要", "咸", "威", "歪", "研", "砖", "厘", "厚", "砌", "砍", "面",
				"耐", "耍", "牵", "残", "殃", "轻", "鸦", "皆", "背", "战", "点", "临",
				"览", "竖", "省", "削", "尝", "是", "盼", "眨", "哄", "显", "哑", "冒",
				"映", "星", "昨", "畏", "趴", "胃", "贵", "界", "虹", "虾", "蚁", "思",
				"蚂", "虽", "品", "咽", "骂", "哗", "咱", "响", "哈", "咬", "咳", "哪",
				"炭", "峡", "罚", "贱", "贴", "骨", "钞", "钟", "钢", "钥", "钩", "卸",
				"缸", "拜", "看", "矩", "怎", "牲", "选", "适", "秒", "香", "种", "秋",
				"科", "重", "复", "竿", "段", "便", "俩", "贷", "顺", "修", "保", "促",
				"侮", "俭", "俗", "俘", "信", "皇", "泉", "鬼", "侵", "追", "俊", "盾",
				"待", "律", "很", "须", "叙", "剑", "逃", "食", "盆", "胆", "胜", "胞",
				"胖", "脉", "勉", "狭", "狮", "独", "狡", "狱", "狠", "贸", "怨", "急",
				"饶", "蚀", "饺", "饼", "弯", "将", "奖", "哀", "亭", "亮", "度", "迹",
				"庭", "疮", "疯", "疫", "疤", "姿", "亲", "音", "帝", "施", "闻", "阀",
				"阁", "差", "养", "美", "姜", "叛", "送", "类", "迷", "前", "首", "逆",
				"总", "炼", "炸", "炮", "烂", "剃", "洁", "洪", "洒", "浇", "浊", "洞",
				"测", "洗", "活", "派", "洽", "染", "济", "洋", "洲", "浑", "浓", "津",
				"恒", "恢", "恰", "恼", "恨", "举", "觉", "宣", "室", "宫", "宪", "突",
				"穿", "窃", "客", "冠", "语", "扁", "袄", "祖", "神", "祝", "误", "诱",
				"说", "诵", "垦", "退", "既", "屋", "昼", "费", "陡", "眉", "孩", "除",
				"险", "院", "娃", "姥", "姨", "姻", "娇", "怒", "架", "贺", "盈", "勇",
				"怠", "柔", "垒", "绑", "绒", "结", "绕", "骄", "绘", "给", "络", "骆",
				"绝", "绞", "统", "耕", "耗", "艳", "泰", "珠", "班", "素", "蚕", "顽",
				"盏", "匪", "捞", "栽", "捕", "振", "载", "赶", "起", "盐", "捎", "捏",
				"埋", "捉", "捆", "捐", "损", "都", "哲", "逝", "捡", "换", "挽", "热",
				"恐", "壶", "挨", "耻", "耽", "恭", "莲", "莫", "荷", "获", "晋", "恶",
				"真", "框", "桂", "档", "桐", "株", "桥", "桃", "格", "校", "核", "样",
				"根", "索", "哥", "速", "逗", "栗", "配", "翅", "辱", "唇", "夏", "础",
				"破", "原", "套", "逐", "烈", "殊", "顾", "轿", "较", "顿", "毙", "致",
				"柴", "桌", "虑", "监", "紧", "党", "晒", "眠", "晓", "鸭", "晃", "晌",
				"晕", "蚊", "哨", "哭", "恩", "唤", "啊", "唉", "罢", "峰", "圆", "贼",
				"贿", "钱", "钳", "钻", "铁", "铃", "铅", "缺", "氧", "特", "牺", "造",
				"乘", "敌", "秤", "租", "积", "秧", "秩", "称", "秘", "透", "笔", "笑",
				"笋", "债", "借", "值", "倚", "倾", "倒", "倘", "俱", "倡", "候", "俯",
				"倍", "倦", "健", "臭", "射", "躬", "息", "徒", "徐", "舰", "舱", "般",
				"航", "途", "拿", "爹", "爱", "颂", "翁", "脆", "脂", "胸", "胳", "脏",
				"胶", "脑", "狸", "狼", "逢", "留", "皱", "饿", "恋", "桨", "浆", "衰",
				"高", "席", "准", "座", "脊", "症", "病", "疾", "疼", "疲", "效", "离",
				"唐", "资", "凉", "站", "剖", "竞", "部", "旁", "旅", "畜", "阅", "羞",
				"瓶", "拳", "粉", "料", "益", "兼", "烤", "烘", "烦", "烧", "烛", "烟",
				"递", "涛", "浙", "涝", "酒", "涉", "消", "浩", "海", "涂", "浴", "浮",
				"流", "润", "浪", "浸", "涨", "烫", "涌", "悟", "悄", "悔", "悦", "害",
				"宽", "家", "宵", "宴", "宾", "窄", "容", "宰", "案", "请", "朗", "诸",
				"读", "扇", "袜", "袖", "袍", "被", "祥", "课", "谁", "调", "冤", "谅",
				"谈", "谊", "剥", "恳", "展", "剧", "屑", "弱", "陵", "陶", "陷", "陪",
				"娱", "娘", "通", "能", "难", "预", "桑", "绢", "绣", "验", "继", "球",
				"理", "捧", "堵", "描", "域", "掩", "捷", "排", "掉", "堆", "推", "掀",
				"授", "教", "掏", "掠", "培", "接", "控", "探", "据", "掘", "职", "基",
				"著", "勒", "黄", "萌", "萝", "菌", "菜", "萄", "菊", "萍", "菠", "营",
				"械", "梦", "梢", "梅", "检", "梳", "梯", "桶", "救", "副", "票", "戚",
				"爽", "聋", "袭", "盛", "雪", "辅", "辆", "虚", "雀", "堂", "常", "匙",
				"晨", "睁", "眯", "眼", "悬", "野", "啦", "晚", "啄", "距", "跃", "略",
				"蛇", "累", "唱", "患", "唯", "崖", "崭", "崇", "圈", "铜", "铲", "银",
				"甜", "梨", "犁", "移", "笨", "笼", "笛", "符", "第", "敏", "做", "袋",
				"悠", "偿", "偶", "偷", "您", "售", "停", "偏", "假", "得", "衔", "盘",
				"船", "斜", "盒", "鸽", "悉", "欲", "彩", "领", "脚", "脖", "脸", "脱",
				"象", "够", "猜", "猪", "猎", "猫", "猛", "馅", "馆", "凑", "减", "毫",
				"麻", "痒", "痕", "廊", "康", "庸", "鹿", "盗", "章", "竟", "商", "族",
				"旋", "望", "率", "着", "盖", "粘", "粗", "粒", "断", "剪", "兽", "清",
				"添", "淋", "淹", "渠", "渐", "混", "渔", "淘", "液", "淡", "深", "婆",
				"梁", "渗", "情", "惜", "惭", "悼", "惧", "惕", "惊", "惨", "惯", "寇",
				"寄", "宿", "窑", "密", "谋", "谎", "祸", "谜", "逮", "敢", "屠", "弹",
				"随", "蛋", "隆", "隐", "婚", "婶", "颈", "绩", "绪", "续", "骑", "绳",
				"维", "绵", "绸", "绿", "琴", "斑", "替", "款", "堪", "搭", "塔", "越",
				"趁", "趋", "超", "提", "堤", "博", "揭", "喜", "插", "揪", "搜", "煮",
				"援", "裁", "搁", "搂", "搅", "握", "揉", "斯", "期", "欺", "联", "散",
				"惹", "葬", "葛", "董", "葡", "敬", "葱", "落", "朝", "辜", "葵", "棒",
				"棋", "植", "森", "椅", "椒", "棵", "棍", "棉", "棚", "棕", "惠", "惑",
				"逼", "厨", "厦", "硬", "确", "雁", "殖", "裂", "雄", "暂", "雅", "辈",
				"悲", "紫", "辉", "敞", "赏", "掌", "晴", "暑", "最", "量", "喷", "晶",
				"喇", "遇", "喊", "景", "践", "跌", "跑", "遗", "蛙", "蛛", "蜓", "喝",
				"喂", "喘", "喉", "幅", "帽", "赌", "赔", "黑", "铸", "铺", "链", "销",
				"锁", "锄", "锅", "锈", "锋", "锐", "短", "智", "毯", "鹅", "剩", "稍",
				"程", "稀", "税", "筐", "等", "筑", "策", "筛", "筒", "答", "筋", "筝",
				"傲", "傅", "牌", "堡", "集", "焦", "傍", "储", "奥", "街", "惩", "御",
				"循", "艇", "舒", "番", "释", "禽", "腊", "脾", "腔", "鲁", "猾", "猴",
				"然", "馋", "装", "蛮", "就", "痛", "童", "阔", "善", "羡", "普", "粪",
				"尊", "道", "曾", "焰", "港", "湖", "渣", "湿", "温", "渴", "滑", "湾",
				"渡", "游", "滋", "溉", "愤", "慌", "惰", "愧", "愉", "慨", "割", "寒",
				"富", "窜", "窝", "窗", "遍", "裕", "裤", "裙", "谢", "谣", "谦", "属",
				"屡", "强", "粥", "疏", "隔", "隙", "絮", "嫂", "登", "缎", "缓", "编",
				"骗", "缘", "瑞", "魂", "肆", "摄", "摸", "填", "搏", "塌", "鼓", "摆",
				"携", "搬", "摇", "搞", "塘", "摊", "蒜", "勤", "鹊", "蓝", "墓", "幕",
				"蓬", "蓄", "蒙", "蒸", "献", "禁", "楚", "想", "槐", "榆", "楼", "概",
				"赖", "酬", "感", "碍", "碑", "碎", "碰", "碗", "碌", "雷", "零", "雾",
				"雹", "输", "督", "龄", "鉴", "睛", "睡", "睬", "鄙", "愚", "暖", "盟",
				"歇", "暗", "照", "跨", "跳", "跪", "路", "跟", "遣", "蛾", "蜂", "嗓",
				"置", "罪", "罩", "错", "锡", "锣", "锤", "锦", "键", "锯", "矮", "辞",
				"稠", "愁", "筹", "签", "简", "毁", "舅", "鼠", "催", "傻", "像", "躲",
				"微", "愈", "遥", "腰", "腥", "腹", "腾", "腿", "触", "解", "酱", "痰",
				"廉", "新", "韵", "意", "粮", "数", "煎", "塑", "慈", "煤", "煌", "满",
				"漠", "源", "滤", "滥", "滔", "溪", "溜", "滚", "滨", "粱", "滩", "慎",
				"誉", "塞", "谨", "福", "群", "殿", "辟", "障", "嫌", "嫁", "叠", "缝",
				"缠", "静", "碧", "璃", "墙", "撇", "嘉", "摧", "截", "誓", "境", "摘",
				"摔", "聚", "蔽", "慕", "暮", "蔑", "模", "榴", "榜", "榨", "歌", "遭",
				"酷", "酿", "酸", "磁", "愿", "需", "弊", "裳", "颗", "嗽", "蜻", "蜡",
				"蝇", "蜘", "赚", "锹", "锻", "舞", "稳", "算", "箩", "管", "僚", "鼻",
				"魄", "貌", "膜", "膊", "膀", "鲜", "疑", "馒", "裹", "敲", "豪", "膏",
				"遮", "腐", "瘦", "辣", "竭", "端", "旗", "精", "歉", "熄", "熔", "漆",
				"漂", "漫", "滴", "演", "漏", "慢", "寨", "赛", "察", "蜜", "谱", "嫩",
				"翠", "熊", "凳", "骡", "缩", "慧", "撕", "撒", "趣", "趟", "撑", "播",
				"撞", "撤", "增", "聪", "鞋", "蕉", "蔬", "横", "槽", "樱", "橡", "飘",
				"醋", "醉", "震", "霉", "瞒", "题", "暴", "瞎", "影", "踢", "踏", "踩",
				"踪", "蝶", "蝴", "嘱", "墨", "镇", "靠", "稻", "黎", "稿", "稼", "箱",
				"箭", "篇", "僵", "躺", "僻", "德", "艘", "膝", "膛", "熟", "摩", "颜",
				"毅", "糊", "遵", "潜", "潮", "懂", "额", "慰", "劈", "操", "燕", "薯",
				"薪", "薄", "颠", "橘", "整", "融", "醒", "餐", "嘴", "蹄", "器", "赠",
				"默", "镜", "赞", "篮", "邀", "衡", "膨", "雕", "磨", "凝", "辨", "辩",
				"糖", "糕", "燃", "澡", "激", "懒", "壁", "避", "缴", "戴", "擦", "鞠",
				"藏", "霜", "霞", "瞧", "蹈", "螺", "穗", "繁", "辫", "赢", "糟", "糠",
				"燥", "臂", "翼", "骤", "鞭", "覆", "蹦", "镰", "翻", "鹰", "警", "攀",
				"蹲", "颤", "瓣", "爆", "疆", "壤", "耀", "躁", "嚼", "嚷", "籍", "魔",
				"灌", "蠢", "霸", "露", "囊", "罐" };

		int surNameLen = surName.length;
		int doubleSurNameLen = doubleSurName.length;
		int wordLen = word.length;

		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		if (simple) {
			sb.append(surName[random.nextInt(surNameLen)]);
			int surLen = sb.toString().length();
			for (int i = 0; i < len - surLen; i++) {
				if (sb.toString().length() <= len) {
					sb.append(word[random.nextInt(wordLen)]);
				}
			}
		} else {
			sb.append(doubleSurName[random.nextInt(doubleSurNameLen)]);
			int doubleSurLen = sb.toString().length();
			for (int i = 0; i < len - doubleSurLen; i++) {
				if (sb.toString().length() <= len) {
					sb.append(word[random.nextInt(wordLen)]);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 下载远程文件并保存到本地
	 * 
	 * @param remoteFilePath
	 *            远程文件路径
	 * @param localFilePath
	 *            本地文件路径
	 */
	public static void downloadFile(String remoteFilePath, String localFilePath) {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File f = new File(localFilePath);
		try {
			urlfile = new URL(remoteFilePath);
			httpUrl = (HttpURLConnection) urlfile.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			bis.close();
			httpUrl.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取本机所有IP地址
	 * 
	 * @Title: getAllLocalIP
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 *             ArrayList<String>
	 */
	public static ArrayList<String> getAllLocalIP() throws Exception {
		ArrayList<String> ar = new ArrayList<String>();
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface
				.getNetworkInterfaces();
		while (netInterfaces.hasMoreElements()) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> inetAddress = ni.getInetAddresses();
			while (inetAddress.hasMoreElements()) {
				InetAddress ip = inetAddress.nextElement();
				if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
						&& ip.getHostAddress().indexOf(":") == -1) {
					System.out
							.println("Interface "
									+ ni.getName()
									+ " seems to be InternetInterface. I'll take it...");
				} else {
					ar.add(ip.getHostAddress());
				}
			}
		}
		return ar;
	}

	/**
	 * 打印List<Map<String,Object>>
	 * 
	 * @author Lan
	 */
	public static void printList(List<Map<String, Object>> list) {
		System.out.println(">>>>>> 打印List" + list.hashCode() + "(大小："
				+ list.size() + ",类型：" + list.getClass() + ")");
		System.out.println("----------------起-----------------");
		if (list == null || list.isEmpty()) {
			System.out.println("list is null!");
		} else {
			int i = 1;
			for (Map<String, Object> map : list) {
				System.out.println(" 第" + i + "行");
				for (String key : map.keySet()) {
					System.out.print(key + ":" + map.get(key) + "\t");
				}
				System.out.println();
			}
		}
		System.out.println("-----------------止------------------");

	}

	/**
	 * 格式化为指定位小数的数字,返回未使用科学计数法表示的具有指定位数的字符串。
	 * 该方法舍入模式：向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。
	 * 
	 * <pre>
	 *  "3.1415926", 1          --> 3.1 
	 *  "3.1415926", 3          --> 3.142 
	 *  "3.1415926", 4          --> 3.1416 
	 *  "3.1415926", 6          --> 3.141593 
	 *  "1234567891234567.1415926", 3   --> 1234567891234567.142
	 * </pre>
	 * 
	 * @param String类型的数字对象
	 * @param precision
	 *            小数精确度总位数,如2表示两位小数
	 * @return 返回数字格式化后的字符串表示形式(注意返回的字符串未使用科学计数法)
	 */
	public static String keepPrecision(String number, int precision) {
		BigDecimal bg = new BigDecimal(number);
		return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).toPlainString();
	}

	/**
	 * 格式化为指定位小数的数字,返回未使用科学计数法表示的具有指定位数的字符串。<br>
	 * 该方法舍入模式：向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。<br>
	 * 如果给定的数字没有小数，则转换之后将以0填充；例如：int 123 1 --> 123.0<br>
	 * <b>注意：</b>如果精度要求比较精确请使用 keepPrecision(String number, int precision)方法
	 * 
	 * @param String类型的数字对象
	 * @param precision
	 *            小数精确度总位数,如2表示两位小数
	 * @return 返回数字格式化后的字符串表示形式(注意返回的字符串未使用科学计数法)
	 */
	public static String keepPrecision(Number number, int precision) {
		return keepPrecision(String.valueOf(number), precision);
	}

	/**
	 * 对double类型的数值保留指定位数的小数。<br>
	 * 该方法舍入模式：向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。<br>
	 * <b>注意：</b>如果精度要求比较精确请使用 keepPrecision(String number, int precision)方法
	 * 
	 * @param number
	 *            要保留小数的数字
	 * @param precision
	 *            小数位数
	 * @return double 如果数值较大，则使用科学计数法表示
	 */
	public static double keepPrecision(double number, int precision) {
		BigDecimal bg = new BigDecimal(number);
		return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 对float类型的数值保留指定位数的小数。<br>
	 * 该方法舍入模式：向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。<br>
	 * <b>注意：</b>如果精度要求比较精确请使用 keepPrecision(String number, int precision)方法
	 * 
	 * @param number
	 *            要保留小数的数字
	 * @param precision
	 *            小数位数
	 * @return float 如果数值较大，则使用科学计数法表示
	 */
	public static float keepPrecision(float number, int precision) {
		BigDecimal bg = new BigDecimal(number);
		return bg.setScale(precision, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	public static String getNumberStr(double num, int precision) {
		if (num % 1.0 == 0) {
			return String.valueOf((long) num);
		}
		return keepPrecision(String.valueOf(num), precision);
	}

	// 四舍五入
	public static double strToDouble(String number, int precision) {
		double dbValue = -999;
		try {
			BigDecimal bg = new BigDecimal(number);
			dbValue = bg.setScale(precision, BigDecimal.ROUND_HALF_UP)
					.doubleValue();
		} catch (NumberFormatException e) {
			System.err.println("NumberFormatException异常，字符串格式有误！");
			return dbValue;
		}
		return dbValue;

	}

	// 保存二进制图片到工程目录下
	//需要配置静态资源<mvc:resources location="/bicths/" mapping="/bicths/**"/>
	public static String SAVEBYTES(String photo_path, String identity)
			throws IOException {
		// 存二进制图片
		String c = URLDecoder.decode(CommonUtils.class.getResource("/")
				.getPath());
		String pp = c.substring(1, c.lastIndexOf("WEB-INF"));
		JSONObject json1 = JSON.parseObject(photo_path);
		Iterator it = json1.keySet().iterator();
		String path = "";
		// 遍历jsonObject数据，
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = String.valueOf(json1.get(key));
			byte[] photo1 = new BASE64Decoder().decodeBuffer(value);
			String usefulpath = "bicths/" + identity + "/"
					+ get10RandomNumber() + ".jpg";
			String tagfile = pp + usefulpath;
			CommonUtils.saveToFile(photo1, tagfile);
			path = path + ";" + usefulpath;
		}
		return path;
	}

	// 通过时间戳获取唯一订单号
	public static String Obtain_num(String date) {
		String[] str = date.split(" ");
		String[] big = str[0].split("-");
		String[] small = str[1].split(":");

		String num = "";
		for (String str1 : big) {
			num += str1;
		}
		for (String str1 : small) {
			num += str1;
		}
		return num;
	}

	// 保存字节流到目标文件
	public static void saveToFile(byte[] bt, String filePath) {
		OutputStream os = null;
		String path_base = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		System.out.println("基本路径" + path_base);
		try {
			File base_file = new File(path_base);
			if (!base_file.exists()) {
				base_file.mkdirs();

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		try {
			os = new FileOutputStream(filePath);
			os.write(bt);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}

	// 字符串文件到字符传文件
	public static void SSUPLOAD(String source, String target) throws Exception {

		File file = new File(target);
		if (!file.exists()) {
			file.mkdirs();
		}
		java.io.InputStream is = new java.io.FileInputStream(source);
		java.io.OutputStream os = new java.io.FileOutputStream(target
				+ source.substring(source.lastIndexOf("/")));
		byte buffer[] = new byte[8 * 2097152];
		int count = 0;
		while ((count = is.read(buffer)) > 0) {
			os.write(buffer, 0, count);
		}

		os.close();
		is.close();

	}
	//需要配置静态资源<mvc:resources location="/bicths/" mapping="/bicths/**"/>
	// 普通file源文件到目标文件
	public static String FSUPLOAD(File source, String identity,
			String targetfile) throws Exception { // 存源文件
		String c = URLDecoder.decode(CommonUtils.class.getResource("/")
				.getPath());
		String pp = c.substring(1, c.lastIndexOf("WEB-INF"));

		String usefulpath = "bicths/" + identity + "/" + get10RandomNumber()
				+ "-" + targetfile;
		String tagfile = pp + usefulpath;

		java.io.InputStream is = new java.io.FileInputStream(source);
		java.io.OutputStream os = new java.io.FileOutputStream(tagfile);
		byte buffer[] = new byte[31 * 1024 * 1024];
		int count = 0;
		while ((count = is.read(buffer)) > 0) {
			os.write(buffer, 0, count);
		}

		os.close();
		is.close();

		return usefulpath;
	}

	// Spring MVC MultipartFile源文件到目标文件
	public static String MVCFILE(MultipartFile source, String identity)
			throws Exception { // 存源文件
		String c = URLDecoder.decode(CommonUtils.class.getResource("/")
				.getPath());
		String pp = c.substring(1, c.lastIndexOf("WEB-INF"));

		String usefulpath = "bicths/" + identity + "/" + get10RandomNumber()
				+ "-" + source.getOriginalFilename();
		String tagfile = pp + usefulpath;
		SaveFileInputStream(source.getInputStream(), tagfile);
		return usefulpath;

	}

	// Spring MVC MultipartFile源文件流到目标文件
	//需要配置静态资源<mvc:resources location="/bicths/" mapping="/bicths/**"/>
	public static String MVCTREAM(MultipartRequest request, String identity)
			throws Exception { // 存源文件流
		String c = URLDecoder.decode(CommonUtils.class.getResource("/")
				.getPath());
		String pp = c.substring(1, c.lastIndexOf("WEB-INF"));

		String path = "";
		// 获取多个file
		for (Iterator it = request.getFileNames(); it.hasNext();) {
			String key = (String) it.next();
			MultipartFile imgFile = request.getFile(key);
			String usefulpath = "bicths/" + identity + "/"
					+ get10RandomNumber() + "-" + imgFile.getOriginalFilename();
			String tagfile = pp + usefulpath;
			SaveFileInputStream(imgFile.getInputStream(), tagfile);
			path = path + ";" + usefulpath;
		}
		return path;
	}

	// 传输文件流存储
	public static void SaveFileInputStream(InputStream steam, String filePath)
			throws Exception {
		String path_base = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		File file = new File(path_base);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileOutputStream fs = new FileOutputStream(filePath);
		byte[] buffer = new byte[31 * 1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = steam.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		steam.close();
	}

	/**
	 * 
	 * @param phone_num
	 *            获取手机号发送验证码
	 * @return Map { gener_time:验证码生成时间， vilidat_num:随机生成的整型验证码，
	 *         entity：短信发送返回后的状态}
	 */
	public static Map<String, Object> sendCodeMod(String phone_num) {
		int validat_num = 0;
		HttpEntity entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		// 1，获取3分钟后的时间
		Date date = new Date();
		date = new Date(date.getTime() + 3 * 60 * 1000);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		map.put("gener_time", time);
		// 2，随机生成验证码
		Random random = new Random();
		while (validat_num < 100000) {
			validat_num = random.nextInt(999999);
		}
		map.put("validat_num", validat_num);
		// 3，调用短信接口，发送验证码
		String path = "http://dx.ipyy.net/sms.aspx?action=send&userid=5433&account=AA00257&password=AA00257038&mobile="
				+ phone_num
				+ "&content=您的验证码是"
				+ validat_num
				+ "，三分钟内有效。【安鑫一家】&sendTime=&extno=";
		@SuppressWarnings("deprecation")
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(path);
		HttpResponse response1 = null;
		System.out.println("==========");
		try {
			response1 = httpclient.execute(httpget);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		entity = response1.getEntity();
		map.put("entity", entity);
		System.out.println(map.toString());
		return map;

	}

	/**
	 * 
	 * @param phone_num
	 *            发送信息的号码
	 * @param content
	 *            发送信息的 内容
	 * @return status 信息发送的状态 1：发送成功， 0：发送失败
	 */
	public static int sendMessage(String phone_num, String content) {
		int status = 0;
		HttpEntity entity = null;
		// 3，调用短信接口，发送 信息
		String path = "http://dx.ipyy.net/sms.aspx?action=send&userid=5433&account=AA00257&password=AA00257038&mobile="
				+ phone_num + "&content=" + content + "【安鑫一家】&sendTime=&extno=";
		@SuppressWarnings("deprecation")
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(path);
		HttpResponse response1 = null;
		System.out.println("==========");
		try {
			response1 = httpclient.execute(httpget);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		entity = response1.getEntity();
		if (entity != null) {
			status = 1;
		}

		return status;
	}

	// trimWhere()去除多余的Where和and
	public String trimWhere(String wheresql) {
		if (wheresql.trim().equals("")) {
			return " ";
		} else {
			String s = wheresql.trim();
			if (s.toUpperCase().startsWith("AND ")) {
				s = s.substring(3);
				return " where" + s + " ";
			} else {
				return " where " + s + " ";
			}

		}
	}

	// trimSet()去除多余的","
	public String trimSet(String setsql) {
		if (setsql.trim().equals("")) {
			return " ";
		} else {
			String s = setsql.trim();
			if (s.endsWith(",")) {
				s = s.substring(0, s.length() - 1);
				return " set " + s + " ";
			} else {
				return " set " + s + " ";
			}

		}
	}

	// trimParenthesis()去除括号内多余的逗号
	public String trimParenthesis(String setsql) {
		if (setsql.trim().equals("")) {
			return " ";
		} else {
			String s = setsql.trim();
			if (s.endsWith(",")) {
				s = s.substring(0, s.length() - 1);
				return " set " + s + " ";
			} else {
				return " set " + s + " ";
			}

		}
	}
	//傻1加密
	public static String getSha1(String str){
	    if (null == str || 0 == str.length()){
	        return null;
	    }
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	            'a', 'b', 'c', 'd', 'e', 'f'};
	    try {
	        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	        mdTemp.update(str.getBytes("UTF-8"));
	         
	        byte[] md = mdTemp.digest();
	        int j = md.length;
	        char[] buf = new char[j * 2];
	        int k = 0;
	        for (int i = 0; i < j; i++) {
	            byte byte0 = md[i];
	            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	            buf[k++] = hexDigits[byte0 & 0xf];
	        }
	        return new String(buf);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
		return null;
	}
}
