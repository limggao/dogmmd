package com.tjekuaitong.uitls;


import javax.servlet.ServletContext;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class XueXiContext extends ApplicationObjectSupport {
	private ServletContext servletContext;


	
	public WebApplicationContext getWebApplicationContext() {
		return WebApplicationContextUtils
				.getWebApplicationContext(this.servletContext);
	}
}