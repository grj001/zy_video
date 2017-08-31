package com.zhiyou100.zy_video.mapper;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.CourseExample;
import com.zhiyou100.zy_video.model.Video;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

	List<Course> findAllCourse();

	Course selectById(Integer id);

	void addCourse(Course course);

	List<Course> findCoursesWithVideoListBySubjectId(Integer subjectId);
}