package com.servus.db;

public class ServiceType {
	String serviceType;
	String name;

	public ServiceType(String serviceType, String name) {
		this.serviceType = serviceType;
		this.name = name;
	}

	public ServiceType() {
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
