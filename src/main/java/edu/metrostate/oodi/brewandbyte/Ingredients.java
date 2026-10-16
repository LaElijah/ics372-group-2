package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;

public class Ingredients {
	private final String name;
	private final int quantity;
	private final int lowInvThreshold;
	private final List<MenuItem> menuItems;
	
	public Ingredients(String name, int quantity, int lowInvThreshold, List<MenuItem> menuItems) {
		this.name = name;
		this.quantity = quantity;
		this.lowInvThreshold = lowInvThreshold;
		this.menuItems = menuItems;
	}
	
	public List<MenuItem> markOut() {
		throw new UnsupportedOperationException("not implemented");
	}

}
