package com.servus.db;

public class Message {
	String mail;
	String code;
	
	
	
	
	public Message(String mail, String code) {
		this.mail = mail;
		this.code = code;
	}
	
	
	
	
	
	public Message() {
	}





	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
