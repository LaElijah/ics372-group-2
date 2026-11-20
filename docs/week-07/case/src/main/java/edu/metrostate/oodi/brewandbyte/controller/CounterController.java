package edu.metrostate.oodi.brewandbyte.controller;

import edu.metrostate.oodi.brewandbyte.model.Ingredient;
import edu.metrostate.oodi.brewandbyte.model.Menu;
import edu.metrostate.oodi.brewandbyte.model.MenuItem;
import edu.metrostate.oodi.brewandbyte.view.CounterScreen;

import java.util.ArrayList;
import java.util.List;

public class CounterController {
    private final Menu menu;
    private final CounterScreen screen;

    public CounterController(Menu menu, CounterScreen screen) {
        this.menu = menu;
        this.screen = screen;
    }

    // Requirement 3.6: an item with an ingredient that's out doesn't show.
    public void showMenu() {
        List<String> lines = new ArrayList<>();
        for (MenuItem item : menu.getItems()) {
            boolean available = true;
            for (Ingredient ingredient : item.getIngredients()) {
                if (ingredient.isOut()) {
                    available = false;
                }
            }
            if (available) {
                lines.add(item.getName() + "  " + String.format("$%.2f", item.getPriceInCents() / 100.0));
            }
        }
        screen.showMenu(lines);
    }
}
