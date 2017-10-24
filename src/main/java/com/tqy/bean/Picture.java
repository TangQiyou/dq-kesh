package com.tqy.bean;

public class Picture {
	private int picId;
	private String picName;
	private int picType;
	private int year;
	private int month;
	private int day;
	private String creatTime;
	private String url;
	private String des;
	private String typeName;
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public int getPicType() {
		return picType;
	}
	public void setPicType(int picType) {
		this.picType = picType;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "Picture [picId=" + picId + ", picName=" + picName + ", picType=" + picType + ", year=" + year
				+ ", month=" + month + ", day=" + day + ", creatTime=" + creatTime + ", url=" + url + ", des=" + des
				+ ", typeName=" + typeName + "]";
	}
	public Picture(int picId, String picName, int picType, int year, int month, int day, String creatTime, String url,
			String des, String typeName) {
		super();
		this.picId = picId;
		this.picName = picName;
		this.picType = picType;
		this.year = year;
		this.month = month;
		this.day = day;
		this.creatTime = creatTime;
		this.url = url;
		this.des = des;
		this.typeName = typeName;
	}
	public Picture() {
		super();
	}

	
	
}
