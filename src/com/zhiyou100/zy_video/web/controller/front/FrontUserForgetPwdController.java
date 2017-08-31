package com.zhiyou100.zy_video.web.controller.front;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.zy_video.model.Result;
import com.zhiyou100.zy_video.model.User;
import com.zhiyou100.zy_video.service.FrontUserService;
import com.zhiyou100.zy_video.util.ChangeToJsonStr;
import com.zhiyou100.zy_video.util.MD5Util;
import com.zhiyou100.zy_video.util.MailUtil;

@Controller
public class FrontUserForgetPwdController {

	@Autowired
	FrontUserService fus;

	// 忘记密码,发送验证码,/forgetpwd.do********************************************************************************************

	// 进入忘记密码验证的页面
	@RequestMapping(value = "/forgetpwd.do", method = RequestMethod.GET)
	public String forgetpwdGet() throws Exception {

		// 重定向会进不去页面
		return "forward:/WEB-INF/view/front/user/forget_pwd.jsp";
	}

	
	// 发送验证码邮件,/sendemail.do
	@RequestMapping(value = "/sendemail.do", method = RequestMethod.POST)
	@ResponseBody
	public String sendEmail( String email ) throws Exception {
		
		//Service成发送邮件
		Result result = fus.sendEmail(email);

		// 将发送结果转换成jsonStr
		String jsonStr = ChangeToJsonStr.changeToJsonStr(result);

		return jsonStr;
	}

	// 进行验证验证码是否正确,forgetpwd.do,post
	@RequestMapping(value = "/forgetpwd.do", method = RequestMethod.POST)
	public String sendEmailAndCaptcha(
			Model md, 
			User u)throws Exception {

		// 查找用户findUserByEmailAndCaptcha
		List<User> findUserByEmailAndCaptcha = fus.findUserByEmailAndCaptcha(u);

		String returnStr = "";

		// 判断邮箱和验证吗是否匹配
		if (findUserByEmailAndCaptcha.isEmpty()) {
			
			// 为空不匹配,设置消息
			md.addAttribute("message", "用户名和验证码不匹配");

			// 内部转发到/WEB-INF/view/front/user/forget_pwd.jsp,重新输入验证码
			returnStr = "forward:/WEB-INF/view/front/user/forget_pwd.jsp";
		} else {
			
			// 用户名和密码匹配,修改密码

			// 将要修改的用户名,放入request中
			md.addAttribute("email", u.getEmail());
			md.addAttribute("captcha", findUserByEmailAndCaptcha.get(0).getCaptcha());

			// 内部转发到/WEB-INF/view/front/user/reset_pwd.jsp
			returnStr = "forward:/WEB-INF/view/front/user/reset_pwd.jsp";
		}
		return returnStr;
	}

	
	// 进行密码修改,front/user/resetpwd.do
	@RequestMapping(value = "/front/user/resetpwd.do", method = RequestMethod.POST)
	public String resetPwd(
			Model md, 
			User u) throws Exception {

		// 对密码进行加密
		u.setPassword(MD5Util.md5Util(u.getPassword()));

		//插入更新时间
		u.setUpdateTime(new Date(System.currentTimeMillis()));
		
		// 已经验证过了用户存在,进行密码修改
		fus.updateUserPwd(u);

		return "forward:/WEB-INF/view/front/user/forget_pwd.jsp";
	}
}
