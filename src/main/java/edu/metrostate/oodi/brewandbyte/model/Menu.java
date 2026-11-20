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
    
    public void addItem(String name, BigDecimal price, String status)
    {
        if (!menuItems.contains(name))
        {
            menuItems.add(new MenuItem(name, price, status));
        }
        else 
            throw new IllegalArgumentException("Item already exists"); 
        
        
        
    }
    
    
    public void changeItemPrice(String name, BigDecimal price)
    {
        if (menuItems.contains(name))
        {
            if (price.compareTo(new BigDecimal(0)) > 0)
            {
                
                getMenuItem(name).updatePrice(price); 
            }
            else 
                throw new IllegalArgumentException("Could not change item price: price must be more than 0"); 
        }
        else 
            throw new IllegalArgumentException("Could not change item price: item doesn't exist"); 
        
        
    }
    

    public MenuItem getMenuItem(String name)
    {
        for (MenuItem item : menuItems)
            if (item.getName() == name)
                return item;
                
                
        return null;
            
    }
}
