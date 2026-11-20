package edu.metrostate.oodi.brewandbyte.controller;

import edu.metrostate.oodi.brewandbyte.model.Ingredient;
import edu.metrostate.oodi.brewandbyte.model.Inventory;
import edu.metrostate.oodi.brewandbyte.model.Menu;
import edu.metrostate.oodi.brewandbyte.view.ManagerScreen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddItemTest {
    @Test
    void refusesANameAlreadyOnTheMenu() {
        Inventory inventory = new Inventory();
        inventory.add(new Ingredient("espresso", 100));
        Menu menu = new Menu();
        ManagerController controller = new ManagerController(menu, inventory, new ManagerScreen());

        controller.onAddItem("Mocha", "4.75", "espresso");
        controller.onAddItem("Mocha", "5.25", "espresso");

        assertEquals(1, menu.getItems().size());
        assertEquals(475, menu.find("Mocha").getPriceInCents());
    }
}
