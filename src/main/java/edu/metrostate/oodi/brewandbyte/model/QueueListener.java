package edu.metrostate.oodi.brewandbyte.model;

public interface QueueListener {
    void onOrderPlaced(Queue queue);
    void onOrderCompleted(Queue queue);
}