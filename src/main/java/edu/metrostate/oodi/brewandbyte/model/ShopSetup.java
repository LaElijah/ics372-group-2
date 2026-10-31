package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


public class ShopSetup {

	public static void main(String[] args) {
		MenuItem coffee = new MenuItem("Coffee", new BigDecimal("3.00"), "Available");
		MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");
		
		List<MenuItem> menuItems = Arrays.asList(coffee,latte);
		Menu menu = new Menu(menuItems);
		Ingredients coffeeBeans = new Ingredients("Coffee Beans", 100, 10, menu);
		Ingredients espresso = new Ingredients("Espresso", 100, 10, menu);
		Ingredients regularMilk = new Ingredients("Regular Milk", 100, 10, menu);
		Ingredients oatMilk = new Ingredients("Oat Milk", 100, 10, menu);
		Ingredients vanillaSyrup = new Ingredients("Vanilla Syrup", 100, 10, menu);
		
		coffee.addIngredient(coffeeBeans, 1);
		latte.addIngredient(espresso, 1);
		
		OrderItem coffeeItem = new OrderItem(coffee, 1, null, "Medium", null, new BigDecimal("3.00"));
		OrderItem latteItem = new OrderItem(latte, 1, oatMilk, "large", vanillaSyrup, new BigDecimal("4.00"));
		
		List<OrderItem> orderItems = Arrays.asList(coffeeItem, latteItem);
		
		
		Customer customer = new Customer("Member", "Customer", "555-0100");
		
		Order order = new Order(customer, orderItems, "1001","pending", LocalDateTime.now(), new BigDecimal("7.00"), "");
		
		Queue queue = new Queue();
		queue.addOrder(order);
		
		Sales sales = new Sales();
		
		Employee employee = new Employee("Employee", "Barista", sales, queue);
		
		employee.completeOrder(order);
		sales.viewDaysSales(menu);
		
		
		System.out.println("Brew & Byte is set up");

	}

}

