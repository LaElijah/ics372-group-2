package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopSetup {

	public static void main(String[] args) {
		MenuItem coffee = new MenuItem("Coffee", new BigDecimal("3.00"), "Available");
		MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");
		
		List<MenuItem> menuItems = Arrays.asList(coffee,latte);
		Menu menu = new Menu(menuItems);
		Ingredients milk = new Ingredients("Milk", 100, 10, menu);
		
		OrderItem coffeeItem = new OrderItem(coffee, 1, "none", "Medium", "none", new BigDecimal("3.00"));
		OrderItem latteItem = new OrderItem(latte, 1, "oat", "large", "vanilla", new BigDecimal("4.00"));
		
		List<OrderItem> orderItems = Arrays.asList(coffeeItem, latteItem);
		
		
		Customer customer = new Customer("Member", "Customer", "555-0100");
		
		Order order = new Order(customer, orderItems, "1001","pending", LocalDateTime.now(), new BigDecimal("7.00"), "");
		
		Queue queue = new Queue();
		
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		Sales sales = new Sales(orders);
		
		Employee employee = new Employee("Employee", "Barista", sales);
		
		
		System.out.println("Brew & Byte is set up");

	}

}
