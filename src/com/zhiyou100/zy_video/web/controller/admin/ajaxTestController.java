package com.zhiyou100.zy_video.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/behind/ajax")
public class ajaxTestController {

	
	@RequestMapping("/js.action")
	public void adminLogin(String name){
		System.out.println("***\n" + "111111111"+"\n***");		
	}
}
