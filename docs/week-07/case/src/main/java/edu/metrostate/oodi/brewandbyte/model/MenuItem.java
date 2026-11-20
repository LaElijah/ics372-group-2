package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;

public class MenuItem {
    private final String name;
    private int priceInCents;
    private final List<Ingredient> ingredients;

    public MenuItem(String name, int priceInCents, List<Ingredient> ingredients) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.ingredients = List.copyOf(ingredients);
    }

    public String getName() { return name; }
    public int getPriceInCents() { return priceInCents; }
    public void setPriceInCents(int priceInCents) { this.priceInCents = priceInCents; }
    public List<Ingredient> getIngredients() { return ingredients; }
}
