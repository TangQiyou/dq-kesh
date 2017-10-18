package com.tqy.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

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
		System.out.println(picture);
		int flag = pictureMapper.addPicture(picture);
		return flag == 1 ? true : false; 
	}
	
	public boolean addOnlyPicture(MultipartFile file){
		Boolean flag = false;
		long startTime = System.currentTimeMillis();
		System.out.println("开始时间："+startTime);	
		try {
			OutputStream os = new FileOutputStream(PathUtil.getRealPath()+"/dq-kesh/WebContent/img/101/"+file.getOriginalFilename());
			InputStream is = file.getInputStream();
			int temp;
			while ((temp=is.read())!=(-1)){
				os.write(temp);
			}
			os.flush();
			os.close();
			is.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("上传文件失败");
		} finally {
			flag=true;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("结束时间："+endTime);
		System.out.println("程序运行时间："+String.valueOf(endTime-startTime)+"ms");
		return flag;
	}
	
	public boolean deletePicture(int p_id){
		int flag = pictureMapper.deletePicture(p_id);
		return flag == 1 ? true : false; 
	}
	
	public boolean updatePicture(Picture picture){
		Code code = codeMapper.getCodeByvalue(picture.getPicType());
		String des = code.getCodeDesc();
		String describe = picture.getYear()+"年"+picture.getMonth()+"月"+picture.getDay()+des;
		picture.setDes(describe);
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
}
