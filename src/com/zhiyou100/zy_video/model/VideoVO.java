package com.zhiyou100.zy_video.model;

public class VideoVO {
	
	private Video video;
	private String titleKeyWord;
	private String speakerNameKeyWord;
	private String courseNameKeyword;
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "VideoVO [video=" + video + ", titleKeyWord=" + titleKeyWord + ", speakerNameKeyWord="
				+ speakerNameKeyWord + ", courseNameKeyword=" + courseNameKeyword + ", currentPage=" + currentPage
				+ "]";
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getTitleKeyWord() {
		return titleKeyWord;
	}
	public void setTitleKeyWord(String titleKeyWord) {
		this.titleKeyWord = titleKeyWord;
	}
	public String getSpeakerNameKeyWord() {
		return speakerNameKeyWord;
	}
	public void setSpeakerNameKeyWord(String speakerNameKeyWord) {
		this.speakerNameKeyWord = speakerNameKeyWord;
	}
	public String getCourseNameKeyword() {
		return courseNameKeyword;
	}
	public void setCourseNameKeyword(String courseNameKeyword) {
		this.courseNameKeyword = courseNameKeyword;
	}
	
	
}
