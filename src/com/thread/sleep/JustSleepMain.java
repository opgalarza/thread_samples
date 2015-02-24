package com.thread.sleep;

import java.util.concurrent.TimeUnit;

/**
 * Main class calling JustSleep thread to demostrate the sleep feature.
 * This main thread sleeps after calling the start method for the 
 * JustSleep thread.
 *
 */
public class JustSleepMain {

	public static void main(String[] args) {
		JustSleep sleeper = new JustSleep();
		Thread thread = new Thread(sleeper);
		thread.start();
		try{
			// Just sleep
			TimeUnit.SECONDS.sleep(5);
		} catch(InterruptedException e){
			e.printStackTrace();
			System.out.println("JustSleepMain has been interrupted.");
		}
		// Interrupt the spawned thread.
		thread.interrupt();
	}
}