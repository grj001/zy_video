package com.zhiyou100.zy_video.web.controller.admin;


import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.VideoVO;
import com.zhiyou100.zy_video.service.AdminVideoService;
import com.zhiyou100.zy_video.util.page.Page;


@Controller
public class AdminVideoController {

	
	@Autowired
	AdminVideoService avs;
	
	@RequestMapping(value="/admin/video/videoList.do", method=RequestMethod.GET)
	public String findAllVideo(Model md, VideoVO vvo,HttpServletRequest req, HttpServletResponse res){
		
		//得到搜索信息
		String titleKeyWord = vvo.getTitleKeyWord();
		String speakerNameKeyWord = vvo.getSpeakerNameKeyWord();
		String courseNameKeyword = vvo.getCourseNameKeyword();
		//设置当前页
		int currentPage = req.getParameter("page")==null? 1:Integer.parseInt(req.getParameter("page"));
		
		//封装当前页到vvo
		vvo.setCurrentPage(currentPage);
		//调用page方法
		Page page = avs.loadPage(vvo);
		
		
		
		//将包装类放入方法参数中查询
//		List<Video> findAllVideo = avs.findAllVideo(vvo);
		
		System.out.println("***\n" + speakerNameKeyWord+"--------------" + courseNameKeyword+"\n***");
		
		//放入request域中,数据回填
		md.addAttribute("titleKeyWord", titleKeyWord);
		md.addAttribute("speakerNameKeyWord", speakerNameKeyWord);
		md.addAttribute("courseNameKeyword", courseNameKeyword);
		//数据展示
		md.addAttribute("page", page);
		
		System.out.println("***\n" + page.getRows()+"\n***");
		
		return "/admin/video/videoList";
	}
	
	
	
	@RequestMapping(value="/admin/video/updateVideo.do", method={RequestMethod.GET,RequestMethod.POST})
	public String updateCourse(Video video,Integer id, Model md, HttpServletRequest req, HttpServletResponse res){
		
		//get方法,findCourseById
		if(req.getMethod().equals("GET")){
			md.addAttribute("updateVideo",avs.findVideoById(id));
			return "/admin/video/updateVideo";
		}else{
			Timestamp update_time = new Timestamp(System.currentTimeMillis());
			video.setUpdateTime(update_time);
			avs.updateVideo(video);
			return "redirect:/admin/video/videoList.do";
		}
	}
	
	//添加课程
	@RequestMapping(value="/admin/video/addVideo.do", method={RequestMethod.GET,RequestMethod.POST})
	public String addVideo(Video video, HttpServletRequest req, HttpServletResponse res){
		
		if(req.getMethod().equals("GET")){
			//转发到addVideo.jsp
			return "/admin/video/addVideo";
		}else{
			Timestamp insert_time = new Timestamp(System.currentTimeMillis());
			video.setInsertTime(insert_time);
			avs.addVideo(video);
			return "redirect:/admin/video/videoList.do";
		}
	}
	
	
	
	
	
	//删除一条数据
	@RequestMapping(value="/admin/video/deleteVideo.do")
	@ResponseBody
	public String deleteVideo(Model md, Integer id){
		
		System.out.println("\nModel md" + md+"\n");
		
		avs.deleteVideoById(id);
		return "success";

	}
	
	
	
	
	
	
	
	
	
	
	
	//批量删除
	@RequestMapping(value="/admin/video/deleteVideos.do")
	public String deleteVideos(@RequestParam(value="ids", required=false) Integer ids[]){
		
		System.out.println("***\n" + Arrays.toString(ids)+"\n***");
		
		avs.batchDelete(ids);
		
		return "redirect:/admin/video/videoList.do";

	}
	
	

	
}
