package edu.metrostate.oodi.brewandbyte.view;

import edu.metrostate.oodi.brewandbyte.model.Order;
import edu.metrostate.oodi.brewandbyte.model.OrderCompletedListener;

public class PickupBoard implements OrderCompletedListener {
	@Override
    public void onOrderCompleted(Order order) {
        System.out.println("Order: " + order.getConfirmationNumber());
    }
}
