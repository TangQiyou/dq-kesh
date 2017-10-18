package com.tqy.bean;

public class Code {
	private int codeId;
	private String codeType;
	private int codeValue;
	private String codeName;
	private String codeDesc;
	

	public Code(int codeId, String codeType, int codeValue, String codeName, String codeDesc) {
		super();
		this.codeId = codeId;
		this.codeType = codeType;
		this.codeValue = codeValue;
		this.codeName = codeName;
		this.codeDesc = codeDesc;
	}


	@Override
	public String toString() {
		return "Code [codeId=" + codeId + ", codeType=" + codeType + ", codeValue=" + codeValue + ", codeName="
				+ codeName + ", codeDesc=" + codeDesc + "]";
	}


	public int getCodeId() {
		return codeId;
	}


	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}


	public String getCodeType() {
		return codeType;
	}


	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}


	public int getCodeValue() {
		return codeValue;
	}


	public void setCodeValue(int codeValue) {
		this.codeValue = codeValue;
	}


	public String getCodeName() {
		return codeName;
	}


	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}


	public String getCodeDesc() {
		return codeDesc;
	}


	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}


	public Code() {
		super();
	}
	
}
