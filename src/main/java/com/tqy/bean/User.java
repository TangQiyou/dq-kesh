package com.tqy.bean;

public class User {
	
	private int userId;
	private String userAccount;
	private String userPwd;
	private String userLastLoginTime;
	private String userName;
	private String email;
	private int age;
	private String qq;
	private String tel;
	
	private int college;
	private String collegeName;
	private int status;
	private String statusName;
	private int gender;
	private String genderName;
	public int getUserId() {
		return userId;
	}
	public void setUseId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserLastLoginTime() {
		return userLastLoginTime;
	}
	public void setUserLastLoginTime(String userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getCollege() {
		return college;
	}
	public void setCollege(int college) {
		this.college = college;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public User(int userId, String userAccount, String userPwd, String userLastLoginTime, String userName, String email,
			int age, String qq, String tel, int college, String collegeName, int status, String statusName, int gender,
			String genderName) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userLastLoginTime = userLastLoginTime;
		this.userName = userName;
		this.email = email;
		this.age = age;
		this.qq = qq;
		this.tel = tel;
		this.college = college;
		this.collegeName = collegeName;
		this.status = status;
		this.statusName = statusName;
		this.gender = gender;
		this.genderName = genderName;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userPwd=" + userPwd + ", userLastLoginTime="
				+ userLastLoginTime + ", userName=" + userName + ", email=" + email + ", age=" + age + ", qq=" + qq
				+ ", tel=" + tel + ", college=" + college + ", collegeName=" + collegeName + ", status=" + status
				+ ", statusName=" + statusName + ", gender=" + gender + ", genderName=" + genderName + "]";
	}
	
	
}
