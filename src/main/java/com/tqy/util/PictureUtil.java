package com.tqy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PictureUtil {
	synchronized public static boolean uploadPicture(MultipartFile file, Integer picType){
		boolean flag = false;
		try {
			OutputStream os = new FileOutputStream(PathUtil.getRealPath()+"/src/main/webapp/img/"+picType+"/"+file.getOriginalFilename());
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
		}
		return flag;
	}
	
	synchronized public static boolean deletePictureOnTheDisk(int picType,String picName){
		boolean flag = false;
		String path = PathUtil.getRealPath()+"/src/main/webapp/img/"+picType+"/"+picName;
		File file = new File(path);
		if (file.isFile() && file.exists()){
			file.delete();
			flag = true;
		} 
		return flag;
	}

	synchronized public static boolean transferPicture(int oldType, int newType, String picName){
		boolean flag = false;
		long startTime = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		System.out.println("复制开始时间："+format.format(new Date()));
		try {
			InputStream is = new  FileInputStream(PathUtil.getRealPath()+"/src/main/webapp/img/"+oldType+"/"+picName);
			OutputStream os = new FileOutputStream(PathUtil.getRealPath()+"/src/main/webapp/img/"+newType+"/"+picName);
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
			System.out.println("上传转移失败");
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime-startTime;
		System.out.println("复制结束时间："+format.format(new Date()));
		System.out.println("程序运行时间："+String.valueOf(totalTime)+"ms");
		return flag;
	}
}
