package com.thread.information;

import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 * 
 * This sample was taken from Java 7 Concurrency Book
 *
 */
public class CalculatorUtils {
	
	public static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
		pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
		pw.printf("Main : Priority: %d\n",thread.getPriority());
		pw.printf("Main : Old State: %s\n",state);
		pw.printf("Main : New State: %s\n",thread.getState());
		pw.printf("Main : ************************************\n");
	}
}
