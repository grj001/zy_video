package com.zhiyou100.zy_video.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.VideoMapper;
import com.zhiyou100.zy_video.model.CharVO;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.VideoExample;
import com.zhiyou100.zy_video.model.VideoVO;
import com.zhiyou100.zy_video.service.AdminVideoService;
import com.zhiyou100.zy_video.util.page.Page;

@Service
public class AdminVideoServiceImpl implements AdminVideoService {

	@Autowired
	VideoMapper vm;
	@Override
	public List<Video> findAllVideo(VideoVO vvo) {
		
		return vm.findAllVideo(vvo);
	}
	@Override
	public Page loadPage(VideoVO vvo) {
		
		Page<Video> page = new Page<>();
		page.setPage(vvo.getCurrentPage());
		vvo.setCurrentPage((vvo.getCurrentPage()-1)*5);
		page.setTotal(vm.findAllVideoCount(vvo));
		
		//System.out.println("***\n" + page.getTotal()+"\n***");
		
		page.setSize(5);
		page.setRows(vm.findAllVideo(vvo));
		
		return page;
	}
	//****************** 	编辑		******************************
	@Override
	public Object findVideoById(Integer id) {
		
		return vm.selectByPrimaryKey(id);
	}
	@Override
	public void updateVideo(Video video) {
		vm.updateByPrimaryKeySelective(video);
	}
	//***************************************************************
	
	//****************** 	添加		******************************
	@Override
	public void addVideo(Video video) {
		
		vm.addVideo(video);
		
	}
	//***************************************************************
	
	//***********************	删除和批量删除		*****************************
	@Override
	public void deleteVideoById(Integer id) {
		vm.deleteByPrimaryKey(id);
	}
	
	@Override
	public void batchDelete(Integer[] ids) {
		VideoExample ve = new VideoExample();
		ve.createCriteria().andIdIn(Arrays.asList(ids));
		vm.deleteByExample(ve);
	}
	//***************************************************************
	//*********************		char	*****************************
/*	@Override
	public List<CharVO> findSpeaker_PlayTimes() {
		
		return vm.findSpeaker_PlayTimes();
		
	}*/
	@Override
	public List<CharVO> findCourse_AVGPlayTimes() {
		return vm.findCourse_AVGPlayTimes();
	}
	//***************************************************************
}
