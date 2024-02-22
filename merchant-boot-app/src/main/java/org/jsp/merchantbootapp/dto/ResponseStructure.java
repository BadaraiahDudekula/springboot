package org.jsp.merchantbootapp.dto;

public class ResponseStructure<T> {
	private String meassage;
	private T data;
	private int statusCode;
	public String getMeassage() {
		return meassage;
	}
	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
