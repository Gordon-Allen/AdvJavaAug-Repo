package com.cognixia.jump.intermediateJava.threads;

public class NumbersRunRunner {

	public static void main(String[] args) {
		
		System.out.println("Main Thread ID: " + Thread.currentThread().getId());
		
		for(int idx = 0; idx < 3; idx++) {
			new Thread(  new NumbersRun()     ).start();
		}
		

	}

}
