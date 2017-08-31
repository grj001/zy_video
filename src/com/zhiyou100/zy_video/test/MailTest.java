package com.zhiyou100.zy_video.test;

import org.junit.Test;

import com.zhiyou100.zy_video.util.MailUtil;

public class MailTest {

	@Test
	public void test01() throws Exception{
		MailUtil.send("1460177617@qq.com", "测试邮件", "<a href=\"http://www.baidu.com\">百度</a>");
	}
}
