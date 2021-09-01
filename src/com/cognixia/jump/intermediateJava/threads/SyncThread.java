package com.cognixia.jump.intermediateJava.threads;

public class SyncThread extends Thread {
	
	// a counter that will be incremented
	private static int counter = 0;
	
	// synchronized methods will sync the entire method
	public static synchronized void increment() {
		counter++;
	}
	
	public static synchronized void newIncrement() {
		
		counter++;
		System.out.println("Thread " + Thread.currentThread().getId() + 
				": " + counter);
	}
	
	// synchronized with block
	public void incrementBlock() {
		
		// this print will not print synchronously 
		System.out.println("-----");
		
		synchronized (this) {
			counter++;
			System.out.println("Thread " + Thread.currentThread().getId() + 
					": " + counter);
		}
		
	}
	
	public void run() {
		
		System.out.println("Start Thread " + Thread.currentThread().getId());
		
		// create an loop to increment the counter 100 times
		for(int i = 0; i < 100; i++) {
			
			// OPTION 1: increment normally calling method
//			increment();
//			System.out.println("Thread " + Thread.currentThread().getId() + 
//					": " + counter);
			
			// save the file and create SyncThreadRunner to show how it prints
			// scroll through and show how some of the prints are off
			

			// OPTION 2: synchronize the increment and print
			//newIncrement();
			
			// everything should print in order now when you run it
			

			// OPTION 3: synchronize everything using a block instead
			incrementBlock();
			
			// everything inside the block will be synchronized, any code outside of the
			// block will not be synchronized
		}
		
		
	}
	

}

