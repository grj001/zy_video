package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.SubjectMapper;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.service.AdminSubjectService;

@Service
public class AdminSubjectServiceImpl implements AdminSubjectService {

	@Autowired
	SubjectMapper sm;
	
	@Override
	public List<Subject> findAllSubjectName() {
		return sm.selectByExample(null);
	}

}
