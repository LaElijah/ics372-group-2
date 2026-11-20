package edu.metrostate.oodi.brewandbyte.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> items = new ArrayList<>();

    public void add(MenuItem item) {
        items.add(item);
    }

    public MenuItem find(String name) {
        for (MenuItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public List<MenuItem> getItems() {
        return List.copyOf(items);
    }
}
