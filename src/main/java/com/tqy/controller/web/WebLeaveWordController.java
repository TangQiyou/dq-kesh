package com.tqy.controller.web;

import java.util.List;
import java.util.Map;

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
import com.tqy.bean.LeaveWord;
import com.tqy.bean.Msg;
import com.tqy.bean.Response;
import com.tqy.service.LeaveWordService;
import com.tqy.service.ResponseService;

@Controller
@RequestMapping("/web")
public class WebLeaveWordController {

	@Autowired
	LeaveWordService leaveWordService;
	
	@Autowired
	ResponseService responseService;
	
	@ResponseBody
	@RequestMapping(value="/leaveword", method=RequestMethod.POST)
	public Msg addLeaveWord(@RequestBody LeaveWord leaveWord){
		boolean flag = leaveWordService.addLeaveWord(leaveWord);
		return  flag ? Msg.success(): Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/leaveword/{id}", method=RequestMethod.DELETE)
	public Msg deleteLeaveWord(@PathVariable("id") Integer id){
		boolean flag = leaveWordService.deleteLeaveWord(id);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/leaveword",method=RequestMethod.PUT)
	public Msg updateLeaveWord(@RequestBody LeaveWord leaveWord){
		boolean flag = leaveWordService.updateLeaveWord(leaveWord);
		return flag ? Msg.success():Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/leaveword",method=RequestMethod.GET)
	public Msg getLeaveWord(@RequestParam("id")Integer id){
		LeaveWord leaveWord = leaveWordService.getLeaveWord(id);
		Response response = responseService.getResponse(id);
		return leaveWord != null ? Msg.success().add("leaveword", leaveWord).add("response", response) : Msg.fail();
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/leavewords", method=RequestMethod.POST)
	public Msg getLeaveWordByPage(@RequestBody Map<String, Integer> map){
		int pn = map.get("pn");
		int leaveUserId = map.get("leaveUserId");
		PageHelper.startPage(pn, 5);
		List<LeaveWord> list = leaveWordService.getLeaveWordByPageAndUseId(leaveUserId);
		PageInfo pageInfo = new PageInfo<>(list, 5);
		return pageInfo != null ?  Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
}
