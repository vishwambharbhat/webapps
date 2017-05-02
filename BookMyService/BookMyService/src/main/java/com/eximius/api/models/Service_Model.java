package com.eximius.api.models;

public class Service_Model {
	private long serviceId;
	private String serviceName;
	public long getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(long servicePrice) {
		this.servicePrice = servicePrice;
	}

	private String serviceDescription;
	private long servicePrice;
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
	@Override
	public String toString(){
		return serviceId+","+serviceName+","+serviceDescription+","+servicePrice;
	}
}
