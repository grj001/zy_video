package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.SpeakerVO;
import com.zhiyou100.zy_video.util.page.Page;

public interface AdminSpeakerService {

	public abstract List<Speaker> findAllSpeaker();

	public abstract List<Speaker> findAllSpeakerName();

	public abstract Page loadPage(SpeakerVO svo);

	public abstract void addSpeaker(Speaker speaker);

	public abstract Object findSpeakerById(Integer id);

	public abstract void updateSpeaker(Speaker speaker);

	public abstract void deleteSpeakerById(Integer id);

}
