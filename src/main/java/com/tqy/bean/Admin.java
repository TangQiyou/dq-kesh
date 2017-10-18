package com.tqy.bean;

public class Admin {
	private int adminId;
	private String adminAccount;
	private String adminPwd;
	private String adminName;
	private String adminLastTime;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminLastTime() {
		return adminLastTime;
	}
	public void setAdminLastTime(String adminLastTime) {
		this.adminLastTime = adminLastTime;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminAccount=" + adminAccount + ", adminPwd=" + adminPwd
				+ ", adminName=" + adminName + ", adminLastTime=" + adminLastTime + "]";
	}
	public Admin(int adminId, String adminAccount, String adminPwd, String adminName, String adminLastTime) {
		super();
		this.adminId = adminId;
		this.adminAccount = adminAccount;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.adminLastTime = adminLastTime;
	}
	public Admin(){
		super();
	}
}
