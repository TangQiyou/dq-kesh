package com.tqy.dao;

import com.tqy.bean.User;

public interface UserMapper {
	
	public String isExist(String userAccount);
	
	public int addUser(User user);
	
	public User userLogin(User user);
	
	public int setLoginTime(User user);
	
	public int updateInfomation(User user);
	
	public int updatePwd(User user);
	
	public User getUser(int userId);
}
