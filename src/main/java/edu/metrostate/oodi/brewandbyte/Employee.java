package edu.metrostate.oodi.brewandbyte.model;

public class Employee {
	private final String name;
	private final String position;
	private final Sales sales;
	
	public Employee(String name, String position, Sales sales) {
		this.name = name;
		this.position = position;
		this.sales = sales;
	}
}
