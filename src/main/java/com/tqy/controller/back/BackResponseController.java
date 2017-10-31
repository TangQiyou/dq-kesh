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
import com.tqy.bean.Msg;
import com.tqy.bean.Response;
import com.tqy.service.ResponseService;

@Controller
@RequestMapping("/back")
public class BackResponseController {
	
	@Autowired
	ResponseService responseService;
	
	@ResponseBody
	@RequestMapping(value="/response", method=RequestMethod.POST)
	public Msg addResponse(@RequestBody Response response){
		boolean flag = responseService.addResponse(response);
		return flag? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/response/{id}", method=RequestMethod.DELETE)
	public Msg deleteResponse(@PathVariable("id")Integer responseId){
		boolean flag = responseService.deleteResponse(responseId);
		return flag? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/response", method=RequestMethod.PUT)
	public Msg updateResponse(@RequestBody Response response){
		boolean flag = responseService.updateResponse(response);
		return flag? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/response", method=RequestMethod.GET)
	public Msg getResponse(@RequestParam("id") Integer responseId){
		Response response = responseService.getResponse(responseId);
		return response != null? Msg.success().add("response", response): Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/responses", method=RequestMethod.GET)
	public Msg getResponseByPage(@RequestParam("pn")Integer pn){
		PageHelper.startPage(pn, 5);
		List<Response> list = responseService.getResponseByPage();
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo<>(list, 5);
		return pageInfo != null ?  Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
}
