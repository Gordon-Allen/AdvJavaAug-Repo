package com.cognixia.jump.intermediateJava.threads;

public class NumbersRun implements Runnable {

	@Override
	public void run() {
		
		System.out.println("Starting Thread: " + Thread.currentThread().getId());
		
		Numbers.print(100);
		
	}

}
