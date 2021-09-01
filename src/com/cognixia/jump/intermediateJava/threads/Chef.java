package com.cognixia.jump.intermediateJava.threads;

import java.util.concurrent.ThreadLocalRandom;

public class Chef implements Runnable {

private Orders orders;
	
	public Chef(Orders orders) {
		this.orders = orders;
	}

	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		String orderItem = null;
		
		System.out.println(name + " waiting for an order to prepare");
		
		synchronized (orders) {
			
			try {
				
				//System.out.println(name + " waiting for an order to prepare");
				orders.wait();
				
				orderItem = orders.nextOrder();
				
				if (orderItem != null) {
					System.out.println(name + " received order for " + orderItem);
				}
				else {
					System.out.println("No orders to take, " + name + " can rest");
				}
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		if (orderItem != null) {
			try {
				System.out.println(name + " preparing " + orderItem);
				Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
				System.out.println(name + " completed order for " + orderItem);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
	}
}

