package com.tqy.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import com.tqy.util.PathUtil;

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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		System.out.println("开始时间："+format.format(new Date()));
		int pic_id = -1;
		try {
			OutputStream os = new FileOutputStream(PathUtil.getRealPath()+"/src/main/webapp/img/"+pic_type+"/"+file.getOriginalFilename());
			InputStream is = file.getInputStream();
			int temp;
			while ((temp=is.read())!=(-1)){
				os.write(temp);
			}
			os.flush();
			os.close();
			is.close();
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("上传文件失败");
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime-startTime;
		System.out.println("结束时间："+format.format(new Date()));
		System.out.println("程序运行时间："+String.valueOf(endTime-startTime)+"ms");
		Map<String, Integer> map = new HashMap<>();
		map.put("pic_id", pic_id);
		map.put("totalTime", Integer.valueOf(String.valueOf(totalTime)));
		return map;
	}
	
	public boolean deletePicture(int p_id){
		int flag = pictureMapper.deletePicture(p_id);
		return flag == 1 ? true : false; 
	}
	
	public boolean updatePicture(Picture picture){
		Picture oldPicture = pictureMapper.getPicture(picture.getPicId());
		if (oldPicture.getPicType() != picture.getPicType()){
			picture.setUrl("../img/"+oldPicture.getPicName());
		}
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
		List<Picture> returnList = new ArrayList<>();
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
}
