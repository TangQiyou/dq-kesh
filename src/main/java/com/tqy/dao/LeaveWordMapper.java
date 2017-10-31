package com.tqy.dao;

import java.util.List;

import com.tqy.bean.LeaveWord;

public interface LeaveWordMapper {
	public int addLeaveWord(LeaveWord leaveWord);
	
	public int deleteLeaveWord(int leaveId);
	
	public int updateLeaveWord(LeaveWord leaveWord);
	
	public int responseLeaveword(int leaveId);
	
	public LeaveWord getLeaveWord(int leaveId);
	
	public List<LeaveWord> getLeaveWordByPage();
	
	public List<LeaveWord> getLeaveWordByPageAndUseId(int leaveUserId);
}
