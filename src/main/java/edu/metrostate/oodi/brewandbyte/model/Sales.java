package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;

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
            soldCounts.put(menuItem.getName(), 0); // getName() belongs to MenuItem
        }

        for (Order order : orders) {
            if (order.getStatus().equals("Completed") && // getStatus() belongs to Order
                order.getDateAndTime().toLocalDate().equals(today)) { // getDateAndTime() belong to Order
                totalMoney = totalMoney.add(order.getTotal()); // getTotal() belong to Order

                for (OrderItem item : order.getItems()) { // getItems() belong to Order
                    String name = item.getMenuItem().getName(); // belong to OrderItem and MenuItem
                    int quantity = item.getQuantity();
                    soldCounts.put(name, soldCounts.get(name) + quantity);
                }
            }
        }
    }
}
