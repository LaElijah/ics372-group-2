package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;

public class Menu {
	private final List<MenuItem> menuItems;
	
	public Menu(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
}
