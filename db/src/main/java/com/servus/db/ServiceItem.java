package com.servus.db;

public class ServiceItem {
String serviceType;
Integer itemId;
String name;

public ServiceItem(String serviceType, Integer itemId, String name) {
	this.serviceType = serviceType;
	this.itemId = itemId;
	this.name = name;
}

public ServiceItem() {
}

public String getServiceType() {
	return serviceType;
}
public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
}
public Integer getItemId() {
	return itemId;
}
public void setItemId(Integer itemId) {
	this.itemId = itemId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
