package com.tqy.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tqy.bean.Code;
import com.tqy.bean.Msg;
import com.tqy.bean.User;
import com.tqy.service.CodeService;
import com.tqy.service.UserService;

@Controller
@RequestMapping("/web")
public class WebUserController {
	
	@Autowired
	UserService userService;

	@Autowired
	CodeService codeService;
	
	@ResponseBody
	@RequestMapping(value="/isExist", method=RequestMethod.GET)
	public Msg isExist(@RequestParam("userAccount") String userAccount){
		boolean flag = userService.isExist(userAccount);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public Msg addUser(@RequestBody User user){
		boolean flag = userService.addUser(user);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public Msg userLogin(@RequestBody User user){
		User returnUser = userService.userLogin(user);
		return returnUser != null? Msg.success().add("user", returnUser) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.PUT)
	public Msg updatePersnalInformation(@RequestBody User user){
		boolean flag = userService.updateInformation(user);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePwd" , method=RequestMethod.PUT)
	public Msg updatePwd(@RequestBody User user){
		boolean flag = userService.updatePwd(user);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/updateHead", method=RequestMethod.POST)
	public Msg updateHead(@RequestParam("file") MultipartFile file, @RequestParam("userId") Integer userId){
		boolean flag = userService.updateHead(file, userId);
		return flag ? Msg.success() : Msg.fail();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public Msg getUser(@RequestParam("id")Integer userId){
		User user = userService.getUser(userId);
		user.setUserAccount(null);
		user.setUserPwd(null);
		List<Code> genderList = codeService.getCodesByType("gender");
		List<Code> collegeList = codeService.getCodesByType("college_type");
		List<Code> statusList = codeService.getCodesByType("status_type");
		Msg  success = Msg.success();
		success.add("user", user);
		success.add("genderList", genderList);
		success.add("collegeList", collegeList);
		success.add("statusList", statusList);
		return user != null? success : Msg.fail();
	}
	
	
}
