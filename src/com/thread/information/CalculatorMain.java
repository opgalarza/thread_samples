package com.thread.information;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 * 
 * This sample was taken from Java 7 Concurrency Book
 * The purpose of this class is to show the basic information of a thread.
 * It displays the id and the status of the thread as it moves from old state to new state.
 * 
 * NOTE: change the log file path in order for it to work properly. I hard coded it to my local directory in 
 * a linux system.
 */
public class CalculatorMain {

	public static void main(String[] args) throws IOException {
		Thread[] threads = new Thread[10];
		Thread.State[] state = new Thread.State[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			
			if ((i % 2) == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread " + i);
		}
		try (FileWriter file = new FileWriter("/home/frankie/workspace/log.txt");
			 PrintWriter pw = new PrintWriter(file);) {
			
			/**
			 * Write to the file the initial status of the threads.
			 */
			for (int i = 0; i < 10; i++) {
				pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
				state[i] = threads[i].getState();
			}
			
			/**
			 * Start each thread.
			 */
			for (int i=0; i<10; i++){
				threads[i].start();
			}
			
			boolean finish = false;
			
			
			while (!finish) {
				/**
				 * For each thread, check the state. If it changed, then write the status in the file.
				 */
				for (int i = 0; i<10; i++){
					if (threads[i].getState() != state[i]) {
						CalculatorUtils.writeThreadInfo(pw, threads[i],state[i]);
						state[i]=threads[i].getState();
					}
				}
				
				finish=true;
				
				/**
				 * If all threads are terminated, then finish is true.
				 */
				for (int i = 0; i<10; i++){
					finish = finish && (threads[i].getState() == State.TERMINATED);
				}
			}
		}
	}
	
	
}
