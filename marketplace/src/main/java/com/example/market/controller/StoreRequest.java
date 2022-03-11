package com.example.market.controller;

public class StoreRequest {
	private String imageName;
	private String userId;

	public StoreRequest() {
	}

	public StoreRequest(String imageName, String userId) {
		super();
		this.imageName = imageName;
		this.userId = userId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
