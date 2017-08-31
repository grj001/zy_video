package com.zhiyou100.zy_video.web.controller.admin;


import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.service.AdminCourseService;

@Controller
@RequestMapping("/admin/course")
public class AdminCourseController {

	@Autowired
	AdminCourseService acs;
	
	@RequestMapping(value="/courseList.do", method=RequestMethod.GET)
	public String findAllCourse(HttpServletRequest req, HttpServletResponse res){
		
		List<Course> findAllCourse = acs.findAllCourse();
		req.getSession().setAttribute("findAllCourse", findAllCourse);
		return "/admin/course/courseList";
	}
	
	@RequestMapping(value="/updateCourse.do", method={RequestMethod.GET,RequestMethod.POST})
	public String updateCourse(Course course,Integer id, Model md, HttpServletRequest req, HttpServletResponse res){
		
		//get方法,findCourseById
		if(req.getMethod().equals("GET")){
			md.addAttribute("updateCourse",acs.findCourseById(id));
			return "/admin/course/updateCourse";
		}else{
			Timestamp update_time = new Timestamp(System.currentTimeMillis());
			course.setUpdateTime(update_time);
			acs.updateCourse(course);
			return "redirect:/admin/course/courseList.do";
		}
	}
	
	//添加课程
	@RequestMapping(value="/addCourse.do", method={RequestMethod.GET,RequestMethod.POST})
	public String addCourse(Course course, HttpServletRequest req, HttpServletResponse res){
		
		//get方法,findCourseById
		if(req.getMethod().equals("GET")){
			return "/admin/course/addCourse";
		}else{
			Timestamp insert_time = new Timestamp(System.currentTimeMillis());
			course.setInsertTime(insert_time);
			acs.addCourse(course);
			return "redirect:/admin/course/courseList.do";
		}
	}
	
	
	//添加课程
		@RequestMapping(value="/deleteCourse.do")
		public String addCourse(Integer id){
			
			acs.deleteCourseById(id);
			return "redirect:/admin/course/courseList.do";

		}
	

}
