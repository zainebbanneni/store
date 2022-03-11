package com.example.demo.controller;

public class LoginForm {
	private String imagename;
	private int userid;

	public LoginForm() {
	}

	public LoginForm(String imagename, int userid) {
		super();
		this.imagename = imagename;
		this.userid = userid;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
