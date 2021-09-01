package com.cognixia.jump.intermediateJava.threads;

import java.util.ArrayList;

public class TakingOrders {

	public static void main(String[] args) {
		
		// give empty arraylist
		Orders orders = new Orders(new ArrayList<String>());
		
		Chef chef1 = new Chef(orders);
		new Thread(chef1, "Chef Ramsey").start();
		
		Chef chef2 = new Chef(orders);
		new Thread(chef2, "Chef Batali").start();
		
		Chef chef3 = new Chef(orders);
		new Thread(chef3, "Chef Flay").start();
		
		Chef chef4 = new Chef(orders);
		new Thread(chef4, "Chef Boyardee").start();
		
		Chef chef5 = new Chef(orders);
		new Thread(chef5, "Chef Child").start();
		
		Server server = new Server(orders);
		new Thread(server, "Server Michael").start();
		
		
	}
}

