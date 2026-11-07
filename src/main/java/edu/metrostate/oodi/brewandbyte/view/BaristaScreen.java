package edu.metrostate.oodi.brewandbyte.view;

import edu.metrostate.oodi.brewandbyte.model.Order;
import edu.metrostate.oodi.brewandbyte.model.Queue;
import edu.metrostate.oodi.brewandbyte.model.QueueListener;

public class BaristaScreen implements QueueListener {
	@Override
    public void onOrderPlaced(Queue queue) {
        displayQueue(queue);
    }
	
	@Override
    public void onOrderCompleted(Queue queue) {
        displayQueue(queue);
    }
	
	private void displayQueue(Queue queue) {
        System.out.println("Current Order Queue:");

        for (Order order : queue) {
            System.out.println("Order: " + order.getConfirmationNumber());
        }

        System.out.println("--------------------");
    }
}