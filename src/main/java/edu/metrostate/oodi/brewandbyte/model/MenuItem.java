package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;

public class MenuItem {
	private final String name;
	private BigDecimal price;
	private String status;
	private final Map<Ingredient, Integer> ingredients = new LinkedHashMap<>();
	
	public MenuItem(String name, BigDecimal price, String status) {
		this.name = name;
		this.price = price;
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	
	void checkAvailability()
	{
	    for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) 
	    {
	        if (entry.getKey().getQuantity() < entry.getValue())
	        {
	            status = "Unavailable"; 
	        }
	    }
	}
	
	public Map<Ingredient, Integer> getIngredients() {
		return Collections.unmodifiableMap(ingredients);
	}
	
	public void updatePrice(BigDecimal price) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void updateName(String name) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void setAvailable(String status) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public boolean isAvailable() {
	  checkAvailability();
		return (status == "Available");
	}
	
	public List<String> getChoices() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public boolean markUnavailableIfUses(Ingredient ingredient) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void addIngredient(Ingredient ingredient, int amount) {
		ingredients.put(ingredient, amount);
	}
	
}

