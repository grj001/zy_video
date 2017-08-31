package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.model.Video;

public interface FrontVideoService {

	Subject findSubjectById(Integer subjectId);

	List<Course> findCoursesWithVideoListBySubjectId(Integer subjectId);

	Video findVideoById(Integer videoId);

	Video findVideoWithSpeakerWithCourseById(Integer videoId);

	List<Video> findVideoByCourseInOneSubject(Integer courseId, Integer subjectId);

}
