package com.zhiyou100.zy_video.web.controller.admin;


import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.SpeakerVO;
import com.zhiyou100.zy_video.service.AdminSpeakerService;
import com.zhiyou100.zy_video.util.page.Page;

@Controller
@RequestMapping("/admin/speaker")
public class AdminSpeakerController {

	static{
		System.out.println("SpeakerController");
	}
	
	@Autowired
	AdminSpeakerService ass;
	
	//speaker列表
	@RequestMapping(value="/speakerList.do", method=RequestMethod.GET)
	public String findAllSpeaker(Model md, SpeakerVO svo,@RequestParam(value="page",required=false) Integer page1 ,HttpServletRequest req, HttpServletResponse res){
		
		
		//得到请求数据speakerNameKeyWord,speakerJobKeyWord
		String speakerNameKeyWord = svo.getSpeakerNameKeyWord();
		String speakerJobKeyWord = svo.getSpeakerJobKeyWord();
		Integer currentPage = page1 == null? 1: page1;
		svo.setCurrentPage(currentPage);
		
		Page page = ass.loadPage(svo);
		
		
		md.addAttribute("page", page);
		md.addAttribute("speakerNameKeyWord", speakerNameKeyWord);
		md.addAttribute("speakerJobKeyWord", speakerJobKeyWord);
		
		return "/admin/speaker/speakerList";
	}
	
	//添加speaker
	@RequestMapping(value="/addSpeaker.do", method={RequestMethod.GET,RequestMethod.POST})
	public String addSpeaker(Speaker speaker, Model md, HttpServletRequest req, HttpServletResponse res){
		
		if(req.getMethod().equals("GET")){
			return "/admin/speaker/addSpeaker";
		}else{
			Timestamp insertTime = new Timestamp(System.currentTimeMillis());
			speaker.setInsertTime(insertTime);
			
			ass.addSpeaker(speaker);
			
			return "redirect:/admin/speaker/speakerList.do";
		}
	}
	
	
	@RequestMapping(value="/updateSpeaker.do", method={RequestMethod.GET,RequestMethod.POST})
	public String updateSpeaker(Speaker speaker,Integer id, Model md, HttpServletRequest req, HttpServletResponse res){
		
		//get方法,findSpeakerById
		if(req.getMethod().equals("GET")){
			md.addAttribute("updateSpeaker",ass.findSpeakerById(id));
			return "/admin/speaker/updateSpeaker";
		}else{
			Timestamp update_time = new Timestamp(System.currentTimeMillis());
			speaker.setUpdateTime(update_time);
			System.out.println("\n" + speaker+"\n");
			ass.updateSpeaker(speaker);
			return "redirect:/admin/speaker/speakerList.do";
		}
	}
	

	
	
	//添加课程
		@RequestMapping(value="/deleteSpeaker.do")
		public String addSpeaker(Integer id){
			
			ass.deleteSpeakerById(id);
			return "redirect:/admin/speaker/speakerList.do";

		}
	
	

}
