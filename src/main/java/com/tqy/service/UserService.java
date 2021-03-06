package com.tqy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tqy.bean.User;
import com.tqy.dao.UserMapper;
import com.tqy.util.PictureUtil;
import com.tqy.util.TimeUtil;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public boolean isExist(String userAccount){
		String flag = userMapper.isExist(userAccount);
		return flag.equals("0") ? true : false;
	}
	
	public boolean addUser(User user){
		user.setUserLastLoginTime(TimeUtil.getCurrentTime());
		user.setUserHead("../img/head/default.jpg");
		int flag = userMapper.addUser(user);
		return flag == 1 ? true : false;
	}
	
	public boolean deleteUser(int userId){
		int flag = userMapper.deleteUser(userId);
		return flag == 1 ? true : false;
	}
	
	public User userLogin(User user){
		User  user2 = userMapper.userLogin(user);
		int flag = 1;
		if (user2 != null){
			String lastTime = user2.getUserLastLoginTime();
			user2.setUserLastLoginTime(TimeUtil.getCurrentTime());
			flag = userMapper.setLoginTime(user2);
			user2.setUserLastLoginTime(lastTime);
		}
		return flag == 1 ? user2 : null;
	}
	
	public boolean updateInformation(User user){
		int flag = userMapper.updateInfomation(user);
		return flag == 1? true : false;
	}
	
	public boolean updatePwd(User user){
		int flag = 0;
		User user2 = userMapper.getUser(user.getUserId());
		System.out.println(user);
		System.out.println(user2);
		if (user2.getUserPwd().equals(user.getOldPwd())){
			 flag = userMapper.updatePwd(user);
		}
		return flag == 1 ? true : false;
	}
	
	public boolean updateHead(MultipartFile file, Integer userId){
		int flag = 0;
		boolean flag2 = false;
		boolean flag3 = false;
		
		User user = new User();
		User user2 = userMapper.getUser(userId);
		user.setUserId(userId);
		user.setUserHead("../img/head/"+file.getOriginalFilename());
		flag = userMapper.updateHead(user);
		if (flag == 0){
			return false;
		}
		flag2 = PictureUtil.updateHead(file, userId);
		if (!flag2) {
			return false;
		}
		String dafaultHead = "default.jpg";
		String oldHead = user2.getUserHead().split("/")[user.getUserHead().split("/").length-1];
		if (oldHead.equals(dafaultHead)) {
			return true;
		}
		flag3 = PictureUtil.deleteHeadOnTheDisk(oldHead);
		return flag3;
	}
	
	public boolean updateAll(User user){
		int flag = userMapper.updateAll(user);
		return flag == 1 ? true : false;
	}
	
	public User getUserBack(int userId){
		User user = userMapper.getUserBack(userId);
		return user;
	}
	
	public User getUser(int userId){
		User user = userMapper.getUser(userId);
		return user;
	}
	
	public List<User> getUsers(){
		List<User> list = userMapper.getUsers();
		return list;
	}

}
