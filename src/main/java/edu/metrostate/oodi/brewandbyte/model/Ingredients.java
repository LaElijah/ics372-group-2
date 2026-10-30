package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;


public class Ingredients {

    private final Menu menu;
	private Map<String, Ingredient> ingredients;


    public Ingredients(Menu menu) {

        this.menu = menu;
    }


    public List<MenuItem> markOut() {
        throw new UnsupportedOperationException("not implemented");
    }

   // private Map<String, Ingredient> ingredients;


    public void markIngredients(Order order){
        Item[] items = order.getItems(); 
        Item[] customizations = order.getCustomizations(); 


        for (Item item : items){
            this.IngredientsMap[item.name].decreaseCount(item.count);
        }

        for (Item item : customizations){
            this.IngredientsMap[item.name].decreaseCount(item.count);
        }
    }


    private Ingredient {
        private final String name;
        private final int quantity;
        private final int lowInvThreshold;

        public Ingredient(String name, int quantity, int lowInvThreshold) {
            this.name = name;
            this.quantity = quantity;
            this.lowInvThreshold; 
        }

        private boolean isLow(){
            return quantity < lowInvThreshold;
        }

        public decreaseCount(int count) {
            quantity -= count;  // We need protection from negative values
            return isLow(); 
        }
    }
}


