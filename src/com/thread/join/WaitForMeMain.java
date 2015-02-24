package com.thread.join;

/**
 * 
 * Main class used to show the join feature of threads.
 * Two threads are spawned and each one is put to sleep different amount of time.
 * We do not see the sysout statement until both threads have finished.
 * This is done through the use of the join method. Not until each thread is finished,
 * may the main thread continue its execution.
 *
 */
public class WaitForMeMain {

	public static void main(String[] args) {
		WaitForMe waitingOne = new WaitForMe(3);
		Thread threadOne = new Thread(waitingOne);
		WaitForMe waitingTwo = new WaitForMe(8);
		Thread threadTwo = new Thread(waitingTwo);
		threadOne.start();
		threadTwo.start();
		try {
			// Wait for threadOne to finish its execution.
			threadOne.join();
			// Wait for threadTwo to finish its execution.
			threadTwo.join();
		} catch (InterruptedException e) {
			System.out.println("WaitForMemain has been interrupted");
		}
		// After threadOne and threadTwo has finished, can this 
		// statement be executed.
		System.out.println("Finished the main program.");
	}
}
