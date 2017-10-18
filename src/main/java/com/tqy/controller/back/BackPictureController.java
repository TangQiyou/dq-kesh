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
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tqy.bean.Msg;
import com.tqy.bean.Picture;
import com.tqy.service.PictureService;

@Controller
@RequestMapping("/back")
public class BackPictureController {
	
	@Autowired
	PictureService pictureService;
	
	@ResponseBody
	@RequestMapping(value="/addOnlyPicture",method=RequestMethod.POST)
	public Msg addOnlyPicture(@RequestParam("file") MultipartFile file){
		boolean flag = pictureService.addOnlyPicture(file);
		return flag ? Msg.success():Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/picture",method=RequestMethod.POST)
	public Msg addPicture(@RequestBody Picture picture){
		boolean flag = pictureService.addPicture(picture);
		return flag ? Msg.success():Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/picture/{id}",method=RequestMethod.DELETE)
	public Msg deletePicture(@PathVariable("id") Integer p_id){
		boolean flag = pictureService.deletePicture(p_id);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/picture",method=RequestMethod.PUT)
	public Msg updatePicture(@RequestBody Picture picture){
		boolean flag = pictureService.updatePicture(picture);
		return flag ? Msg.success() : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/picture",method=RequestMethod.GET)
	public Msg getPictureById(@RequestParam("id") Integer p_id){
		Picture picture = pictureService.getPicture(p_id);
		return picture != null ? Msg.success().add("picture", picture) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/getPictureByType",method=RequestMethod.GET)
	public Msg getPictures(@PathVariable("pn")Integer pn){
		PageHelper.startPage(pn, 5);
		List<Picture> list = pictureService.getPictures();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		PageInfo pageInfo = new PageInfo(list, 5);
		return pageInfo != null ? Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
	
	
}
