package com.cognixia.jump.intermediateJava.threads;

import java.util.List;

public class Orders {
	
	private List<String> orderList;
	
	public Orders(List<String> orderList) {
		this.orderList = orderList;
	}

	public List<String> getMenuItems() {
		return orderList;
	}

	public void setMenuItems(List<String> menuItems) {
		this.orderList = menuItems;
	}
	
	public String nextOrder() {
		
		String order = null;
		
		if(!orderList.isEmpty()) {
			order = orderList.get(0);
			orderList.remove(0);			
		}
		
		return order;
	}
	
	public void addOrder(String order) {
		orderList.add(order);
	}

	@Override
	public String toString() {
		StringBuilder orders = new StringBuilder();

		if (!orderList.isEmpty()) {
			for (int order = 0; order < orderList.size() - 1; order++) {

				orders.append(orderList.get(order) + ", ");
			}
			orders.append("and " + orderList.get(orderList.size() - 1));
		}

		return orders.toString();

	}
	
}
