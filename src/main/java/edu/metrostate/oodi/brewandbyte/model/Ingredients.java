package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;

public class Ingredients {
	private final String name;
	private final int quantity;
	private final int lowInvThreshold;
	private final Menu menu;
	
	public Ingredients(String name, int quantity, int lowInvThreshold, Menu menu) {
		this.name = name;
		this.quantity = quantity;
		this.lowInvThreshold = lowInvThreshold;
		this.menu = menu;
	}
	
	public List<MenuItem> markOut() {
		throw new UnsupportedOperationException("not implemented");
	}

}
