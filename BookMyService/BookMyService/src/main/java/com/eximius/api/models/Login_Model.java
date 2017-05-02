package com.eximius.api.models;

public class Login_Model {
	private long loginNumber;
	private String loginPassword;
	public Login_Model() {
		
	}
	public long getLoginNumber() {
		return loginNumber;
	}
	public void setLoginNumber(long loginNumber) {
		this.loginNumber = loginNumber;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	@Override
	public String toString(){
		return loginNumber+","+loginPassword;
	}
}
