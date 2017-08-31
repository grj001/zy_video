package com.zhiyou100.zy_video.util;

public class ChangeVideoLength {

	public static String changeVideoLength(Integer videoLength){
		
		Integer minute = 0;
		Integer second = 0;
		Integer hour = 0;
		String videoLengthStr = "";
		
		//秒
		second = videoLength%60;
		
		//分
		minute = videoLength/60;
		
		//时
		if(minute >= 60){
			hour = minute/60;
			minute = minute%60;
		}
		
		//拼接时间
		videoLengthStr = (hour>=10? hour: "0"+hour)+":"+(minute>=10? minute: "0"+minute)+":"+(second>=10? second: "0"+second);
		
		return videoLengthStr;
	}
}
