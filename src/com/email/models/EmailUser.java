package com.email.models;

public class EmailUser {
	
	private int userId;
	private String userEmail;
	private String userName;
	private String password;
	
	public EmailUser() {}
	
	public EmailUser(String userEmail, String userName, String password) {
		this.userEmail = userEmail;
		this.userName = userName;
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
