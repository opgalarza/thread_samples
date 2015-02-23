package com.thread.information;

/**
 * 
 * This sample was taken from Java 7 Concurrency Book
 *
 */
public class Calculator implements Runnable{

	private int number;
	
	public Calculator(int number){
		this.number = number;
	}
	
	@Override
	public void run(){
		for(int i = 1;i <= 10; i++){
			int result = number * i;
			System.out.println(Thread.currentThread().getName() + " : " + number + " * " + i + " = " + result);
		}
	}
}