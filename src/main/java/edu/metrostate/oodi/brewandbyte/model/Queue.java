package edu.metrostate.oodi.brewandbyte.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

public class Queue implements Iterable<Order> {
	private final List<Order> pendingOrders;
	
	public Queue() {
		this.pendingOrders = new LinkedList<>();
	}
	
	@Override
	public Iterator<Order> iterator() {
	    return Collections.unmodifiableList(pendingOrders).iterator();
	}
	
	public void addOrder(Order order) {
		pendingOrders.add(order);
	}
	
	public void completeOrder(Sales sales) {
		if (!pendingOrders.isEmpty()) {
	        Order order = pendingOrders.get(0);

	        if (!order.consumeIngredients()) {
	            System.out.println("Not enough ingredients to complete this order.");
	            return;
	        }

	        pendingOrders.remove(0);
	        order.markCompleted();

	        sales.addCompletedOrder(order);

	        System.out.println(order.getConfirmationNumber());
	    }
	}
	
	public void displayNextOrder() {
	    if (!pendingOrders.isEmpty()) {
	        Order order = pendingOrders.get(0);

	        System.out.println("Order: " + order.getConfirmationNumber());

	        for (OrderItem item : order.getItems()) {
	            System.out.println("Item: " + item.getMenuItem().getName());
	            System.out.println("Quantity: " + item.getQuantity());
	            System.out.println("Size: " + item.getSize());
	            System.out.println("Milk: " + (item.getMilk() == null ? "None" : item.getMilk().getName()));
	            System.out.println("Syrup: " + (item.getSyrup() == null ? "None" : item.getSyrup().getName()));
	        }

	        System.out.println("Note: " + order.getNote());
	    } else {
	        System.out.println("There are no pending orders.");
	    }
	}
}

