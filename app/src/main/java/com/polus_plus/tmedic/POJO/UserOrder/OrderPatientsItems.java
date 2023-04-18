package com.polus_plus.tmedic.POJO.UserOrder;

public class OrderPatientsItems {
	int catalog_id;
	String price;
	
	public OrderPatientsItems(int catalog_id, String price) {
		this.catalog_id = catalog_id;
		this.price = price;
	}
	
	public int getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}