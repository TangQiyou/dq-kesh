package com.tqy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class PropertiesUtil {
	
	synchronized static public String getPropsValueByKey(String name, String key){
		Properties props = new Properties();
		InputStream in = null;
		try {
			//in = Test.class.getClassLoader().getResourceAsStream("../../../dbconfig.properties");
			in = PropertiesUtil.class.getResourceAsStream("../../../"+name+".properties");
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props.getProperty("jdbc.password");
	}
	
//    public static String getProperty(String key){
//        if(null == props) {
//            loadProps();
//        }
//        return props.getProperty(key);
//    }
//
//    public static String getProperty(String key, String defaultValue) {
//        if(null == props) {
//            loadProps();
//        }
//        return props.getProperty(key, defaultValue);
//    }
		
//		        try{
//		             //读取属性文件a.properties
//		             InputStream in = new BufferedInputStream (new FileInputStream("dbconfig.properties"));
//		             prop.load(in);     ///加载属性列表
//		             Iterator<String> it=prop.stringPropertyNames().iterator();
//		             while(it.hasNext()){
//		                 String key=it.next();
//		                 System.out.println(key+":"+prop.getProperty(key));
//		             }
//		             in.close();
//		             
//		             //保存属性到b.properties文件
////		             FileOutputStream oFile = new FileOutputStream("../dbconfig.properties", true);//true表示追加打开
////		             prop.setProperty("phone", "10086");
////		             prop.store(oFile, "The New properties file");
////		             oFile.close();
//		         }
//		       catch(Exception e){
//		            System.out.println(e);
//		         }

}
