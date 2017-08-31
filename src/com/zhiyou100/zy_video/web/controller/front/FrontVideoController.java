package com.zhiyou100.zy_video.web.controller.front;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.FrontVideoService;

@Controller
public class FrontVideoController {

	@Autowired
	FrontVideoService fvs;
	
	///front/course/index.do
	@RequestMapping(value="/front/course/index.do", method=RequestMethod.GET)
	public String courseIndex(
			Integer subjectId,
			Model md
			){
		
		Subject sub = fvs.findSubjectById(subjectId);
		md.addAttribute("subject", sub);
		md.addAttribute("subjectId", subjectId);
		
		//最终结果不再使用,找到包含视频的课程列表
		List<Course> courses = fvs.findCoursesWithVideoListBySubjectId(subjectId);
		md.addAttribute("courses", courses);
		
		System.out.println("***包含视频的课程列表\n" + courses+"\n***");
		
		return "forward:/WEB-INF/view/front/course/index.jsp";
	}
	
	//front/video/index.do?videoId=
	@RequestMapping(value="/front/video/index.do", method=RequestMethod.GET)
	public String videoIndex(
			Integer videoId,
			Integer subjectId,
			Model md,
			HttpSession se
			){
		
		//通过subjectId查找subject,
		Subject sub = fvs.findSubjectById(subjectId);
		md.addAttribute("subject", sub);
		se.setAttribute("subjectId", subjectId);
		md.addAttribute("videoId", videoId);
		
		System.out.println("***传到显示视频界面的index.jsp\n" + videoId+"\n***");
		
		return "forward:/WEB-INF/view/front/video/index.jsp";
	}
	
	//front/video/videoData.do?videoId='+id
	@RequestMapping(value="/front/video/videoData.do", method=RequestMethod.GET)
	public String videoIndex(
			Integer videoId,
			Model md
			){
		
		//显示单个视频信息
		Video v = fvs.findVideoWithSpeakerWithCourseById(videoId);
		md.addAttribute("video", v);
		md.addAttribute("speaker", v.getSpeaker());
		md.addAttribute("course", v.getCourse());	
		
		System.out.println("***显示单个视频信息	里面包含课程信息和讲师信息\n" + v+"\n***");
		System.out.println("***video.course \n" + v.getCourse()+"\n***");
		System.out.println("***video.speaker \n" + v.getSpeaker()+"\n***");
		
		
		//显示	这个学科	对应课程	的视频目录
		Integer courseId = v.getCourseId();
		Integer subjectId = v.getCourse().getSubjectId();
		List<Video> videoList = fvs.findVideoByCourseInOneSubject(courseId, subjectId);
		md.addAttribute("videoList", videoList);
		
		return "forward:/WEB-INF/view/front/video/content.jsp";
	}
	
	
	
}
