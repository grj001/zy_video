package com.zhiyou100.zy_video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.AdminMapper;
import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.model.AdminExample;
import com.zhiyou100.zy_video.service.AdminUserService;

//注解
@Service
public class AdminUserServiceImpl implements AdminUserService {

	//自动注入
	@Autowired
	AdminMapper am;
	
	@Override
	public Admin adminLogin(Admin admin) {
		
		//创建AdminExample
		AdminExample ae = new AdminExample();
		ae.createCriteria().andLoginNameEqualTo(admin.getLoginName()).andLoginPwdEqualTo(admin.getLoginPwd());
		System.out.println("***\n" +am.selectByExample(ae) +"\n***");
		Admin returnAdmin = am.selectByExample(ae).get(0);
		System.out.println("***\n" + returnAdmin+"\n***");
		return returnAdmin;
	}

}
