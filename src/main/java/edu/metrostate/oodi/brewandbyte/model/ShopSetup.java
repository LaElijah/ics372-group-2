package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import edu.metrostate.oodi.brewandbyte.view.ManagerWarnings;
import edu.metrostate.oodi.brewandbyte.view.PickupBoard;
import edu.metrostate.oodi.brewandbyte.view.BaristaScreen;


public class ShopSetup {

	public static void main(String[] args) {
	
	  Inventory inventory = new Inventory();
		MenuItem coffee = new MenuItem("Coffee", new BigDecimal("3.00"), "Available");
		MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");
		
		List<MenuItem> menuItems = Arrays.asList(coffee,latte);
		Menu menu = new Menu(menuItems);
		
		inventory.addIngredient(new Ingredient("Coffee Beans", 100, 10, menu));
		inventory.addIngredient(new Ingredient("Espresso", 100, 10, menu));
		inventory.addIngredient(new Ingredient("Regular Milk", 100, 10, menu));
		inventory.addIngredient(new Ingredient("Oat Milk", 100, 10, menu));
		inventory.addIngredient(new Ingredient("Vanilla Syrup", 100, 10, menu));
		
		ManagerWarnings managerWarnings = new ManagerWarnings();

		inventory.getIngredient("Coffee Beans").addLowStockListener(managerWarnings);
		inventory.getIngredient("Espresso").addLowStockListener(managerWarnings);
		inventory.getIngredient("Regular Milk").addLowStockListener(managerWarnings);
		
		inventory.getIngredient("Oat Milk").addLowStockListener(managerWarnings);
		inventory.getIngredient("Vanilla Syrup").addLowStockListener(managerWarnings);
		
		coffee.addIngredient(inventory.getIngredient("Coffee Beans"), 1);
		latte.addIngredient(inventory.getIngredient("Espresso"), 1);
		
		
		coffee.checkAvailability();
		latte.checkAvailability();
		
		OrderItem coffeeItem = new OrderItem(coffee, 1, null, "Medium", null, new BigDecimal("3.00"));
		OrderItem latteItem = new OrderItem(latte, 1, inventory.getIngredient("Oat Milk"), "large", inventory.getIngredient("Vanilla Syrup"), new BigDecimal("4.00"));
		
		List<OrderItem> orderItems = Arrays.asList(coffeeItem, latteItem);
		
		
		Customer customer = new Customer("Member", "Customer", "555-0100");
		
		Order order = new Order(customer, orderItems, "1001","pending", LocalDateTime.now(), new BigDecimal("7.00"), "");
		
		Queue queue = new Queue();
		
		PickupBoard pickupBoard = new PickupBoard();
		queue.addOrderCompletedListener(pickupBoard);
		
		BaristaScreen baristaScreen = new BaristaScreen();
		queue.addQueueListener(baristaScreen);
		
		queue.addOrder(order);
		
		Sales sales = new Sales();
		
		Employee employee = new Employee("Employee", "Barista", sales, queue);
		
		employee.completeOrder(order);
		sales.viewDaysSales(menu);
		
		
		System.out.println("Brew & Byte is set up");

	}

}

