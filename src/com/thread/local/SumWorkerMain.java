package com.thread.local;

/**
 * 
 * Main class used to make the call to the SumWorker runnable class
 * to show how ThreadLocal class works.
 *
 */
public class SumWorkerMain {

	public static void main(String[] args) {
		SumWorker worker = new SumWorker();
		Thread t1 = new Thread(worker);
		Thread t2 = new Thread(worker);
		t1.start();
		t2.start();
	}
}
