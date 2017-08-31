package com.zhiyou100.zy_video.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.service.AdminUserService;

public class AutoLoginInterceptor implements HandlerInterceptor {

	@Autowired
	AdminUserService aus;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("\n" + "视图渲染后调用,查看日志,清理资源" + "\n");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("\n" + "controller执行后调用" + "\n");

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		System.out.println("\n" + "controller执行前调用" + "\n");

		System.out.println("\n" + "AutoLoginInterceptor begin" + "\n");

		/*
		 * 取出cookie,用密码,用户名查出adminRes用户信息 放行
		 */
		String loginName = null;
		// 传入的是secretLoginPwd
		String secretLoginPwd = null;
		
		Admin admin = new Admin();
		Admin adminRes = new Admin();
		
		//输出的cookies
		Cookie[] cks = req.getCookies();
		if (cks != null) {
			for (Cookie ck : cks) {
				if (ck.getName().equals("loginName")) {
					System.out.println("\n" + ck.getValue() + "\n");
				}
				if (ck.getName().equals("secretLoginPwd")) {
					System.out.println("\n" + ck.getValue() + "\n");
				}
				if (ck.getName().equals("JSESSIONID")) {
					System.out.println("\n" + ck.getValue() + "\n");
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
				
				//放入搜索条件
				admin.setLoginName(loginName);
				admin.setLoginPwd(secretLoginPwd);
				
				//搜索用户信息
				adminRes = aus.adminLogin(admin);
				
				if (adminRes != null) {
					req.getSession().setAttribute("adminRes", adminRes);
				}
			}
		}

		System.out.println("***\n" + "AutoLoginInterceptor end" + "\n***");

		return true;
	}

}
