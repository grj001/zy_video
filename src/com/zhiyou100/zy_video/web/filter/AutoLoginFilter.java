package com.zhiyou100.zy_video.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sun.jmx.snmp.Timestamp;
import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.service.AdminUserService;
import com.zhiyou100.zy_video.service.impl.AdminUserServiceImpl;

public class AutoLoginFilter implements Filter {


	public void destroy() {
		System.out.println("\n" +"过滤器销毁" +"\n");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println("\n" + "doFilter begin"+"\n");
		
		AdminUserService as = new AdminUserServiceImpl();
		
		//取出cookie,用密码,用户名登录
		String loginName = null;
		//传入的是secretLoginPwd
		String secretLoginPwd = null;
		Admin admin = new Admin();
		Admin adminRes = new Admin();
		Cookie[] cks = req.getCookies();
		
		
		if(cks != null){
			for(Cookie ck : cks){
				if(ck.getName().equals("loginName")){
					System.out.println("\n" + ck.getValue()+"\n");
				}
				if(ck.getName().equals("secretLoginPwd")){
					System.out.println("\n" + ck.getValue()+"\n");
				}
				if(ck.getName().equals("JSESSIONID")){
					System.out.println("\n" + ck.getValue()+"\n");
				}
			}
		}
		

		if (cks != null) {
			for (Cookie ck : cks) {
				if (ck.getName().equals("loginName")) {
					loginName = ck.getValue();
				}
				if (ck.getName().equals("secretLoginPwd")) {
					secretLoginPwd = ck.getValue();
				}
			}
			if (loginName != null && secretLoginPwd != null) {
				admin.setLoginName(loginName);
				admin.setLoginPwd(secretLoginPwd);
//				System.out.println(admin);
				adminRes = as.adminLogin(admin);
				if (adminRes != null) {
					req.getSession().setAttribute("adminRes", adminRes);
				}
			}
		}
		
		System.out.println("\n" + "doFilter end"+"\n");
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("\n" + "初始Filter"+"\n");
		System.out.println("\n" + new Timestamp(System.currentTimeMillis()) +"\n");
	}

}
