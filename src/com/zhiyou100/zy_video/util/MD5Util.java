package com.zhiyou100.zy_video.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

	public static String md5Util(String loginPwd){
		//密码loginPwd转成字符数组
		byte[] loginPwdBytes = loginPwd.getBytes();
		//spring自带的md5加密工具
		String secretLoginPwd = DigestUtils.md5DigestAsHex(loginPwdBytes);
		return secretLoginPwd;
	}
}
