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
	
	public List<Code> getCodesByType(String codeType){
		List<Code> list = codeMapper.getCodesByType(codeType);
		return list;
	}
	
	public Code getCodeById(int codeId){
		Code code = codeMapper.getCodeById(codeId);
		return code;
	}
	
}
