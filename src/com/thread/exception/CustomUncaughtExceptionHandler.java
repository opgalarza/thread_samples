package com.thread.exception;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 
 * Class that implements UncaughtExceptionHandler to be able to handle unchecked
 * exceptions at the thread level. Threads do not allow to declare a throws
 * declaration on the run() method signature. So, in order to handle exceptions
 * wihin the run() method, we need to make use of the UncaughtExceptionHandler
 * interface.
 *
 */
public class CustomUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Here you should write code to "
				+ "handle the exception thrown by the thread.");
	}
}