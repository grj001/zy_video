package com.zhiyou100.zy_video.web.controller.front;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.zy_video.model.User;
import com.zhiyou100.zy_video.service.FrontUserService;
import com.zhiyou100.zy_video.util.MD5Util;

@Controller
public class FrontUserInfoController {

	// 注入FrontUserServiceImpl对象
	@Autowired
	FrontUserService fus;
	
	//用户界面***************************************************************************
	
	//head.jsp点击用户名登录user/index.jsp,front/user/index.do
	@RequestMapping(value = "/front/user/index.do", method = RequestMethod.GET)
	public String headToIndex(
			Integer id,
			HttpSession se) throws Exception {
		
		//更新session中的user
		User u = fus.findUserById(id);
		se.setAttribute("user", u);
		se.setAttribute("userId", id);
		
		return "forward:/WEB-INF/view/front/user/index.jsp";
	}
	
	//******************************************************************************************************
	//user/index.jsp进入更改资料,/front/user/profile.do
	@RequestMapping(value = "/front/user/profile.do", method = RequestMethod.GET)
	public String headToIndexToProfile() throws Exception {
		
		///front/user/index.do,中从Session中取user
		
		return "forward:/WEB-INF/view/front/user/profile.jsp";
	}
	
	
	//front/user/profile.do,/front/user/profile.jsp中更改用户信息
	@RequestMapping(value = "/front/user/profile.do", method = RequestMethod.POST)
	public String headToIndexToProfileUpdate(
			Model md,
			User u,
			@RequestParam(value="birthdayStr", required=true, defaultValue="2222-22-22")String birthdayStr,
			HttpSession se) throws Exception {
		
		//获得信息
		
		//转换bitsthdayStr格式
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = df.parse(birthdayStr);
		u.setBirthday(birthday);
		
		//加入updateTime
		u.setUpdateTime(new Date(System.currentTimeMillis()));
		
		//修改用户信息
		Integer updateUser = fus.updateUser(u);
		
		md.addAttribute("updateUserInteger", updateUser);
		
		//更新session中的user
		u = fus.findUserById(u.getId());
		se.setAttribute("user", u);
		
		return "forward:/WEB-INF/view/front/user/profile.jsp";
	}
	
	
	//******************************************************************************************************
	//front/user/avatar.do,
	//进入front/user/avatar.jsp,进入用户更改头像
	@RequestMapping(value = "/front/user/avatar.do", method = RequestMethod.GET)
	public String headToIndexToAvatar() throws Exception {
		
		///front/user/index.do,中从Session中取user
		
		return "forward:/WEB-INF/view/front/user/avatar.jsp";
	}
	
	//front/user/avatar.do,/front/user/avatar.jsp中更改用户头像
	@RequestMapping(value = "/front/user/avatar.do", method = RequestMethod.POST)
	public String  headToIndexToAvatarUpdate(
			MultipartFile image_file,
			Model md,
			HttpSession se) throws Exception {
		
		//获得信息,
		
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		//得到扩展名
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		//图片命名
		String fileName = str + "." + ext;
		//图片路径
		String path = "D:\\upload";
		//上传文件
		image_file.transferTo(new File(path + "\\" + fileName));
		
		int id = ((User)se.getAttribute("user")).getId();
		User u = new User();
		u.setHeadUrl(fileName);
		u.setId(id);
		
		Integer updateFileById = fus.updateFileById(u);
		
		//更新user
		se.setAttribute("user", fus.findUserById(id));
		
		md.addAttribute("updateFileById", updateFileById);
		
		return "forward:/WEB-INF/view/front/user/avatar.jsp";
	}
	
	
	//******************************************************************************************************
	//front/user/password.do,
	//进入/front/user/password.jsp,进入用户更改密码
	@RequestMapping(value = "/front/user/password.do", method = RequestMethod.GET)
	public String headToIndexToPassword() throws Exception {
		
		///front/user/index.do,中从Session中取user
		
		return "forward:/WEB-INF/view/front/user/password.jsp";
	}
	
/*	//查找密码是否正确ajax
	//front/user/checkPassword.do
	@RequestMapping(value = "/front/user/checkPassword.do", method = RequestMethod.POST)
	@ResponseBody
	public String checkPassword(
			@RequestBody String oldPassword,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//获得信息,
		
		//获取密码,md5加密
		String secretOldPassword = MD5Util.md5Util("1111");
		String secretPassword = ((User)req.getSession().getAttribute("user")).getPassword();
		
		System.out.println("***匹配密码:\n" + secretOldPassword+"--"+secretPassword+"\n***");
		
		String resultStr = "";
		//匹配密码是否正确
		if(secretOldPassword.equals(secretPassword)){
			resultStr = "success";
			
			//修改密码
			
		}else{
			resultStr = "fail";
		}
		
		return resultStr;
	}*/
	
	//进行修改密码,front/user/password.do
	@RequestMapping(value = "/front/user/password.do", method = RequestMethod.POST)
	public String reSetassword(
			Model md,
			String oldPassword,
			String newPassword,
			HttpSession se) throws Exception {
		
		//得到id
		Integer id = (Integer) se.getAttribute("userId");
		
		//获取密码,md5加密
		String secretOldPassword = MD5Util.md5Util(oldPassword);
		String secretNewPassword = MD5Util.md5Util(newPassword);
		String secretPassword = ((User)se.getAttribute("user")).getPassword();
		
		String resultStr = "";
		//匹配密码是否正确
		if(secretOldPassword.equals(secretPassword)){
			
			User u = new User();
			u.setId(id);
			u.setPassword(secretNewPassword);
			u.setUpdateTime(new Date(System.currentTimeMillis()));
			
			//修改密码
			fus.updateUserPwd(u);
			
			resultStr = "success";
			
		}else{
			
			resultStr = "fail";
		}
		
		md.addAttribute("resultStr", resultStr);
		
		//更新user
		se.setAttribute("user", fus.findUserById(id));
		
		return "forward:/WEB-INF/view/front/user/password.jsp";
	}
	
	
	
	
	
	
}
