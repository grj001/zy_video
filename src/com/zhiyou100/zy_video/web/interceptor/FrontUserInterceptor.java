package com.zhiyou100.zy_video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.model.User;

public class FrontUserInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {

		// 获取Session中的user
		User user = (User) req.getSession().getAttribute("user");

		if (user == null) {
			
			//按键失效
			//放入request域中一个字符串
			req.setAttribute("userMessage", "no user");
		}else if(user != null){
			
			req.removeAttribute("userMessage");
		}

		return true;
	}

}
