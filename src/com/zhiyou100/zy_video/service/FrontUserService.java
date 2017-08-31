package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Result;
import com.zhiyou100.zy_video.model.User;

public interface FrontUserService {

	List<User> findLoginUser(User u);

	Integer userRegist(User u);

	List<User> findRegistUserByEmail(String email);

	void updateCaptchaByEmail(User u);

	List<User> findUserByEmailAndCaptcha(User u);

	void updateUserPwd(User u);

	Integer updateUser(User u);

	User findUserById(Integer id);

	Integer updateFileById(User u);

	Result sendEmail(String email);

	
}
