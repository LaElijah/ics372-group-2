package edu.metrostate.oodi.brewandbyte.model;

public class Employee {
	private final String name;
	private final String position;
	private final Sales sales;
	private final Queue queue;
	
	public Employee(String name, String position, Sales sales, Queue queue) {
		this.name = name;
		this.position = position;
		this.sales = sales;
		this.queue = queue;
	}
	
	public Order createOrder(OrderItem[] items) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void viewOrder(Order order) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void completeOrder(Order order) {
		queue.completeOrder(sales);
	}
}
