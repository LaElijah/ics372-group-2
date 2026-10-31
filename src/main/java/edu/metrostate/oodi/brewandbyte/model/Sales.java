package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sales {
	private final List<Order> orders = new ArrayList<>();
	
	public Sales() {
	}
	
	public void addCompletedOrder(Order order) {
		orders.add(order);
	}
	
	public int countItemsSoldToday() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void viewDaysSales(Menu menu) {
	    LocalDate today = LocalDate.now();
	    Map<String, Integer> soldCounts = new LinkedHashMap<>();
	    BigDecimal totalMoney = BigDecimal.ZERO;

	    for (MenuItem menuItem : menu.getMenuItems()) {
	        soldCounts.put(menuItem.getName(), 0); 
	    }

	    boolean ordersCompletedToday = false;
	    
	    for (Order order : orders) {
	        if (order.getStatus().equals("Completed") &&
	        	order.getCompletedAt() != null &&
	            order.getCompletedAt().toLocalDate().equals(today)) { 
	        	
	        	ordersCompletedToday = true;
	        	
	            totalMoney = totalMoney.add(order.getTotal()); 

	            for (OrderItem item : order.getItems()) { 
	                String name = item.getMenuItem().getName();
	                int quantity = item.getQuantity();
	                soldCounts.put(name, soldCounts.get(name) + quantity);
	            }
	        }
	    }
	    
	    if (!ordersCompletedToday) {
            System.out.println("No orders were completed today.");
        }
	    
	    for (Map.Entry<String, Integer> entry : soldCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " sold");
        }
	    
	    System.out.println("Total sales today: $" + totalMoney);
	}
}

