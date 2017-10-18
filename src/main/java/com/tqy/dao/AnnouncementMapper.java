package com.tqy.dao;

import java.util.List;

import com.tqy.bean.Announcement;

public interface AnnouncementMapper {
	public int addAnnouncement(Announcement announcement);
	
	public int deleteAnnouncement(int id);
	
	public int updateAnnouncement(Announcement announcement);
	
	public Announcement getAnnouncement(int id);
	
	public List<Announcement> getAnnouncements();
	
}
