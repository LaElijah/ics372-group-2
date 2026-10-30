package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;

public class OrderItem {
	private final MenuItem menuItem;
	private final int quantity;
	private final String milk;
	private final String size;
	private final String syrup;
	private final BigDecimal associatedPrice;
	
	public OrderItem(MenuItem menuItem, int quantity, String milk, String size, String syrup, BigDecimal associatedPrice) {
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

	public BigDecimal getCost() {
		throw new UnsupportedOperationException("not implemented");
	}

	public int getQuantity() {
		return quantity;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}
}
