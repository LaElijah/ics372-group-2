package edu.metrostate.oodi.brewandbyte.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Ingredient> ingredients = new HashMap<>();

    public void add(Ingredient ingredient) {
        ingredients.put(ingredient.getName(), ingredient);
    }

    public Ingredient find(String name) {
        return ingredients.get(name);
    }
}
