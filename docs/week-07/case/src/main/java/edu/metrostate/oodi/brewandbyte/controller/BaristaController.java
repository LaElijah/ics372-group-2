package edu.metrostate.oodi.brewandbyte.controller;

import edu.metrostate.oodi.brewandbyte.model.Ingredient;
import edu.metrostate.oodi.brewandbyte.model.Inventory;
import edu.metrostate.oodi.brewandbyte.view.BaristaScreen;

public class BaristaController {
    private final Inventory inventory;
    private final BaristaScreen screen;

    public BaristaController(Inventory inventory, BaristaScreen screen) {
        this.inventory = inventory;
        this.screen = screen;
    }

    // Requirement 3.6: the Mark Out button.
    public void onMarkOut(String ingredientName) {
        Ingredient ingredient = inventory.find(ingredientName);
        if (ingredient == null) {
            screen.showMessage("We don't stock " + ingredientName + ".");
            return;
        }
        ingredient.markOut();
        screen.showMessage(ingredientName + " is marked out.");
    }
}
