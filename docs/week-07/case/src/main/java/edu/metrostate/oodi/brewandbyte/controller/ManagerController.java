package edu.metrostate.oodi.brewandbyte.controller;

import edu.metrostate.oodi.brewandbyte.model.Ingredient;
import edu.metrostate.oodi.brewandbyte.model.Inventory;
import edu.metrostate.oodi.brewandbyte.model.Menu;
import edu.metrostate.oodi.brewandbyte.model.MenuItem;
import edu.metrostate.oodi.brewandbyte.view.ManagerScreen;

import java.util.ArrayList;
import java.util.List;

public class ManagerController {
    private final Menu menu;
    private final Inventory inventory;
    private final ManagerScreen screen;

    public ManagerController(Menu menu, Inventory inventory, ManagerScreen screen) {
        this.menu = menu;
        this.inventory = inventory;
        this.screen = screen;
    }

    // The Add Item button. The form has a name, a price like 4.50,
    // and the ingredients separated by commas, like "espresso, milk".
    public void onAddItem(String name, String price, String ingredientNames) {
        int priceInCents = (int) Math.round(Double.parseDouble(price) * 100);
        if (priceInCents <= 0) {
            screen.showMessage("The price must be more than zero.");
            return;
        }
        if (menu.find(name) != null) {
            screen.showMessage(name + " is already on the menu.");
            return;
        }
        List<Ingredient> recipe = new ArrayList<>();
        for (String ingredientName : ingredientNames.split(",")) {
            Ingredient ingredient = inventory.find(ingredientName.trim());
            if (ingredient == null) {
                screen.showMessage("We don't stock " + ingredientName.trim() + ".");
                return;
            }
            recipe.add(ingredient);
        }
        menu.add(new MenuItem(name, priceInCents, recipe));
        screen.showMessage(name + " is on the menu.");
        showMenu();
    }

    // The Change Price button.
    public void onChangePrice(String name, String price) {
        int priceInCents = (int) Math.round(Double.parseDouble(price) * 100);
        if (priceInCents <= 0) {
            screen.showMessage("The price must be more than zero.");
            return;
        }
        MenuItem item = menu.find(name);
        if (item == null) {
            screen.showMessage(name + " isn't on the menu.");
            return;
        }
        item.setPriceInCents(priceInCents);
        showMenu();
    }

    private void showMenu() {
        List<String> lines = new ArrayList<>();
        for (MenuItem item : menu.getItems()) {
            lines.add(item.getName() + "  " + String.format("$%.2f", item.getPriceInCents() / 100.0));
        }
        screen.showMenu(lines);
    }
}
