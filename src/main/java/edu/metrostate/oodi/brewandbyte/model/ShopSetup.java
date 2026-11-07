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
		MenuItem coffee = new MenuItem("Coffee", new BigDecimal("3.00"), "Available");
		MenuItem latte = new MenuItem("Latte", new BigDecimal("4.00"), "Available");
		
		List<MenuItem> menuItems = Arrays.asList(coffee,latte);
		Menu menu = new Menu(menuItems);
		Ingredients coffeeBeans = new Ingredients("Coffee Beans", 100, 10, menu);
		Ingredients espresso = new Ingredients("Espresso", 100, 10, menu);
		Ingredients regularMilk = new Ingredients("Regular Milk", 100, 10, menu);
		Ingredients oatMilk = new Ingredients("Oat Milk", 100, 10, menu);
		Ingredients vanillaSyrup = new Ingredients("Vanilla Syrup", 100, 10, menu);
		
		ManagerWarnings managerWarnings = new ManagerWarnings();

		coffeeBeans.addLowStockListener(managerWarnings);
		espresso.addLowStockListener(managerWarnings);
		regularMilk.addLowStockListener(managerWarnings);
		oatMilk.addLowStockListener(managerWarnings);
		vanillaSyrup.addLowStockListener(managerWarnings);
		
		coffee.addIngredient(coffeeBeans, 1);
		latte.addIngredient(espresso, 1);
		
		OrderItem coffeeItem = new OrderItem(coffee, 1, null, "Medium", null, new BigDecimal("3.00"));
		OrderItem latteItem = new OrderItem(latte, 1, oatMilk, "large", vanillaSyrup, new BigDecimal("4.00"));
		
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

