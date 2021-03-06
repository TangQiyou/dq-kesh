package com.tqy.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tqy.bean.Code;
import com.tqy.bean.Msg;
import com.tqy.bean.User;
import com.tqy.service.CodeService;
import com.tqy.service.UserService;

@Controller
@RequestMapping("/back")
public class BackUserController {
	
	@Autowired
	UserService userService;

	@Autowired
	CodeService codeService;
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public Msg addUser(@RequestBody User user){
		System.out.println(user);
		boolean flag = userService.addUser(user);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public Msg deleteUser(@PathVariable("id") Integer userId){
		boolean flag = userService.deleteUser(userId);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.PUT)
	public Msg updateUser(@RequestBody User user){
		boolean flag = userService.updateAll(user);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public Msg getUser(@RequestParam("id") Integer userId){
		User user = userService.getUserBack(userId);
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
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public Msg getUsers(@RequestParam(value="pn",defaultValue="1")Integer pn){
		PageHelper.startPage(pn,5);
		List<User> users = userService.getUsers();
		@SuppressWarnings("unchecked")
		PageInfo pageInfo = new PageInfo(users,5);
		return pageInfo != null ?  Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/isExist", method=RequestMethod.GET)
	public Msg isExist(@RequestParam("userAccount") String userAccount){
		boolean flag = userService.isExist(userAccount);
		return flag ? Msg.success() : Msg.fail();
	}
}
