package com.tqy.dao;

import com.tqy.bean.Admin;

public interface AdminMapper {
	public Admin adminLogin(Admin admin);
	
	public int setLoginTime(Admin admin);
}
