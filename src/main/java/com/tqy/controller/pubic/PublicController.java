package com.tqy.controller.pubic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tqy.bean.Code;
import com.tqy.bean.Msg;
import com.tqy.service.CodeService;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	CodeService codeService;
	
	@ResponseBody
	@RequestMapping(value="/getCodeByType",method=RequestMethod.GET)
	public Msg getCodeByType(@RequestParam("code_type")String code_type){
		List<Code> list = codeService.getCodesByType(code_type);
		return list != null ? Msg.success().add("list", list) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/getSelects",method=RequestMethod.GET)
	public Msg getUserSelects(){
		List<Code> genderList = codeService.getCodesByType("gender");
		List<Code> collegeList = codeService.getCodesByType("college_type");
		List<Code> statusList = codeService.getCodesByType("status_type");
		Msg  success = Msg.success();
		success.add("genderList", genderList);
		success.add("collegeList", collegeList);
		success.add("statusList", statusList);
		return success;
	}
}
