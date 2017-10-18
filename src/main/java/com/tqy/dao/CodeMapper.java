package com.tqy.dao;

import java.util.List;

import com.tqy.bean.Code;

public interface CodeMapper {
	public Code getCodeByvalue(int code_value);
	
	public List<Code> getCodeByType(String code_type);
}