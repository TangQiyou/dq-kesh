package com.tqy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.LeaveWord;
import com.tqy.dao.LeaveWordMapper;
import com.tqy.util.TimeUtil;

@Service
public class LeaveWordService {
	
	@Autowired
	LeaveWordMapper leaveWordMapper;
	
	public boolean addLeaveWord(LeaveWord leaveWord){
		leaveWord.setLeaveTime(TimeUtil.getCurrentTime());
		leaveWord.setIsResponsed(51);
		int flag = leaveWordMapper.addLeaveWord(leaveWord);
		return flag == 1 ? true : false;
	}
	
	public boolean deleteLeaveWord(int id){
		int flag = leaveWordMapper.deleteLeaveWord(id);
		return flag == 1 ? true : false;
	}
	
	public boolean updateLeaveWord(LeaveWord leaveWord){
		leaveWord.setIsResponsed(51);
		int flag = leaveWordMapper.updateLeaveWord(leaveWord);
		return flag == 1 ? true : false;
	}
	
	public boolean responseLeaveword(int leaveId){
		int flag = leaveWordMapper.responseLeaveword(leaveId);
		return flag == 1? true : false;
	}
	
	public LeaveWord getLeaveWord(int id){
		return leaveWordMapper.getLeaveWord(id);
	}
	
	public List<LeaveWord> getLeaveWordByPage(){
		return leaveWordMapper.getLeaveWordByPage();
	}
	
	public List<LeaveWord> getLeaveWordByPageAndUseId(int leaveUserId){
		return leaveWordMapper.getLeaveWordByPageAndUseId(leaveUserId);
	}
	
}