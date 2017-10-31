package com.tqy.dao;

import java.util.List;

import com.tqy.bean.Response;

public interface ResponseMapper {
	
	public int addResponse(Response response);
	
	public int deleteResponse(int responseId);
	
	public int updateResponse(Response response);
	
	public Response getResponse(int responseId);
	
	public Response getResponseByLeaveId(int leaveId);
	
	public List<Response> getResponseByPage();
}
