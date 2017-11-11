package com.tqy.dao;

<<<<<<< HEAD
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

=======
>>>>>>> parent of dbaffdd... Revert "Merge branch 'tangqy' into dev"
import com.tqy.bean.User;

public interface UserMapper {
	
	public String isExist(String userAccount);
	
	public int addUser(User user);
	
<<<<<<< HEAD
	public int deleteUser(int userId);
	
=======
>>>>>>> parent of dbaffdd... Revert "Merge branch 'tangqy' into dev"
	public User userLogin(User user);
	
	public int setLoginTime(User user);
	
	public int updateInfomation(User user);
	
	public int updatePwd(User user);
	
<<<<<<< HEAD
	public int updateAll(User user);
	
	public User getUser(int userId);
	
	public User getUserBack(int userId);
	
	public List<User> getUsers();
} 
=======
	public User getUser(int userId);
}
>>>>>>> parent of dbaffdd... Revert "Merge branch 'tangqy' into dev"
