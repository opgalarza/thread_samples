package com.thread.daemon;

import java.util.Date;

public class Order {
	
	private Date orderDate;
	
	private String orderRequested;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderRequested() {
		return orderRequested;
	}

	public void setOrderRequested(String orderRequested) {
		this.orderRequested = orderRequested;
	}	
}
