package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaceOrderTest {
	
	@Test
	void refusesAnItemThatCannotBeSold() {
		MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");
		
		List<MenuItem> menuItems = Arrays.asList(latte);
		Menu menu = new Menu(menuItems);
		
		Ingredients oatMilk = new Ingredients("Oat Milk", 0, 10, menu);
		
		latte.addIngredient(oatMilk, 2);

		OrderItem latteItem = new OrderItem(latte, 1, oatMilk, "large", null, new BigDecimal("4.00"));
		
		Customer customer = new Customer("Member", "Test Customer", "555-0100");
		
		List<OrderItem> orderItems = Arrays.asList(latteItem);
		
		Order order = new Order(customer, orderItems, "TEST-001", "pending", LocalDateTime.now(), new BigDecimal("4.00"), "");
	}
	
	@Test
	void completesOrderAndUsesIngredients() {
	    MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");

	    List<MenuItem> menuItems = Arrays.asList(latte);
	    Menu menu = new Menu(menuItems);

	    Ingredients oatMilk = new Ingredients("Oat Milk", 100, 10, menu);
	    latte.addIngredient(oatMilk, 2);

	    OrderItem latteItem = new OrderItem(
	            latte, 1, oatMilk, "large", null, new BigDecimal("4.00"));

	    Customer customer = new Customer("Member", "Test Customer", "555-0100");
	    List<OrderItem> orderItems = Arrays.asList(latteItem);

	    Order order = new Order(customer, orderItems, "TEST-002",
	            "pending", LocalDateTime.now(), new BigDecimal("4.00"), "");

	    Queue queue = new Queue();
	    queue.addOrder(order);

	    Sales sales = new Sales();
	    queue.completeOrder(sales);

	    assertEquals(96, oatMilk.getQuantity());
	    assertEquals("Completed", order.getStatus());
	}
	
	@Test
	void warnsManagerWhenIngredientIsLow() {
	    MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");

	    Menu menu = new Menu(Arrays.asList(latte));

	    Ingredients oatMilk = new Ingredients("Oat Milk", 12, 10, menu);
	    latte.addIngredient(oatMilk, 2);

	    OrderItem latteItem = new OrderItem(
	            latte, 2, null, "Large", null, new BigDecimal("4.00"));

	    Order order = new Order(
	            new Customer("Member", "Test Customer", "555-0100"),
	            Arrays.asList(latteItem),
	            "TEST-003",
	            "pending",
	            LocalDateTime.now(),
	            new BigDecimal("8.00"),
	            "");

	    assertTrue(order.consumeIngredients());
	    assertEquals(8, oatMilk.getQuantity());
	}
	
	@Test
	void displaysNextOrder() {
	    MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");
	    Menu menu = new Menu(Arrays.asList(latte));

	    Ingredients oatMilk = new Ingredients("Oat Milk", 100, 10, menu);
	    Ingredients vanillaSyrup = new Ingredients("Vanilla Syrup", 100, 10, menu);

	    OrderItem latteItem = new OrderItem(
	            latte, 1, oatMilk, "Large", vanillaSyrup, new BigDecimal("4.00"));

	    Order order = new Order(
	            new Customer("Member", "Test Customer", "555-0100"),
	            Arrays.asList(latteItem),
	            "TEST-004",
	            "pending",
	            LocalDateTime.now(),
	            new BigDecimal("4.00"),
	            "Extra hot");

	    Queue queue = new Queue();
	    queue.addOrder(order);

	    queue.displayNextOrder();
	}
}

