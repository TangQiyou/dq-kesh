package com.tqy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Response;
import com.tqy.dao.LeaveWordMapper;
import com.tqy.dao.ResponseMapper;
import com.tqy.util.TimeUtil;

@Service
public class ResponseService {
	
	@Autowired
	ResponseMapper responseMapper;
	
	@Autowired
	LeaveWordMapper leaveWordMapper;
	
	public boolean addResponse(Response response){
		response.setResponseTime(TimeUtil.getCurrentTime());
		int flag1 = responseMapper.addResponse(response);
		int flag2 = leaveWordMapper.responseLeaveword(response.getResponseLeaveId());
		return flag1 == 1 && flag2 == 1? true : false;
	}
	
	public boolean deleteResponse(int responseId){
		int flag = responseMapper.deleteResponse(responseId);
		return flag == 1? true : false;
	}
	
	public boolean updateResponse(Response response){
		response.setResponseTime(TimeUtil.getCurrentTime());
		int flag = responseMapper.updateResponse(response);
		return flag == 1? true : false;
	}
	
	public Response getResponse(int responseId){
		return responseMapper.getResponse(responseId);
	}
	
	public Response getResponseByLeaeId(int leaveId){
		return responseMapper.getResponseByLeaveid(leaveId);
	}
	
	public List<Response> getResponseByPage(){
		return responseMapper.getResponseByPage();
	}
}
