package com.eximius.api.models;

import java.math.BigDecimal;
import java.util.Date;


public class OrderModel {
	
	private Date dateOfApplied;
	private Date dateOfOrder;
	private String timeOfOrder;
	private String serviceName;
	private String orderAddress;
	private int orderPinCode;
	private BigDecimal lattitude;
	private BigDecimal longitude;
	private long userContact;
	private long enggContact;
	private long orderId;
	private String orderDescription;
	private Date acceptDate;
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public Date getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}
	public OrderModel() {
		
	}
	public Date getDateOfApplied() {
		return dateOfApplied;
	}
	public void setDateOfApplied(Date dateOfApplied) {
		this.dateOfApplied = dateOfApplied;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getTimeOfOrder() {
		return timeOfOrder;
	}
	public void setTimeOfOrder(String timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public int getOrderPinCode() {
		return orderPinCode;
	}
	public void setOrderPinCode(int orderPinCode) {
		this.orderPinCode = orderPinCode;
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
	public long getUserContact() {
		return userContact;
	}
	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}
	public long getEnggContact() {
		return enggContact;
	}
	public void setEnggContact(long enggContact) {
		this.enggContact = enggContact;
	}
	
	@Override
	public String toString(){
		return dateOfApplied+","+dateOfOrder+","+timeOfOrder+","+serviceName+","+orderAddress+","
				+orderPinCode+","+lattitude+","+longitude+","+userContact+","+enggContact+","+orderId;

	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
