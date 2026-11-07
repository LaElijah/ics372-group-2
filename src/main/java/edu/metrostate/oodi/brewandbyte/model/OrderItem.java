package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.util.Map;

public class OrderItem {
	private final MenuItem menuItem;
	private final int quantity;
	private final Ingredient milk;
	private final String size;
	private final Ingredient syrup;
	private final BigDecimal associatedPrice;
	
	public OrderItem(MenuItem menuItem, int quantity, Ingredient milk, String size, Ingredient syrup, BigDecimal associatedPrice) {
		this.menuItem = menuItem;
		this.quantity = quantity;
		this.milk = milk;
		this.size = size;
		this.syrup = syrup;
		this.associatedPrice = associatedPrice;
	}
	
	public BigDecimal calculateSubTotal() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public boolean consumeIngredients() {
		for (Map.Entry<Ingredient, Integer> entry : menuItem.getIngredients().entrySet()) {
	        if (!entry.getKey().hasQuantity(entry.getValue() * quantity)) {
	            return false;
	        }
	    }
		
		if (milk != null && !milk.hasQuantity(2 * quantity)) {
	        return false;
	    }
		
		if (syrup != null && !syrup.hasQuantity(quantity)) {
	        return false;
	    }
		
		for (Map.Entry<Ingredient, Integer> entry : menuItem.getIngredients().entrySet()) {
	        entry.getKey().useQuantity(entry.getValue() * quantity);
	    }
		
		if (milk != null) {
	        milk.useQuantity(2 * quantity);
	    }
		
		if (syrup != null) {
	        syrup.useQuantity(quantity);
	    }
		
		return true;
	}
	
	public boolean canConsumeIngredients() {
	    for (Map.Entry<Ingredient, Integer> entry : menuItem.getIngredients().entrySet()) {
	        if (!entry.getKey().hasQuantity(entry.getValue() * quantity)) {
	            return false;
	        }
	    }

	    if (milk != null && !milk.hasQuantity(2 * quantity)) {
	        return false;
	    }

	    if (syrup != null && !syrup.hasQuantity(quantity)) {
	        return false;
	    }

	    return true;
	}
	
	public BigDecimal getCost() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public MenuItem getMenuItem() {
		return menuItem;
	}
	
	public Ingredient getMilk() {
		return milk;
	}
	
	public String getSize() {
		return size;
	}
	
	public Ingredient getSyrup() {
		return syrup;
	}
	
	public BigDecimal getAssociatedPrice() {
		return associatedPrice;
	}
}

