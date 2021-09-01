package com.cognixia.jump.intermediateJava.threads;

public class WaitAndNotify {

	public static void main(String[] args) {

		// create message to be passed as a resource to both Waiters and Notifier
		Message msg = new Message("new message");
		
		// create 2 waiters
		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter1").start();

		Waiter waiter2 = new Waiter(msg);
		new Thread(waiter2, "waiter2").start();

		// put in notifier
		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		
		System.out.println("All the threads are started");

	}

}
