package com.tqy.dao;

import java.util.List;

import com.tqy.bean.Code;

public interface CodeMapper {
	public Code getCodeByValue(int codeValue);
	
	public List<Code> getCodesByType(String codeType);
	
	public Code getCodeById(int codeId);
}