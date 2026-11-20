package edu.metrostate.oodi.brewandbyte.model;

public class Ingredient {
    private final String name;
    private int quantity;

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public boolean isOut() { return quantity == 0; }
    public void markOut() { quantity = 0; }
    public void restock(int amount) { quantity += amount; }
}
