package com.thread.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Main class used to show how daemon threads are terminated 
 * when all the non-deamon threads finish, the jvm basically 
 * terminates them. The example below uses a waiter thread(non-deamon thread)
 * to place orders in the dequeu object and the cook thread(deamon thread)
 * to remove orders fromt he deque object.
 *
 */
public class OrderMain {

	public static void main(String[] args) {
		Deque<Order> deque=new ArrayDeque<Order>();
		
		Waiter waiter = new Waiter(deque);
		for (int i = 0; i<3; i++){
			Thread thread = new Thread(waiter);
			thread.start();
			System.out.println(thread.getId());
		}
		Cook cook = new Cook(deque);
		cook.start();
	}
}