package com.thread.daemon;

import java.util.Date;
import java.util.Deque;

/**
 * 
 * Daemon thread which process all the orders within 
 * the deque object. 
 *
 */
public class Cook extends Thread{
	
	private Deque<Order> deque;
	
	public Cook(Deque<Order> deque) {
		this.deque = deque;
		// Making this thread a daemon. 
		// This method should be called before the start method of the thread.
		// Because we are setting daemon to true, then this daemon thread will
		// be killed if all the non-daemon threads finish their execution. It 
		// will not matter if the daemon thread finished its process, it will
		// be terminated by the JVM.
		setDaemon(true);
	}

	@Override
	public void run() {
		while (true) {
			Date date = new Date();
			clean(date);
		}
	}
	
	/**
	 * Method which removes the orders from the queue.
	 * @param date
	 */
	private void clean(Date date) {
		long difference;
		
		if (deque.size() == 0) {
			return;
		}
		
		do {
			Order o = deque.getLast();
			difference = date.getTime() - o.getOrderDate().getTime();
			if (difference > 2000) {
				System.out.println("Cook got new order and cooking : " + o.getOrderRequested());
				deque.removeLast();
				System.out.println("Cook finished dish : Size of the queue: " + deque.size());
			}
		} while (difference > 2000);
	}
}
