package com.thread.local;

/**
 * 
 * Class which shows the usage of ThreadLocal class.
 * We initialize the threadlocal variable witha a random 
 * double value. So every time this thread is used, it
 * will initialize its own value via the initialValue method.
 * Then, the value can be modified using the set() method. This
 * way, each thread will only be able to see its own value.
 *
 */
public class SumWorker implements Runnable{

	/**
	 * Initialize the value for each instance.
	 */
	private ThreadLocal<Double> threadLocal = new ThreadLocal<Double>(){
		protected Double initialValue(){
			return Math.random();
		}
	};
	
	@Override
	public void run() {
		// Use the set() method to modify the value.
		threadLocal.set(threadLocal.get() + 1);
		System.out.println(threadLocal.get());
	}	
}
