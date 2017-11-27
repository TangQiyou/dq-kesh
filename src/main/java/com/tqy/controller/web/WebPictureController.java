package com.tqy.controller.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.tqy.bean.Msg;
import com.tqy.bean.Picture;
import com.tqy.service.PictureService;
import com.tqy.util.PathUtil;

@Controller
@RequestMapping(value="/web")
public class WebPictureController {
	
	@Autowired
	PictureService pictureService;
	
	@ResponseBody
	@RequestMapping(value="/getPictureById",method=RequestMethod.GET)
	public Msg getPictureById(@RequestParam("id")Integer picId){
		Picture picture = pictureService.getPicture(picId);
		return picture != null ? Msg.success().add("picture", picture) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/getPictures/{pn}",method=RequestMethod.GET)
	public Msg getPictures(@PathVariable("pn")Integer pn){
		PageHelper.startPage(pn, 5);
		List<Picture> list = pictureService.getPictures();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		PageInfo pageInfo = new PageInfo(list, 5);
		return pageInfo != null ? Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/getPictureByDateAndType",method=RequestMethod.POST)
	public Msg getPictureByDateAndType(@RequestBody Picture picture){
		Picture returnPicture = pictureService.getPictureByDateAndType(picture);
		return returnPicture != null ? Msg.success().add("returnPicture", returnPicture) : Msg.fail();
	}

	@ResponseBody
	@RequestMapping(value="/getPictureByDate",method=RequestMethod.POST)
	public Msg getPictureByDate(@RequestBody Picture picture){
		List<Picture> list = pictureService.getPictureByDate(picture);
		return list != null ? Msg.success().add("list", list) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/getOneOfEveryType",method=RequestMethod.GET)
	public Msg getOneOfEveryType(){
		List<Picture> list = pictureService.getOneOfEveryType();
		return list != null ? Msg.success().add("list", list) : Msg.fail();		
	}
	
	@ResponseBody
	@RequestMapping(value="/getAllPicture",method=RequestMethod.GET)
	public Msg getAllPicture(){
		List<Picture> pictures = pictureService.getAllPicture();
		return pictures != null ? Msg.success().add("pictures", pictures) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/getPictureByType", method=RequestMethod.GET)
	public Msg getPictureByType (@RequestParam("picType") Integer picType){
		List<Picture> pictures = pictureService.getPictureByType(picType);
		return pictures != null? Msg.success().add("pictures", pictures) :Msg.fail();
	}
	


	@RequestMapping(value="/downloadPicture",method=RequestMethod.POST)
	public void download(HttpServletResponse response, HttpServletRequest request) throws IOException{
		//获取请求中的参数
		Picture picture = new Picture();
		picture.setPicType(Integer.valueOf(request.getParameter("picType")));
		picture.setYear(Integer.valueOf(request.getParameter("year")));
		picture.setMonth(Integer.valueOf(request.getParameter("month")));
		picture.setDay(Integer.valueOf(request.getParameter("day")));
		
		//根据获取的信息查询对应picture
		Picture returnPicture = pictureService.getPictureByDateAndType(picture);
		String url = returnPicture.getUrl();
		String truthUrl = PathUtil.getRealPath()+"/src/main/webapp"+url.substring(2,url.length());
		File file =  new File(truthUrl);
		if(file.exists()){
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment; filename="+returnPicture.getPicName());
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] by  = new byte[fileInputStream.available()];
			try {
				fileInputStream.read(by);
				OutputStream outputStream = response.getOutputStream();
				outputStream.write(by);
				fileInputStream.close();
				outputStream.close();
			} catch (Exception e) {
				System.out.println("文件下载失败");
			}

		}
	}
}
