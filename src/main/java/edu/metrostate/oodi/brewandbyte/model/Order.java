package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Collections;

public class Order {
	private final Customer customer;
	private final List<OrderItem> items;
	private final String confirmationNumber;
	private String status;
	private final LocalDateTime dateAndTime;
	private BigDecimal total;
	private String note;
	
	public Order(Customer customer, List<OrderItem> items,
				 String confirmationNumber, String status, LocalDateTime dateAndTime,
				 BigDecimal total, String note) {
		this.customer = customer;
		this.items = items;
		this.confirmationNumber = confirmationNumber;
		this.status = status;
		this.dateAndTime = dateAndTime;
		this.total = total;
		this.note = note;
	}

	public List<OrderItem> getItems() {
		return Collections.unmodifiableList(items);
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

	public void addItem(OrderItem item) {
		throw new UnsupportedOperationException("not implemented");
	}

	public void removeItem(OrderItem item) {
		throw new UnsupportedOperationException("not implemented");
	}

	public BigDecimal calculateTotal() {
		throw new UnsupportedOperationException("not implemented");
	}
}
