package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;


public class Ingredients {
	private final String name;
	private int quantity;
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
	
	public boolean useQuantity (int amount) {
		if (quantity < amount) {
			return false;
		}
		
		quantity -= amount;
		return true;
	}
	
	public boolean hasQuantity(int amount) {
		return quantity >= amount;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public boolean isLow() {
		return quantity < lowInvThreshold;
	}

}


