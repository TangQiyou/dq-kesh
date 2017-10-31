package com.tqy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Response;
import com.tqy.dao.ResponseMapper;

@Service
public class ResponseService {
	
	@Autowired
	ResponseMapper responseMapper;
	
	public boolean addResponse(Response response){
		int flag = responseMapper.addResponse(response);
		return flag == 1? true : false;
	}
	
	public boolean deleteResponse(int responseId){
		int flag = responseMapper.deleteResponse(responseId);
		return flag == 1? true : false;
	}
	
	public boolean updateResponse(Response response){
		int flag = responseMapper.updateResponse(response);
		return flag == 1? true : false;
	}
	
	public Response getResponse(int responseId){
		return responseMapper.getResponse(responseId);
	}
	
	public Response getResponseByLeaeId(int leaveId){
		return responseMapper.getResponseByLeaveId(leaveId);
	}
	
	public List<Response> getResponseByPage(){
		return responseMapper.getResponseByPage();
	}
}
