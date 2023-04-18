package com.polus_plus.tmedic.POJO.UserOrder;

public class OrderPatients {
	String name;
	OrderPatientsItems[] items;
	
	public OrderPatients(String name, OrderPatientsItems[] items) {
		this.name = name;
		this.items = items;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public OrderPatientsItems[] getItems() {
		return items;
	}
	public void setItems(OrderPatientsItems[] items) {
		this.items = items;
	}
}