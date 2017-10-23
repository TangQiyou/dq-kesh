package com.tqy.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tqy.bean.Code;
import com.tqy.bean.Picture;
import com.tqy.dao.CodeMapper;
import com.tqy.dao.PictureMapper;
import com.tqy.util.PictureUtil;

@Service
public class PictureService {
	
	@Autowired
	PictureMapper pictureMapper;
	
	@Autowired
	CodeMapper codeMapper;
	
	public boolean addPicture(Picture picture){
		Code code = codeMapper.getCodeByvalue(picture.getPicType());
		String des = code.getCodeDesc();
		String describe = picture.getYear()+"年"+picture.getMonth()+"月"+picture.getDay()+"日"+des;
		picture.setDes(describe.toString());
		//System.out.println(picture);
		int flag = pictureMapper.addPicture(picture);
		return flag == 1 ? true : false; 
	}
	
	public Map<String, Integer> addOnlyPicture(MultipartFile file, Integer pic_type){
		long startTime = System.currentTimeMillis();
		int pic_id = -1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pic_id", pic_id);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		System.out.println("开始时间："+format.format(new Date()));
		boolean flag = PictureUtil.uploadPicture(file, pic_type);
		if (!flag){
			return map;
		}
		Picture picture = new Picture();
		picture.setPicType(pic_type);
		picture.setUrl("../img/"+pic_type+"/"+file.getOriginalFilename());
		picture.setPicName(file.getOriginalFilename());
		try {
			pictureMapper.addOnlyPicture(picture);
			pic_id = picture.getPicId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime-startTime;
		System.out.println("结束时间："+format.format(new Date()));
		System.out.println("程序运行时间："+String.valueOf(endTime-startTime)+"ms");
		map.put("totalTime", Integer.valueOf(String.valueOf(totalTime)));
		map.put("pic_id", pic_id);
		return map;
	}
	
	public boolean deletePicture(int p_id){
		Picture picture = pictureMapper.getPicture(p_id);
		boolean deleteOnTheDiskFlag = PictureUtil.deletePictureOnTheDisk(picture.getPicType(), picture.getUrl().substring(11));
		if (!deleteOnTheDiskFlag){
			return false;
		}
		int flag = pictureMapper.deletePicture(p_id);
		return flag == 1 ? true : false; 
	}
	
	public boolean updatePicture(Picture picture){
		//查询修改前的图片属性，好做对比
		Picture oldPicture = pictureMapper.getPicture(picture.getPicId());
		boolean transFlag = false;
		boolean deleteFlag = false;
		//如果种类发生了变化，需要改变存的路径,然后将文件复制到新路径，最后删除原文件
		if (oldPicture.getPicType() != picture.getPicType()){
			String realPicName = oldPicture.getUrl().substring(11);
			transFlag = PictureUtil.transferPicture(oldPicture.getPicType(), picture.getPicType(), realPicName);
			if (!transFlag) return false;
			deleteFlag = PictureUtil.deletePictureOnTheDisk(oldPicture.getPicType(), realPicName);
			if (!deleteFlag) return false;
			picture.setUrl("../img/"+picture.getPicType()+"/"+realPicName);
		} else {
			picture.setUrl(oldPicture.getUrl());
		}
		//设置其他属性
		Code code = codeMapper.getCodeByvalue(picture.getPicType());
		String des = code.getCodeDesc();
		String describtion = picture.getYear()+"年"+picture.getMonth()+"月"+picture.getDay()+des;
		picture.setDes(describtion);
		int flag = pictureMapper.updatePicture(picture);
		return flag == 1 ? true : false;
	}
	
	public Picture getPicture(int p_id){
		Picture picture = pictureMapper.getPicture(p_id);
		return picture;
	}
	
	public List<Picture> getPictures(){
		List<Picture> list = pictureMapper.getPictures();
		return list;
	}
	
	public Picture getPictureByDateAndType(Picture picture){
		Picture returnPicture = pictureMapper.getPictureByDateAndType(picture);
		return returnPicture;
	}
	
	public List<Picture> getPictureByDate(Picture picture){
		List<Picture> returnList = pictureMapper.getPictureByDate(picture);
		return returnList;
	}
	
	public List<Picture> getPictureByType(int pic_type){
		List<Picture> returnList = pictureMapper.getPictureByType(pic_type);
		return returnList;
	}
	
	public List<Picture> getOneOfEveryType(){
		List<Code> codes = codeMapper.getCodeByType("pic_type");
		List<Picture> returnList = new ArrayList<Picture>();
		Picture picture = new Picture();
		for (Code code:codes){
			picture = pictureMapper.getOneOfEveryType(code.getCodeValue());
			if(picture != null){
				returnList.add(picture);
			}
			picture = null;
		}
		return returnList;
	}
	
	public List<Picture> getAllPicture(){
		List<Picture> list = pictureMapper.getAllPicture();
		return list;
	}
}
