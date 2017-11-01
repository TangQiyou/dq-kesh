package com.tqy.bean;

public class LeaveWord {
	
	private int leaveId;
	private String leaveTitle;
	private String leaveContent;
	private String leaveTime;
	private int leaveUserId;
	private User leaveUser;
	private int isResponsed;
	private String isResponsedName;
	
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveTitle() {
		return leaveTitle;
	}
	public void setLeaveTitle(String leaveTitle) {
		this.leaveTitle = leaveTitle;
	}
	public String getLeaveContent() {
		return leaveContent;
	}
	public void setLeaveContent(String leaveContent) {
		this.leaveContent = leaveContent;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public int getLeaveUserId() {
		return leaveUserId;
	}
	public void setLeaveUserId(int leaveUserId) {
		this.leaveUserId = leaveUserId;
	}
	public User getLeaveUser() {
		return leaveUser;
	}
	public void setLeaveUser(User leaveUser) {
		this.leaveUser = leaveUser;
	}
	public int getIsResponsed() {
		return isResponsed;
	}
	public void setIsResponsed(int isResponsed) {
		this.isResponsed = isResponsed;
	}
	public String getIsResponsedName() {
		return isResponsedName;
	}
	public void setIsResponsedName(String isResponsedName) {
		this.isResponsedName = isResponsedName;
	}
	@Override
	public String toString() {
		return "LeaveWord [leaveId=" + leaveId + ", leaveTitle=" + leaveTitle + ", leaveContent=" + leaveContent
				+ ", leaveTime=" + leaveTime + ", leaveUserId=" + leaveUserId + ", leaveUser=" + leaveUser
				+ ", isResponsed=" + isResponsed + ", isResponsedName=" + isResponsedName + "]";
	}
	public LeaveWord(int leaveId, String leaveTitle, String leaveContent, String leaveTime, int leaveUserId,
			User leaveUser, int isResponsed, String isResponsedName) {
		super();
		this.leaveId = leaveId;
		this.leaveTitle = leaveTitle;
		this.leaveContent = leaveContent;
		this.leaveTime = leaveTime;
		this.leaveUserId = leaveUserId;
		this.leaveUser = leaveUser;
		this.isResponsed = isResponsed;
		this.isResponsedName = isResponsedName;
	}
	public LeaveWord() {
		super();
	}
	
}
