package com.servus.login;

public class Result {
	String result;
	String message;
	String mail;

	public Result(String result, String message, String mail) {
		super();
		this.result = result;
		this.message = message;
		this.mail = mail;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}