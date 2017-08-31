package com.zhiyou100.zy_video.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/*
 * 设置从String-->Date的转换规则
 * S 表示原有类型
 * T 表示转换后的类型
 * 
 * 
 * 我们规定    2017+08-16 20:23:30
 * 
 */


public class DateConvert implements Converter<String, Date>{

	@Override
	public Date convert(String str) {
	
		DateFormat df = new SimpleDateFormat("yyyy+MM-dd HH:mm:ss");
		Date theDate = null;
		try {
			theDate	= df.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theDate;
	}
}
