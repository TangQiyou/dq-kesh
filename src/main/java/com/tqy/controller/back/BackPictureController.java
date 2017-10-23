package com.tqy.controller.back;

import java.util.List;

import java.util.Map;

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
	public Msg addOnlyPicture(@RequestParam("file") MultipartFile file,@RequestParam("picType") Integer pic_type){
		Map<String, Integer> map = pictureService.addOnlyPicture(file,pic_type);
		Msg msg = Msg.success();
		int pic_id = map.get("pic_id");
		msg.add("pic_id", pic_id);
		msg.add("totalTime", map.get("totalTime").toString()+"ms");
		return pic_id != -1 ? msg : Msg.fail();
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
	
	/**
	 * 默认返回种类ID为101的第一页图片
	 * @param map 包含 pn 页数，pic_type:图片种类对应的值
	 * @return 包含指定页、种类的Msg
	 */
	@ResponseBody
	@RequestMapping(value="/getPictureByType",method=RequestMethod.POST)
	public Msg getPictureByType(@RequestBody Map<String, Object> map){
		PageHelper.startPage(map.get("pn")==null?1:Integer.parseInt(map.get("pn").toString()), 5);
		List<Picture> list = pictureService.getPictureByType(map.get("picType")==null?101:Integer.parseInt(map.get("picType").toString()));
		@SuppressWarnings({ "unchecked", "rawtypes" })
		PageInfo pageInfo = new PageInfo(list, 5);
		return pageInfo != null ? Msg.success().add("pageInfo", pageInfo) : Msg.fail();
	}
	
	@ResponseBody
	@RequestMapping(value="/getPictureByDateAndType",method=RequestMethod.POST)
	public Msg getPictureByDateAndType(@RequestBody Picture picture){
		Picture returnPicture = pictureService.getPictureByDateAndType(picture);
		return returnPicture != null ? Msg.success().add("picture", returnPicture) : Msg.fail();
	}
	
	
}
