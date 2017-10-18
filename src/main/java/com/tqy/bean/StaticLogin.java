package com.tqy.bean;

public class StaticLogin {
	
	private int id;
	private String account;
	private String pwd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "StaticLogin [id=" + id + ", account=" + account + ", pwd=" + pwd + "]";
	}
	public StaticLogin(int id, String account, String pwd) {
		super();
		this.id = id;
		this.account = account;
		this.pwd = pwd;
	}
	public StaticLogin(){
		super();
	}
	
	
}
