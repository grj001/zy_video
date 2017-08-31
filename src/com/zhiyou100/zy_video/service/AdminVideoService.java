package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.CharVO;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.VideoVO;
import com.zhiyou100.zy_video.util.page.Page;

public interface AdminVideoService {

	List<Video> findAllVideo(VideoVO vvo);

	Page loadPage(VideoVO vvo);

	//编辑
	Object findVideoById(Integer id);

	void updateVideo(Video video);

	void addVideo(Video video);

	void deleteVideoById(Integer id);

//	List<CharVO> findSpeaker_PlayTimes();

	List<CharVO> findCourse_AVGPlayTimes();

	void batchDelete(Integer[] ids);


}
