package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
}
