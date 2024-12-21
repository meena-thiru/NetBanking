package com.model;

public class Login {
	private String userId;
	private String password;
	private String customerId;
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String userId, String password, String customerId) {
		super();
		this.userId = userId;
		this.password = password;
		this.customerId = customerId;
	}
	 
	
	
	
}
