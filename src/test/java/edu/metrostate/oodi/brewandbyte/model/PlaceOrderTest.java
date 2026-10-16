package edu.metrostate.oodi.brewandbyte.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class PlaceOrderTest {
	
	@Test
	void refusesAnItemThatCannotBeSold() {
		MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");
		
		List<MenuItem> menuItems = Arrays.asList(latte);
		Menu menu = new Menu(menuItems);
		
		Ingredients oatMilk = new Ingredients("Oat Milk", 0, 10, menu);
		oatMilk.markOut();
		
		OrderItem latteItem = new OrderItem(latte, 1, "oat", "large", "none", new BigDecimal("4.00"));
		
		Customer customer = new Customer("Member", "Test Customer", "555-0100");
		
		List<OrderItem> orderItems = Arrays.asList(latteItem);
		
		Order order = new Order(customer, orderItems, "TEST-001", "pending", LocalDateTime.now(), new BigDecimal("4.00"), "");
	}
}
