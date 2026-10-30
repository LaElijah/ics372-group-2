package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sales {
	private final List<Order> orders;
	
	public Sales(List<Order> orders) {
		this.orders = orders;
	}
	public void viewDaysSales(Menu menu) {
        LocalDate today = LocalDate.now();
        Map<String, Integer> soldCounts = new LinkedHashMap<>();
        BigDecimal totalMoney = BigDecimal.ZERO;

        for (MenuItem menuItem : menu.getMenuItems()) {
            soldCounts.put(menuItem.getName(), 0); 
        }

        for (Order order : orders) {
            if (order.getStatus().equals("Completed") && 
                order.getDateAndTime().toLocalDate().equals(today)) { 
                totalMoney = totalMoney.add(order.getTotal()); 

                for (OrderItem item : order.getItems()) { 
                    String name = item.getMenuItem().getName(); 
                    int quantity = item.getQuantity();
                    soldCounts.put(name, soldCounts.get(name) + quantity);
                }
            }
        }
    }
}
