package com.zhiyou100.zy_video.model;

public class SpeakerVO {

	private Speaker speaker;
	private String speakerNameKeyWord;
	private String speakerJobKeyWord;
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "SpeakerVO [speaker=" + speaker + ", speakerNameKeyWord=" + speakerNameKeyWord + ", speakerJobKeyWord="
				+ speakerJobKeyWord + ", currentPage=" + currentPage + "]";
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public String getSpeakerNameKeyWord() {
		return speakerNameKeyWord;
	}
	public void setSpeakerNameKeyWord(String speakerNameKeyWord) {
		this.speakerNameKeyWord = speakerNameKeyWord;
	}
	public String getSpeakerJobKeyWord() {
		return speakerJobKeyWord;
	}
	public void setSpeakerJobKeyWord(String speakerJobKeyWord) {
		this.speakerJobKeyWord = speakerJobKeyWord;
	}
	
}
