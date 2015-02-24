package com.thread.interrupt;


/**
 * Thread used to check whether a number is even or odd. 
 * It also handles when a thread has been interrupted by 
 * making use of isInterrupted() method. If it is interrupted,
 * then it will handle the interruption and quit the execution of the 
 * thread.
 *
 */
public class EvenNumberChecker extends Thread{
	
	private int number;

	public EvenNumberChecker(int number){
		this.number = number;
	}
	/**
	 * 
	 */
	@Override
	public void run() {
		while (true) {
			if (isEven(number)) {
				System.out.println("Number " + number + " is Even");
			}
			
			// The isInterrupted() method only returns the value of the 
			// interrupted boolean value of the thread.
			if (isInterrupted()) {
				System.out.println("The EvenNumberChecker has been Interrupted");
				return;
			}
			number++;
		}
	}
	
	/**
	 * 
	 * @param number
	 * @return true if its an even number. otherwise false.
	 */
	private boolean isEven(long number) {
		return ((number%2) == 0)?true:false;
	}	
}
