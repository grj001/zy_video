package com.zhiyou100.zy_video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.model.User;


public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("视图渲染显示后调用,可查看日志,清理一些资源");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("controller执行后调用,参数是req和res,controller对象和数据视图," + "可以对数据进行处理");

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		System.out.println("controlelr执行前调用,参数为req,res,controller对象,只有返回true才能继续," + "用来做用户登录验证和权限校验" + arg2);
		// 获取Session中的loginName
		Admin adminRes = (Admin) req.getSession().getAttribute("adminRes");
		//如果用户名为空, 如果访问的是/admin/adminLogin.do则允许访问
		
		
		if (adminRes == null) {
			
			//没有用户信息
			//有用户名,有密码进行登录或访问登录界面
			
			if (!req.getServletPath().endsWith("/admin/login.do")) {
				
				//Session域中没有用户信息,但是直接访问了其他界面
				//重定向get请求,访问/admin/login.do
				res.sendRedirect(req.getContextPath()+"/admin/login.do");
			}
		}else {
			//有用户信息,自动登录,自动放行
			if (req.getServletPath().endsWith("login.do")) {
				//不用访问登陆界面
				res.sendRedirect(req.getContextPath()+"/admin/navigation.do");
			}
			//若访问其他界面则放行,因为有用户信息
		}
		return true;
		
	}

}
