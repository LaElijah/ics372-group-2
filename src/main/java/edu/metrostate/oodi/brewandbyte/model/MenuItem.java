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
	private final Map<Ingredients, Integer> ingredients = new LinkedHashMap<>();
	
	public MenuItem(String name, BigDecimal price, String status) {
		this.name = name;
		this.price = price;
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	
	public Map<Ingredients, Integer> getIngredients() {
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
		throw new UnsupportedOperationException("not implemented");
	}
	
	public List<String> getChoices() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public boolean markUnavailableIfUses(Ingredients ingredient) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public void addIngredient(Ingredients ingredient, int amount) {
		ingredients.put(ingredient, amount);
	}
	
}

