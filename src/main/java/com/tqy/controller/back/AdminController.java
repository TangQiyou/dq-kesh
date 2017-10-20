package com.tqy.controller.back;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tqy.bean.Admin;
import com.tqy.bean.Msg;
import com.tqy.service.AdminService;

@Controller
@RequestMapping("/back")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Msg adminLogin(@RequestBody Admin admin){
		Map<String, Object> map = adminService.adminLogin(admin);
		int id = (int)map.get("id");
		String lastTime = map.get("lastTime").toString();
		boolean flag = false;
		if (id != -1){
			 flag = adminService.setLoginTime(id);
		} else {
			return Msg.fail();
		}
		return flag? Msg.success().add("adminId", id).add("lastTime", lastTime):Msg.fail();
	}
}
