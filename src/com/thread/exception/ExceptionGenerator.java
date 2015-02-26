package com.thread.exception;

/**
 * 
 * Simple thread which is used to raise an unchecked exception.
 *
 */
public class ExceptionGenerator implements Runnable {

	@Override
	public void run() {
		String[] names = { "testName" };
		System.out.println(names[1]);
	}
}