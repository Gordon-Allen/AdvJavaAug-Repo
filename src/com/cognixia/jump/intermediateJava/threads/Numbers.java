package com.cognixia.jump.intermediateJava.threads;

public class Numbers {
	
	
	static public void print(int max) {

		for(int idx = 0; idx < max; idx++)
			System.out.println("Thread " + Thread.currentThread().getId() + ": " + idx);

	}
	
	
	
	

}
