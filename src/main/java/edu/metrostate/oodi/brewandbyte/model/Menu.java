package edu.metrostate.oodi.brewandbyte.model;

import java.util.List;
import java.util.Collections;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;

public class Menu {
	private final List<MenuItem> menuItems;
	
	public Menu(List<MenuItem> menuItems) {
		this.menuItems = new ArrayList<>(menuItems);
	}
	
	public List<MenuItem> getMenuItems() {
		return Collections.unmodifiableList(menuItems);
	}
}
