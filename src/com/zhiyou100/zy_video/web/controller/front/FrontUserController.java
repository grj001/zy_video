package com.zhiyou100.zy_video.web.controller.front;


import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zhiyou100.zy_video.model.Result;
import com.zhiyou100.zy_video.model.User;
import com.zhiyou100.zy_video.service.FrontUserService;
import com.zhiyou100.zy_video.util.ChangeToJsonStr;
import com.zhiyou100.zy_video.util.MD5Util;
import com.zhiyou100.zy_video.util.MailUtil;

@Controller
public class FrontUserController {

	// 注入FrontUserServiceImpl对象
	@Autowired
	FrontUserService fus;

	// 进入初始页面********************************************************************************************
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String goToFrontIndex(HttpServletRequest req, HttpServletResponse res) {

		// 获得路径
		String path = req.getContextPath();
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/";
		
		// 将bassPath放入Session中 <base href="${BaseContext}\">
		req.getSession().setAttribute("BaseContext", basePath);

		return "forward:/WEB-INF/view/front/index.jsp";
	}

	
	// 退出登录********************************************************************************************
	// front/user/logout.do
	@RequestMapping(value = "/front/user/logout.do", method = RequestMethod.GET)
	public String UserLogout(
			HttpSession session) {

		session.invalidate();

		return "redirect:/index.do";
	}

	
	// 点击登陆按钮后,登陆操作,/front/user/login.do********************************************************************************************
	@RequestMapping(value = "/front/user/login.do", method = RequestMethod.POST)
	@ResponseBody
	public String userLogin(
			Model md, 
			User u, 
			HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException {

		// 对密码进行加密
		String secretLoginPassword = MD5Util.md5Util(u.getPassword());
		
		// 进入数据库查找
		u.setPassword(secretLoginPassword);
		List<User> findLoginUser = fus.findLoginUser(u);
		
		Result result = new Result();
		if (findLoginUser.isEmpty()) {
			// 没找到用户
			result.setSuccess(false);
			result.setMessage("用户名或密码错误,登录失败");
		} else {
			// 找到用户
			result.setSuccess(true);
			
			// 将用户信息放入Session域中,回填用户信息邮箱名时使用
			req.getSession().setAttribute("_front_user", findLoginUser.get(0));
			
			//将用户信息放入session域中,user/index.jsp用,显示用户信息时使用
			req.getSession().setAttribute("user", findLoginUser.get(0));
		}

		// 转换成json字符串
		String jsonStr = ChangeToJsonStr.changeToJsonStr(result);

		return jsonStr;
	}

	// 点击注册按钮后,注册操作,/front/user/regist.do********************************************************************************************
	@RequestMapping(value = "/front/user/regist.do", method = RequestMethod.POST)
	@ResponseBody
	public String userRegist(
			Model md, 
			User u, 
			HttpServletRequest req, HttpServletResponse res) 
			throws JsonProcessingException {

		// 获得regEmail和regPsw
		// 查找用户信息是否存在
		// 查询时只查email用户名
		List<User> findRegistUserByEmail = fus.findRegistUserByEmail(u.getEmail());

		// 判断是否为空
		Result result = new Result();
		if (findRegistUserByEmail.isEmpty()) {
			
			// 进行注册,返回影响行数
			// 插入时,进行md5码加密
			u.setPassword(MD5Util.md5Util(u.getPassword()));
			Integer userRegist = fus.userRegist(u);

			result.setSuccess(true);
		} else {

			result.setSuccess(false);
			result.setMessage("用户名email已存在,注册失败");
		}

		String jsonStr = ChangeToJsonStr.changeToJsonStr(result);

		return jsonStr;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
