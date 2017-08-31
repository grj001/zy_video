package com.zhiyou100.zy_video.model;


public class CharVO {

	private String speaker;
	private Integer speaker_AVGPlayTimes;
	private String course;
	private Integer course_AVGPlayTimes;
	
	public Integer getSpeaker_AVGPlayTimes() {
		return speaker_AVGPlayTimes;
	}
	public void setSpeaker_AVGPlayTimes(Integer speaker_AVGPlayTimes) {
		this.speaker_AVGPlayTimes = speaker_AVGPlayTimes;
	}
	
	public Integer getCourse_AVGPlayTimes() {
		return course_AVGPlayTimes;
	}
	public void setCourse_AVGPlayTimes(Integer course_AVGPlayTimes) {
		this.course_AVGPlayTimes = course_AVGPlayTimes;
	}
	
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	

	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CharVO [speaker=" + speaker + ", speaker_AVGPlayTimes=" + speaker_AVGPlayTimes + ", course=" + course
				+ ", course_AVGPlayTimes=" + course_AVGPlayTimes + "]";
	}
}
