package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;


class Ingredient
{
	private final String name;
	private int quantity;
	private final int lowInvThreshold;
	private final Menu menu;
	private final List<LowStockListener> listeners = new ArrayList<>();
	public void addLowStockListener(LowStockListener listener) {
        listeners.add(listener);
    }
    
    
  public Ingredient(String name, int quantity, int lowInvThreshold, Menu menu) {
		this.name = name;
		this.quantity = quantity;
		this.lowInvThreshold = lowInvThreshold;
		this.menu = menu;
	}
	
	public List<MenuItem> markOut() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public boolean useQuantity(int amount) {
		if (quantity < amount) {
			return false;
		}
		
		quantity -= amount;
		
        if (isLow()) {
            for (LowStockListener listener : listeners) {
                 listener.onLowStock(this);
            }
        }
		
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
