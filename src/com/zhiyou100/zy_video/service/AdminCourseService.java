package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Course;

public interface AdminCourseService {

	public abstract List<Course> findAllCourse();

	public abstract Course findCourseById(Integer id);

	public abstract void updateCourse(Course course);

	public abstract void addCourse(Course course);

	public abstract void deleteCourseById(Integer id);

	public abstract List<Course> findAllCourseName();
		
}
