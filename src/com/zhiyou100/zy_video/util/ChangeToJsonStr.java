package com.zhiyou100.zy_video.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChangeToJsonStr {

	public static String changeToJsonStr (Object jsonObj) throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();    
		String jsonStr = mapper.writeValueAsString(jsonObj);
		
		return jsonStr;
	}
}
