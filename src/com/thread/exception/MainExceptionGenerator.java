package com.thread.exception;

/**
 * 
 * Main class used to show how to set the exception handler for a thread by
 * using the setUncaughtExceptionHandler(UncaughtExceptionHandler) method.
 *
 */
public class MainExceptionGenerator {

	public static void main(String[] args) {
		ExceptionGenerator exceptionGenerator = new ExceptionGenerator();
		Thread thread = new Thread(exceptionGenerator);
		// The exception handler must be set before calling the start() method.
		thread.setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
		thread.start();
	}
}