package com.cognixia.jump.intermediateJava.threads;

public class Waiter implements Runnable {
	
	private Message msg;
	
	public Waiter(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		
		// name of thread we will set when we create it
		String name = Thread.currentThread().getName();
		
		// this will put a lock on the msg object
		synchronized (msg) {
			
			try {
				System.out.println(name + " waiting to get notified at time: " + System.currentTimeMillis());
				msg.wait(); // will go to wait and release lock on msg
				
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			// once notified, regains lock on msg and runs lines of code below
			System.out.println(name + " got notified at time: " + System.currentTimeMillis());
			System.out.println(name + " recieved message: " + msg.getMsg());
		}
		
	}

}
