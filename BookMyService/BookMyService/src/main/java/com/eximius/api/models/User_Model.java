package com.eximius.api.models;

public class User_Model {
	private String userName;
	private long userContactNumber;
	private String userPassword;
public User_Model() {
	
}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserContactNumber() {
		return userContactNumber;
	}
	public void setUserContactNumber(long userContactNumber) {
		this.userContactNumber = userContactNumber;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString(){
		return userName+","+userContactNumber+","+userPassword;

	}
}
