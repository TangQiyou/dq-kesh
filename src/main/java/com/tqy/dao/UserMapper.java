package com.tqy.dao;

import java.util.List;

import com.tqy.bean.User;

public interface UserMapper {
	
	public String isExist(String userAccount);
	
	public int addUser(User user);
	
	public int deleteUser(int userId);
	
	public User userLogin(User user);
	
	public int setLoginTime(User user);
	
	public int updateInfomation(User user);
	
	public int updatePwd(User user);
	
	public int updateAll(User user);
	
	public User getUser(int userId);
	
	public User getUserBack(int userId);
	
	public List<User> getUsers();

}
