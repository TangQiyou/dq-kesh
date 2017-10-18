package com.tqy.bean;

public class Announcement {
	private int annId;
	private String annTitle;
	private String annContent;
	private String annTime;
	public int getAnnId() {
		return annId;
	}
	public void setAnnId(int annId) {
		this.annId = annId;
	}
	public String getAnnTitle() {
		return annTitle;
	}
	public void setAnnTitle(String annTitle) {
		this.annTitle = annTitle;
	}
	public String getAnnContent() {
		return annContent;
	}
	public void setAnnContent(String annContent) {
		this.annContent = annContent;
	}
	public String getAnnTime() {
		return annTime;
	}
	public void setAnnTime(String annTime) {
		this.annTime = annTime;
	}
	@Override
	public String toString() {
		return "Announcement [annId=" + annId + ", annTitle=" + annTitle + ", annContent=" + annContent + ", annTime="
				+ annTime + "]";
	}
	public Announcement(int annId, String annTitle, String annContent, String annTime) {
		super();
		this.annId = annId;
		this.annTitle = annTitle;
		this.annContent = annContent;
		this.annTime = annTime;
	}
	public Announcement() {
		super();
	}
	
}
