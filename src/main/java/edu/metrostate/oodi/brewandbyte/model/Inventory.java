package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;



public class Inventory 
{
  Map<String, Ingredient> inventory = new HashMap<>();
  Set<String> outIngredients = new HashSet(); 
	
	public void addIngredient(Ingredient ingredient)
	{
	    ingredients.put(ingredient.getName(), ingredient);
	}
	
	
	public Ingredient getIngredient(String string)
	{
	    return ingredients.get(string);
	}

}
