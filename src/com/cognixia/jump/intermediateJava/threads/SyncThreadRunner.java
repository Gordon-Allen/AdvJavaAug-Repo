package com.cognixia.jump.intermediateJava.threads;

public class SyncThreadRunner {
	
	public static void main(String[] args) {
		
		// don't bother printing the main thread, just create the loop to
		// start your threads
		for(int i = 0; i < 3; i++) {
			new SyncThread().start();
		}
		
	}

}
