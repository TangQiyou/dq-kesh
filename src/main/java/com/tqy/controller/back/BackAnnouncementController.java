package com.tqy.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tqy.bean.Announcement;
import com.tqy.bean.Msg;
import com.tqy.service.AnnouncementService;

@Controller
@RequestMapping("/back")
public class BackAnnouncementController {
	
	@Autowired
	AnnouncementService announcementService;
	
	@ResponseBody
	@RequestMapping(value="/announcement", method=RequestMethod.POST)
	public Msg addAnnouncement(@RequestBody Announcement announcement){
		boolean flag = announcementService.addAnnouncement(announcement);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/announcement/{id}", method=RequestMethod.DELETE)
	public Msg deleteAnnouncement(@PathVariable("id") Integer id){
		boolean flag = announcementService.deleteAnnouncement(id);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/announcement", method=RequestMethod.PUT)
	public Msg updateAnnouncement(@RequestBody Announcement announcement){
		boolean flag = announcementService.updateAnnouncement(announcement);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/announcement", method=RequestMethod.GET)
	public Msg getAnnouncement(@RequestParam("id") Integer id){
		Announcement announcement = announcementService.getAnnouncement(id);
		return announcement != null ? Msg.success().add("announcement", announcement) : Msg.fail();
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/announcements",method=RequestMethod.GET)
	public Msg getAnnouncements(@RequestParam("pn")Integer pn){
		PageHelper.startPage(pn,5);
		List<Announcement> announcements = announcementService.getAnnouncements();
		@SuppressWarnings("unchecked")
		PageInfo pageInfo = new PageInfo(announcements,5);
		return pageInfo != null ?  Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
}
