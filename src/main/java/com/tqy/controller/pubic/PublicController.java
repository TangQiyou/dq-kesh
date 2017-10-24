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
	@RequestMapping(value="/getCodeNameByValue",method=RequestMethod.GET)
	public Msg getCodeNameByValue(@RequestParam("codeValue")Integer codeValue){
		String codeName = codeService.getNameByValue(codeValue);
		System.out.println(codeName);
		return codeName != null ? Msg.success().add("codeName", codeName) : Msg.fail();
	}
}
