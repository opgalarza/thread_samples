package com.thread.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Non-deamon thread used to populate the deque object with
 * orders.
 * 
 */
public class Waiter implements Runnable{

	private Deque<Order> deque;
	
	public Waiter(Deque<Order> deque){
		this.deque = deque;
	}
	
	@Override
	public void run() {
		int orderNumber = 0;
		for (int i=1; i<100; i++) {
			orderNumber++;
			Order order=new Order();
			order.setOrderDate(new Date());
			order.setOrderRequested("A new dish has been ordered. Order " + orderNumber + " taken by " + Thread.currentThread().getId());
			System.out.println("A new dish has been ordered. Order " + orderNumber + " taken by " + Thread.currentThread().getId());
			deque.addFirst(order);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}