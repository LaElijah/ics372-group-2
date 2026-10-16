package edu.metrostate.oodi.brewandbyte.model;

import java.util.LinkedList;
import java.util.List;

public class Queue {
	private final List<Order> pendingOrders;
	
	public Queue() {
		this.pendingOrders = new LinkedList<>();
	}
	
	
}
