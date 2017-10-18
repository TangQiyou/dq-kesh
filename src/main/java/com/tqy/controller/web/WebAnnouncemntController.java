package com.tqy.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
//@RequestMapping(value="/web",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping(value="/web")
public class WebAnnouncemntController {
	
	@Autowired
	AnnouncementService announcementService;
	
//	@ResponseBody
//	@RequestMapping(value="/fun1",method=RequestMethod.GET)
//	public Msg fun1(@RequestParam("parameter") String parameter){
//		return Msg.success().add("parameter",parameter);
//	}
	
	@ResponseBody
	@RequestMapping(value="/announcement", method=RequestMethod.GET)
	public Msg getAnnouncement(@RequestParam("a_id") Integer id){
		Announcement announcement = announcementService.getAnnouncement(id);
		return announcement != null ? Msg.success().add("announcement", announcement) : Msg.fail();
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/announcements")
	public Msg getAnnouncements(@RequestParam(value="pn",defaultValue="1")Integer pn){
		PageHelper.startPage(pn,5);
		List<Announcement> announcements = announcementService.getAnnouncements();
		@SuppressWarnings("unchecked")
		PageInfo pageInfo = new PageInfo(announcements,5);
		return pageInfo != null ?  Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/announcements2")
	public Msg getAnnouncements2(@RequestParam(value="pn",defaultValue="1")Integer pn){
		PageHelper.startPage(pn,10);
		List<Announcement> announcements = announcementService.getAnnouncements();
		@SuppressWarnings("unchecked")
		PageInfo pageInfo = new PageInfo(announcements,5);
		return pageInfo != null ?  Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
}
