package com.tqy.bean;

public class Response {
	
	private int responseId;
	private String responseContent;
	private String responseTime;
	private int responseLeaveId;
	
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	public String getResponseContent() {
		return responseContent;
	}
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}
	public String getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}
	public int getResponseLeaveId() {
		return responseLeaveId;
	}
	public void setResponseLeaveId(int responseLeaveId) {
		this.responseLeaveId = responseLeaveId;
	}
	@Override
	public String toString() {
		return "Response [responseId=" + responseId + ", responseContent=" + responseContent + ", responseTime="
				+ responseTime + ", responseLeaveId=" + responseLeaveId + "]";
	}
	public Response(int responseId, String responseContent, String responseTime, int responseLeaveId) {
		super();
		this.responseId = responseId;
		this.responseContent = responseContent;
		this.responseTime = responseTime;
		this.responseLeaveId = responseLeaveId;
	}
	public Response() {
		super();
	}
	
	
}
