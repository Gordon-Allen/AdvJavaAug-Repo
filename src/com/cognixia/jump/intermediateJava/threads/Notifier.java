package com.cognixia.jump.intermediateJava.threads;

//create this class after Waiter
public class Notifier implements Runnable {
	
	private Message msg;
	
	public Notifier(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " started");
		
		try {
			Thread.sleep(1000); // sleep for 1 sec to allow time for waiters to start first
			
			synchronized (msg) {
				
				// change original message so we know it passed through notifier
				msg.setMsg(name + " edited this message");
				
				// try running program with notify first time then comment it out
				// and use notifyAll
				msg.notify();
				//msg.notifyAll();
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
