package com.zhiyou100.zy_video.mapper;

import com.zhiyou100.zy_video.model.CharVO;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.VideoExample;
import com.zhiyou100.zy_video.model.VideoVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	List<Video> findAllVideo(VideoVO vvo);

	int findAllVideoCount(VideoVO vvo);

	void addVideo(Video video);

//	List<CharVO> findSpeaker_PlayTimes();

	List<CharVO> findCourse_AVGPlayTimes();

	Video findVideoWithSpeakerWithCourseById(Integer videoId);

	List<Video> findVideoByCourseInOneSubject(@Param("courseId") Integer courseId,@Param("subjectId") Integer subjectId);

}