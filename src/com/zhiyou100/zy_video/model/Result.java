package com.zhiyou100.zy_video.model;

public class Result {

	private Boolean success;
	private String message;
	@Override
	public String toString() {
		return "Result [success=" + success + ", message=" + message + "]";
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
