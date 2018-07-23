package com.tjekuaitong.uitls;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import com.tjekuaitong.entity.token.Image;
import com.tjekuaitong.entity.token.ImageMessage;
import com.tjekuaitong.entity.token.Music;
import com.tjekuaitong.entity.token.MusicMessage;
import com.tjekuaitong.entity.token.News;
import com.tjekuaitong.entity.token.NewsMessage;
import com.tjekuaitong.entity.token.TextMessage;


/**
 * 消息封装类
 * @author Stephen
 *
 */
public class MessageUtil {	
	//private NewsService newsService;
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE= "scancode_push";
	
	/**
	 * xml转为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		
		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	
	/**
	 * 将文本消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 组装文本消息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
	
	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作：\n\n");
		/*sb.append("1、课程介绍\n");
		sb.append("2、慕课网介绍\n");
		sb.append("3、词组翻译\n\n");
		sb.append("回复？调出此菜单。");*/
		return sb.toString();
	}
	
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作");
		return sb.toString();
	}
	
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作。");
		sb.append("欢迎您的关注，请按照菜单提示进行操作欢迎您的关注，请按照菜单提示进行操作欢迎您的关注，请按照菜单提示进行操作欢迎您的关注，请按照菜单提示进行操作欢迎您的关注，请按照菜单提示进行操作欢迎您的关注，请按照菜单提示进行操作。");
		return sb.toString();
	}
	
	public static String threeMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("词组翻译使用指南\n\n");
		sb.append("使用示例：\n");
		sb.append("翻译足球\n");
		sb.append("翻译中国足球\n");
		sb.append("翻译football\n\n");
		sb.append("回复？显示主菜单。");
		return sb.toString();
	}
	/**
	 * 图文消息转为xml
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new News().getClass());
		return xstream.toXML(newsMessage);
	}
	
	/**
	 * 图片消息转为xml
	 * @param imageMessage
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	/**
	 * 音乐消息转为xml
	 * @param musicMessage
	 * @return
	 */
	public static String musicMessageToXml(MusicMessage musicMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	/**
	 * 图文消息的组装1
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 *//*
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		NewsDao newsDao =new NewsDaoImpl();
		
		
		News news = new News();
		news.setTitle("公司简介");
		//news.setDescription("天津易快通科技有限公司成立于2012年，是一家在国家工商局注册许可经营的技术型公司，利用先进的互联网、通信、电子商务技术，自主研发了国内领先的便民交费电子商务平台，公司网站www.ekuaitong.com已在工信部完成ICP备案，通过整合社区周边的各种实体店铺（便利店、通信店、报刊亭、网吧等），建立了覆盖生活社区的便民服务网络。天津易快通科技有限公司以优越的技术实力与创新理念为盟店提供最优质的产品、最稳定的系统、最便捷的缴费、最安全的支付服务，帮助盟店搭建整合行业资源。其线下客户通过登录易快通科技旗下缴费网站和公众平台购买各种产品或服务，从而搭建自己的社区O2O营销圈，直接趋使客户盈利最大化。");
		news.setPicUrl("http://wx.tjaxej.com/tjekuaitong/images/jiaofei.jpg");
		news.setUrl("http://wx.tjaxej.com/tjekuaitong/call_center/company_profile.jsp");
		newsList.add(news);
		
		List<News> list =newsDao.select();
		if(list!=null){
			News news1 = new News();
			if(list.get(0)!=null){
				news1.setTitle(list.get(0).getTitle());
				news1.setDescription(list.get(0).getDescription());
				news1.setPicUrl(list.get(0).getPicUrl());
				news1.setUrl(list.get(0).getUrl());
				newsList.add(news1);
			}
			
			News news2 = new News();
			if(list.get(1)!=null){
				news2.setDescription(list.get(1).getDescription());
				news2.setPicUrl(list.get(1).getPicUrl());
				news2.setUrl(list.get(1).getUrl());
				news2.setTitle(list.get(1).getTitle());
				newsList.add(news2);
			}
			
			
			News news3 = new News();
			if(list.get(2)!=null){
				news3.setTitle(list.get(2).getTitle());
				news3.setDescription(list.get(2).getDescription());
				news3.setPicUrl(list.get(2).getPicUrl());
				news3.setUrl(list.get(2).getUrl());
				newsList.add(news3);
			}
		}
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = newsMessageToXml(newsMessage);
		
		return message;
	}*/
	/**
	 * 图文消息的组装2
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage1(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("客服中心");
		news.setDescription("天津易快通科技有限公司成立于2012年，是一家在国家工商局注册许可经营的技术型公司，利用先进的互联网、通信、电子商务技术，自主研发了国内领先的便民交费电子商务平台，公司网站www.ekuaitong.com已在工信部完成ICP备案，通过整合社区周边的各种实体店铺（便利店、通信店、报刊亭、网吧等），建立了覆盖生活社区的便民服务网络。天津易快通科技有限公司以优越的技术实力与创新理念为盟店提供最优质的产品、最稳定的系统、最便捷的缴费、最安全的支付服务，帮助盟店搭建整合行业资源。其线下客户通过登录易快通科技旗下缴费网站和公众平台购买各种产品或服务，从而搭建自己的社区O2O营销圈，直接趋使客户盈利最大化。");
		news.setPicUrl("http://wx.tjaxej.com/tjekuaitong/images/kefu.jpg");
		news.setUrl("http://wx.tjaxej.com/tjekuaitong/call_center/call_center.jsp");
		
		newsList.add(news);
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = newsMessageToXml(newsMessage);
		
		return message;
	}
	/**
	 * 图文消息的组装3
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage2(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("充值中心");
		news.setPicUrl("http://wx.tjaxej.com/tjekuaitong/images/kefu.jpg");
		news.setUrl("http://wx.tjaxej.com/tjekuaitong/NewFile3.jsp");
		
		newsList.add(news);
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = newsMessageToXml(newsMessage);
		
		return message;
	}
	/**
	 * 组装图片消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initImageMessage(String toUserName,String fromUserName){
		String message = null;
		Image image = new Image();
		image.setMediaId("JTH8vBl0zDRlrrn2bBnMleySuHjVbMhyAo0U2x7kQyd1ciydhhsVPONbnRrKGp8m");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		message = imageMessageToXml(imageMessage);
		return message;
	}
	
	/**
	 * 组装音乐消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initMusicMessage(String toUserName,String fromUserName){
		String message = null;
		Music music = new Music();
		music.setThumbMediaId("WsHCQr1ftJQwmGUGhCP8gZ13a77XVg5Ah_uHPHVEAQuRE5FEjn-DsZJzFZqZFeFk");
		music.setTitle("see you again");
		music.setDescription("速7片尾曲");
		music.setMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");
		music.setHQMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");
		
		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(MESSAGE_MUSIC);
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMusic(music);
		message = musicMessageToXml(musicMessage);
		return message;
	}
}
