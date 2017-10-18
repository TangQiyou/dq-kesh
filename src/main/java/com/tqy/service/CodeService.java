package com.tqy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Code;
import com.tqy.dao.CodeMapper;

@Service
public class CodeService {
	
	@Autowired
	CodeMapper codeMapper;
	
	public List<Code> getCodeByType(String code_type){
		List<Code> list = codeMapper.getCodeByType(code_type);
		return list;
	}
}
