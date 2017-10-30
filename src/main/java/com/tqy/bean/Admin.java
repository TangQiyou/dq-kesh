package com.tqy.bean;

public class Admin {
	private int adminId;
	private String adminAccount;
	private String adminPwd;
	private String adminName;
	private String adminLastLoginTime;
	
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
	public String getAdminLastLoginTime() {
		return adminLastLoginTime;
	}
	public void setAdminLastLoginTime(String adminLastLoginTime) {
		this.adminLastLoginTime = adminLastLoginTime;
	}
	public Admin(int adminId, String adminAccount, String adminPwd, String adminName, String adminLastLoginTime) {
		super();
		this.adminId = adminId;
		this.adminAccount = adminAccount;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.adminLastLoginTime = adminLastLoginTime;
	}
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminAccount=" + adminAccount + ", adminPwd=" + adminPwd
				+ ", adminName=" + adminName + ", adminLastLoginTime=" + adminLastLoginTime + "]";
	}

	public Admin(){
		super();
	}
}
