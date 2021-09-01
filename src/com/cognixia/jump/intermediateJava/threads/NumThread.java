package com.cognixia.jump.intermediateJava.threads;

public class NumThread extends Thread {

	
	public void run() {
		
		System.out.println("Starting Thread: " + Thread.currentThread().getId());
		
		Numbers.print(100);
		
		super.run();
		
	}
	
	
	
}
