package com.zhiyou100.zy_video.web.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListenerTest implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("***\n" + "session创建"+"\n***");
		HttpSession session = se.getSession();
		
		System.out.println("***\n"+session.getAttributeNames().toString() +"--------------"+session.getAttributeNames().toString() +"\n***");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("***\n" + "session 销毁"+"\n***");
	}

	
}
