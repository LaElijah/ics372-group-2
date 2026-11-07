package edu.metrostate.oodi.brewandbyte.view;

import edu.metrostate.oodi.brewandbyte.model.Ingredient;
import edu.metrostate.oodi.brewandbyte.model.LowStockListener;

public class ManagerWarnings implements LowStockListener {

    @Override
    public void onLowStock(Ingredient ingredient) {
        System.out.println("Manager warning: " + ingredient.getName() + " is running low.");
    }
}
