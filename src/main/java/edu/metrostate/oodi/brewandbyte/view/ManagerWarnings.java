package edu.metrostate.oodi.brewandbyte.view;

import edu.metrostate.oodi.brewandbyte.model.Ingredients;
import edu.metrostate.oodi.brewandbyte.model.LowStockListener;

public class ManagerWarnings implements LowStockListener {

    @Override
    public void onLowStock(Ingredients ingredient) {
        System.out.println("Manager warning: " + ingredient.getName() + " is running low.");
    }
}
