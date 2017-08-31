package com.zhiyou100.zy_video.test;

import org.junit.Test;

public class ChangeLengthTest {

	@Test
	public void test01(){
		
		Integer minute = 0;
		Integer second = 0;
		Integer hour = 0;
		Integer videoLength = 0;
		String videoLengthStr = "";
		
		//以秒为单位
		for(videoLength = 0; videoLength < 1000; videoLength++){
			
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
			
			System.out.println("***videoLengthStr = \n" + videoLengthStr+"\n***");
		}
	}
	
	

	
	
	
}
