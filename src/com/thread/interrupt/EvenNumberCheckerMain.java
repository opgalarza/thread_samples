package com.thread.interrupt;

/**
 * 
 * Main class calling the EvenNumberChecker. The thead is started, then the calling
 * thread is put to sleep for 5 seconds. In the meantime, the spawned thread continues
 * its execution until
 *
 */
public class EvenNumberCheckerMain {

	public static void main(String[] args) {
		Thread checker = new EvenNumberChecker(2);
		checker.start();
		try {
			//Put the main thread to sleep.
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// When the main thread wakes up, it will interrupt the spawned thread.
		// When this method is called, the interrupted boolean value of the thread
		// changes to true.
		checker.interrupt();
	}
}