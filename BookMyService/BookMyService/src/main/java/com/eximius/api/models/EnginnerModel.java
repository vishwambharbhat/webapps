package com.eximius.api.models;

import java.math.BigDecimal;




public class EnginnerModel {
	private long enggContactNumber;
	private String enggName;
	private String enggDesignation;
	private String enggPassword;
	private String enggAddress;
	private int enggPinCode;
	private BigDecimal lattitude;
	private BigDecimal longitude;
	private String imageUrl;
	
	public EnginnerModel() {
		
	}
	public long getEnggContactNumber() {
		return enggContactNumber;
	}
	public void setEnggContactNumber(long enggContactNumber) {
		this.enggContactNumber = enggContactNumber;
	}
	public String getEnggName() {
		return enggName;
	}
	public void setEnggName(String enggName) {
		this.enggName = enggName;
	}
	public String getEnggDesignation() {
		return enggDesignation;
	}
	public void setEnggDesignation(String enggDesignation) {
		this.enggDesignation = enggDesignation;
	}
	public String getEnggPassword() {
		return enggPassword;
	}
	public void setEnggPassword(String enggPassword) {
		this.enggPassword = enggPassword;
	}
	public String getEnggAddress() {
		return enggAddress;
	}
	public void setEnggAddress(String enggAddress) {
		this.enggAddress = enggAddress;
	}
	public int getEnggPinCode() {
		return enggPinCode;
	}
	public void setEnggPinCode(int enggPinCode) {
		this.enggPinCode = enggPinCode;
	}
	public BigDecimal getLattitude() {
		return lattitude;
	}
	public void setLattitude(BigDecimal lattitude) {
		this.lattitude = lattitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString(){
		return enggContactNumber+","+enggName+","+enggDesignation+","+enggPassword+","+enggAddress+","
				+enggPinCode+","+lattitude+","+longitude+","+imageUrl;

	}
}
