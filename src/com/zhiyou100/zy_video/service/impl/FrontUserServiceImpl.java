package com.zhiyou100.zy_video.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.UserMapper;
import com.zhiyou100.zy_video.model.Result;
import com.zhiyou100.zy_video.model.User;
import com.zhiyou100.zy_video.model.UserExample;
import com.zhiyou100.zy_video.service.FrontUserService;
import com.zhiyou100.zy_video.util.MailUtil;

@Service
public class FrontUserServiceImpl implements FrontUserService {

	@Autowired
	UserMapper um;

	// 查找单个用户
	@Override
	public List<User> findLoginUser(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		return um.selectByExample(ue);

	}

	// 插入用户
	@Override
	public Integer userRegist(User u) {
		int insertSelective = um.insertSelective(u);
		return insertSelective;
	}

	// 通过用户民email查询用户是否存在
	@Override
	public List<User> findRegistUserByEmail(String email) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		return um.selectByExample(ue);
	}

	// 向数据库中插入验证码
	@Override
	public void updateCaptchaByEmail(User u) {
		um.updateCaptchaByEmail(u);

	}

	// 通过邮箱地址和验证码查询用户
	@Override
	public List<User> findUserByEmailAndCaptcha(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		return um.selectByExample(ue);
	}

	// 忘记密码,进行修改
	@Override
	public void updateUserPwd(User u) {
		um.updateUserPwd(u);
	}

	// 修改用户信息
	@Override
	public Integer updateUser(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		Integer updateByExampleSelective = um.updateByExampleSelective(u, ue);
		return updateByExampleSelective;
	}

	// 通过id查找User
	@Override
	public User findUserById(Integer id) {
		return um.selectByPrimaryKey(id);
	}

	// 更新图片信息
	@Override
	public Integer updateFileById(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andIdEqualTo(u.getId());
		Integer updateByExampleSelective = um.updateByExampleSelective(u, ue);
		return updateByExampleSelective;

	}

	@Override
	public Result sendEmail(String email) {

		// 查询数据库,是否存在这个邮箱
		// 查找用户信息是否存在
		// 查询时只查email用户名
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		List<User> findEmailByEmailInfo = um.selectByExample(ue);

		Result result = new Result();
		// 判断邮箱是否存在
		if (findEmailByEmailInfo.isEmpty()) {

			// 邮箱不存在,不发送验证码,发送失败
			result.setSuccess(false);
		} else {

			// 存在邮箱,发送验证码
			result.setSuccess(true);
			result.setMessage("存在这个邮箱");

			// 随机生成验证码
			Random rd = new Random();
			Integer randomNum = rd.nextInt(9999 - 1000 + 1) + 1000;

			// 放入数据库中
			User u = new User();
			u.setEmail(email);
			u.setCaptcha(randomNum.toString());
			um.updateCaptchaByEmail(u);

			// 发送验证码邮件
			try {
				MailUtil.send(email, "验证码", randomNum.toString());
			} catch (Exception e) {
				System.out.println("***\n" + "发送验证码失败" + "\n***");
				e.printStackTrace();
			}
		}

		return result;
	}

}
