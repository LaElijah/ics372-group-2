package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;

public class Sales {
	private final List<Order> orders;
	
	public Sales(List<Order> orders) {
		this.orders = orders;
	}
}
