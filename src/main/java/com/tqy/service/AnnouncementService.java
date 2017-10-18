package com.tqy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Announcement;
import com.tqy.dao.AnnouncementMapper;

@Service
public class AnnouncementService {
	
	@Autowired
	AnnouncementMapper announcementMapper;
	
	public boolean addAnnouncement(Announcement announcement){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		announcement.setAnnTime(time);
		int flag = announcementMapper.addAnnouncement(announcement);
		return flag == 1? true : false;
	}
	
	public boolean deleteAnnouncement(int id){
		int flag = announcementMapper.deleteAnnouncement(id);
		return flag == 1 ? true : false;
	}
	
	public boolean updateAnnouncement(Announcement announcement){
		int flag = announcementMapper.updateAnnouncement(announcement);
		return flag == 1 ? true : false;
	}
	
	public Announcement getAnnouncement(int id){
		return announcementMapper.getAnnouncement(id);
	}
	
	public List<Announcement> getAnnouncements(){
		List<Announcement> list = announcementMapper.getAnnouncements();
		return list;
	}
}
