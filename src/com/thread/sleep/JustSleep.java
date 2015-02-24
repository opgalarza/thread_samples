package com.thread.sleep;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class whose objective is to show only a thread sleeping.
 * When the thread is interrupted, we are not doing anything
 * to handle the interruption, meaning, we let the thread proceed
 * its execution normally and we just send a message saying it was 
 * interrupted.
 *
 */
public class JustSleep implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println(new Date());
			try{
				// Just sleep.
				TimeUnit.SECONDS.sleep(1);
			} catch(InterruptedException e){
				System.out.println("JustSleep has been interrupted.");
				//if you want to finish the execution of the thread when it was
				// interrupted, then we could add a return statement.
				//return;
			}
		}
	}	
}
