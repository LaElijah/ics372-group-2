package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class Order {
	private final Customer customer;
	private final List<OrderItem> items;
	private final String confirmationNumber;
	private String status;
	private final LocalDateTime dateAndTime;
	private LocalDateTime completedAt;
	private BigDecimal total;
	private String note;
	
	public Order(Customer customer, List<OrderItem> items,
				 String confirmationNumber, String status, LocalDateTime dateAndTime,
				 BigDecimal total, String note) {
		this.customer = customer;
		this.items = new ArrayList<>(items);
		this.confirmationNumber = confirmationNumber;
		this.status = status;
		this.dateAndTime = dateAndTime;
		this.total = total;
		this.note = note;
	}
	
	public List<OrderItem> getItems() {
		return Collections.unmodifiableList(items);
	}
	
	public String getNote() {
		return note;
	}
	
	public String getConfirmationNumber() {
		return confirmationNumber;
	}
	
	public String getStatus() {
		return status;
	}
	
	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}
	
	public BigDecimal getTotal() {
		return total;
	}
	
	public void markCompleted() {
		status = "Completed";
		completedAt = LocalDateTime.now();
	}
	
	public LocalDateTime getCompletedAt() {
		return completedAt;
	}
	
	public void addItem(OrderItem item) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void removeItem(OrderItem item) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public BigDecimal calculateTotal() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public boolean consumeIngredients() {
		Map<Ingredients, Integer> required = new LinkedHashMap<>();

	    for (OrderItem item : items) {
	        int quantity = item.getQuantity();

	        for (Map.Entry<Ingredients, Integer> entry :
	                item.getMenuItem().getIngredients().entrySet()) {
	            required.merge(entry.getKey(),
	                    entry.getValue() * quantity, Integer::sum);
	        }

	        if (item.getMilk() != null) {
	            required.merge(item.getMilk(), 2 * quantity, Integer::sum);
	        }

	        if (item.getSyrup() != null) {
	            required.merge(item.getSyrup(), quantity, Integer::sum);
	        }
	    }

	    for (Map.Entry<Ingredients, Integer> entry : required.entrySet()) {
	        if (!entry.getKey().hasQuantity(entry.getValue())) {
	            return false;
	        }
	    }

	    for (Map.Entry<Ingredients, Integer> entry : required.entrySet()) {
	        Ingredients ingredient = entry.getKey();
	        ingredient.useQuantity(entry.getValue());

	        if (ingredient.isLow()) {
	            System.out.println("Manager warning: " + ingredient.getName() + " is running low.");
	        }
	    }

	    return true;
	}
}

