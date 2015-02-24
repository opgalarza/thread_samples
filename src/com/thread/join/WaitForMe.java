package com.thread.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Thread which sleeps for an x amount of seconds. 
 * Then it resumes activity.
 *
 */
public class WaitForMe implements Runnable{
	
	private int timeToWait;
	
	public WaitForMe(int timeToWait){
		this.timeToWait = timeToWait;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId() + " starting activity at " + new Date());
		try{
			TimeUnit.SECONDS.sleep(timeToWait);
		} catch(InterruptedException e){	
			System.out.println("WaitForMe " + Thread.currentThread().getId() + " has been interrupted.");
		}
		System.out.println(Thread.currentThread().getId() + " finished activity at " + new Date());
	}	
}
