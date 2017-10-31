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
import com.tqy.bean.LeaveWord;
import com.tqy.bean.Msg;
import com.tqy.service.LeaveWordService;

@Controller
@RequestMapping("/back")
public class BackLeaveWordController {

	@Autowired
	LeaveWordService leaveWordService;
	
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
		return leaveWord != null ? Msg.success().add("leaveword", leaveWord) : Msg.fail();
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/leavewords", method=RequestMethod.GET)
	public Msg getLeaveWordByPage(@RequestParam("pn")Integer pn){
		PageHelper.startPage(pn, 5);
		List<LeaveWord> list = leaveWordService.getLeaveWordByPage();
		PageInfo pageInfo = new PageInfo<>(list, 5);
		return pageInfo != null ?  Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
	
}
