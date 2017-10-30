package com.tqy.dao;

import java.util.List;

import com.tqy.bean.Announcement;

public interface AnnouncementMapper {
	public int addAnnouncement(Announcement announcement);
	
	public int deleteAnnouncement(int annId);
	
	public int updateAnnouncement(Announcement announcement);
	
	public Announcement getAnnouncement(int annId);
	
	public List<Announcement> getAnnouncements();
	
}
