package com.zhiyou100.zy_video.web.controller.admin;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.service.AdminUserService;
import com.zhiyou100.zy_video.service.AdminCourseService;
import com.zhiyou100.zy_video.service.AdminSpeakerService;
import com.zhiyou100.zy_video.service.AdminSubjectService;
import com.zhiyou100.zy_video.util.MD5Util;


@Controller
public class AdminUserController{

	@Autowired
	AdminUserService aus;
	@Autowired
	AdminSubjectService ass;
	@Autowired
	AdminCourseService acs;
	@Autowired
	AdminSpeakerService asks;
	
	@RequestMapping(value="/admin/login.do", method=RequestMethod.GET)
	public String adminLogin(){
		return "admin/index";	
	}
	
	@RequestMapping(value="/admin/navigation.do", method=RequestMethod.GET)
	public String adminNavigation(){
		return "admin/navigation";
	}
	
	
	//用户登录
	@RequestMapping(value="/admin/login.do", method=RequestMethod.POST)
	public String adminLogin(
			@RequestParam(value="loginName",required=true, defaultValue="1") String loginName,
			@RequestParam(value="loginPwd",required=true, defaultValue="1") String loginPwd,
			@RequestParam(value="remember",required=false, defaultValue="false") Boolean remember,
			HttpServletRequest req, HttpServletResponse res){
		
		
		//登陆时直接把学科名,放入Session中
		List<Subject> sub = ass.findAllSubjectName();
		req.getSession().setAttribute("listSubject", sub);
		//登陆时直接把课程名,放入Session中
		List<Course> cou = acs.findAllCourseName();
		req.getSession().setAttribute("listCourse", cou);
		//登陆时直接把主讲人姓名,放入Session域中
		List<Speaker> spe = asks.findAllSpeakerName();
		req.getSession().setAttribute("listSpeaker", spe);
		
		
		//得到用户名loginName和密码loginPwd
		Admin admin = new Admin();
		
		//md5加密
		String secretLoginPwd = MD5Util.md5Util(loginPwd);
		System.out.println("*** public String adminLogin \n" + loginName+"--------------" + secretLoginPwd+"\n***");
		
		admin.setLoginName(loginName);
		admin.setLoginPwd(secretLoginPwd);
		
		//进入数据库查找
		Admin adminRes = aus.adminLogin(admin);
		
		//***************************************************************************************************
		
		//自动登录放入cookie
		//用于return的字符串
		String returnStr = "";
		
		if(adminRes == null){
			//如果查询结果为空,用户名密码不匹配,重定向到index.jsp
			req.setAttribute("errorMessage", "用户名密码不匹配");
			returnStr = "forward:/WEB-INF/view/admin/index.jsp";
		}else {
			//如果查询结果不为空,将用户名放入Session中
			//有两次将adminRes放入Session域中自动登录时
			//如果cookies中有用户名密码,则进行自动登录,没有就不登录
			//这说明已经有过登录操作,将用户名密码放入cookies中
			//用户拦截UserInterceptor的判断依据是Session域中是否有用户信息,有则放行
			req.getSession().setAttribute("adminRes", adminRes);
			if(remember){
				//如果需要自动登录,那么将用户名和密码放入cookie中
				Cookie ckName = new Cookie("loginName", loginName);
				//将加密的密码放入cookie中
				Cookie ckPwd = new Cookie("secretLoginPwd", secretLoginPwd);
				ckName.setMaxAge(60*60*24);
				ckPwd.setMaxAge(60*60*24);
				ckName.setPath(req.getContextPath());
				ckPwd.setPath(req.getContextPath());
				res.addCookie(ckName);
				res.addCookie(ckPwd);
			}
			//重定向到navigation.jsp
			returnStr = "redirect:/admin/navigation.do";
		}
		
		return returnStr;
		
	}
	
	@RequestMapping(value="/admin/logout.do", method=RequestMethod.GET)
	public String adminLoginOut(HttpServletRequest req,HttpServletResponse res){
		
		HttpSession session = req.getSession();
		//清空Session
		session.invalidate();

		//清空cookie
		Cookie ckName = new Cookie("loginName", "");
		Cookie ckSession = new Cookie("JSESSIONID", "");
		Cookie ckPwd = new Cookie("secretLoginPwd", "");
		ckName.setMaxAge(0);
		ckPwd.setMaxAge(0);
		ckSession.setMaxAge(0);
		ckName.setPath(req.getContextPath());
		ckPwd.setPath(req.getContextPath());
		ckSession.setPath(req.getContextPath());
		res.addCookie(ckName);
		res.addCookie(ckPwd);
		res.addCookie(ckSession);
		return "admin/index";	
	}
	
}
