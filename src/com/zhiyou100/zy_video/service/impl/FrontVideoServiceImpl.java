package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.CourseMapper;
import com.zhiyou100.zy_video.mapper.SubjectMapper;
import com.zhiyou100.zy_video.mapper.VideoMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.FrontVideoService;

@Service
public class FrontVideoServiceImpl implements FrontVideoService {

	@Autowired
	SubjectMapper sm;
	@Autowired
	CourseMapper cm;
	@Autowired
	VideoMapper vm;
	
	@Override
	public Subject findSubjectById(Integer subjectId) {
		
		return sm.selectByPrimaryKey(subjectId);
	}

	@Override
	public List<Course> findCoursesWithVideoListBySubjectId(Integer subjectId) {
		
		return cm.findCoursesWithVideoListBySubjectId(subjectId);
	}

	@Override
	public Video findVideoById(Integer videoId) {
		return vm.selectByPrimaryKey(videoId);
	}

	@Override
	public Video findVideoWithSpeakerWithCourseById(Integer videoId) {
		return vm.findVideoWithSpeakerWithCourseById(videoId);
	}

	@Override
	public List<Video> findVideoByCourseInOneSubject(Integer courseId, Integer subjectId) {
		
		return vm.findVideoByCourseInOneSubject(courseId, subjectId);
	}

}
