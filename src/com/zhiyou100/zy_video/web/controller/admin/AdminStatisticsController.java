package com.zhiyou100.zy_video.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.CharVO;
import com.zhiyou100.zy_video.service.AdminVideoService;

@Controller
@RequestMapping("/admin/char")
public class AdminStatisticsController {

	
	//创建videoService
	@Autowired
	AdminVideoService avs;
	
	@RequestMapping(value="/charList.do")
	public String buildChar(Model md){
		
		System.out.println("***\n" +"@RequestMapping(value=\"/charList.do\")" +"\n***");
		
/*		//查找speaker的playtimes
		List<CharVO> findSpeaker_PlayTimes = vs.findSpeaker_PlayTimes();
		System.out.println("***findSpeaker_PlayTimes\n" +findSpeaker_PlayTimes +"\n***");*/
		//查找course的AVGplaytimes
		List<CharVO> findCourse_AVGPlayTimes = avs.findCourse_AVGPlayTimes();
		System.out.println("***findCourse_PlayTimes\n" +findCourse_AVGPlayTimes +"\n***");
		md.addAttribute("findCourse_AVGPlayTimes", findCourse_AVGPlayTimes);
		
		String resultCourseNamesStr = "";
		String resultCourseTimesStr = "";
		for(CharVO cv : findCourse_AVGPlayTimes){
			if(cv.getCourse() == null){
				System.out.println("***\n" +cv.getCourse() +"\n***");
				cv.setCourse("");
			}
			resultCourseNamesStr +="\'" + cv.getCourse() + "\'" + ",";
			resultCourseTimesStr +="\'" + cv.getCourse_AVGPlayTimes() + "\'" + ",";
		}
		resultCourseNamesStr = resultCourseNamesStr.substring(0, resultCourseNamesStr.length()-1);
		resultCourseTimesStr = resultCourseTimesStr.substring(0, resultCourseTimesStr.length()-1);
		System.out.println("***\n" +resultCourseNamesStr +"--------------" +resultCourseTimesStr +"\n***");
		
		md.addAttribute("resultCourseNamesStr", resultCourseNamesStr);
		md.addAttribute("resultCourseTimesStr", resultCourseTimesStr);
		
		
		
		return "/admin/char/charList";
		
	}
}
