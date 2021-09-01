package com.cognixia.jump.intermediateJava.threads;

public class Server implements Runnable {
	
	private Orders orders;
	
	public Server(Orders orders) {
		this.orders = orders;
	}

	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " taking orders");
		
		try {
			Thread.sleep(3000);
			
			synchronized (orders) {
				
				orders.addOrder("pizza");
				orders.addOrder("pasta");
				orders.addOrder("soup");
				orders.addOrder("salad");
				
				System.out.println(name + " has taken orders for " + orders);
				
				//orders.notify();
				orders.notifyAll();
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
}