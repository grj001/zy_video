package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.CourseMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.service.AdminCourseService;

@Service
public class AdminCourseServiceImpl implements AdminCourseService {

	@Autowired
	CourseMapper cm;
	
	@Override
	public List<Course> findAllCourse() {
		return cm.findAllCourse();
		
	}
	@Override
	public List<Course> findAllCourseName() {
		return cm.selectByExample(null);
	}
	
	//*******************	编辑	*********************	
	@Override
	public Course findCourseById(Integer id) {
		
		return cm.selectById(id);
	}

	@Override
	public void updateCourse(Course course) {
		cm.updateByPrimaryKeySelective(course);
		
	}
	//************************************************
	@Override
	public void addCourse(Course course) {
		cm.addCourse(course);
		
	}

	@Override
	public void deleteCourseById(Integer id) {
		cm.deleteByPrimaryKey(id);
	}




}
