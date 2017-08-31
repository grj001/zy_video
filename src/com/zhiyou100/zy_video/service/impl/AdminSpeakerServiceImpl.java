package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.SpeakerMapper;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.SpeakerVO;
import com.zhiyou100.zy_video.service.AdminSpeakerService;
import com.zhiyou100.zy_video.util.page.Page;

@Service
public class AdminSpeakerServiceImpl implements AdminSpeakerService {

	@Autowired
	SpeakerMapper sm;
	
	@Override
	public List<Speaker> findAllSpeaker() {
		//找到所有
		return sm.selectByExample(null);
	}
	@Override
	public List<Speaker> findAllSpeakerName() {
		return sm.selectByExample(null);
	}
	@Override
	public Page loadPage(SpeakerVO svo) {
		
		//创建对象
		Page<Speaker> page = new Page<>();
		//当前页
		page.setPage(svo.getCurrentPage());
		//查找第几行记录
		svo.setCurrentPage((svo.getCurrentPage() - 1)*5);
		//一页多少条
		page.setSize(5);
		//总页数
		
		page.setTotal(sm.findAllSpeakerCountByPage(svo));
		
		page.setRows(sm.findAllSpeakerByPage(svo));
		return page;
	}
	@Override
	public void addSpeaker(Speaker speaker) {
		sm.insert(speaker);
		
	}
	@Override
	public Object findSpeakerById(Integer id) {
		return sm.selectByPrimaryKey(id);
	}
	@Override
	public void updateSpeaker(Speaker speaker) {
		sm.updateByPrimaryKeySelective(speaker);
		
	}
	@Override
	public void deleteSpeakerById(Integer id) {
		sm.deleteByPrimaryKey(id);
	}

}
