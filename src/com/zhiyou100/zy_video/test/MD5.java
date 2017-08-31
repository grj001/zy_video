package com.zhiyou100.zy_video.test;

import org.junit.Test;
import org.springframework.util.DigestUtils;

import com.zhiyou100.zy_video.util.MD5Util;

public class MD5 {

	@Test
	public void test01(){
		String str = "111111";
		byte[] bytes = str.getBytes();
		String encode = DigestUtils.md5DigestAsHex(bytes);
		System.out.println(encode);
	}
	
	@Test
	public void test02(){
		String str = "111111";
		String encode = MD5Util.md5Util(MD5Util.md5Util(str));
		System.out.println(encode);
	}
}
