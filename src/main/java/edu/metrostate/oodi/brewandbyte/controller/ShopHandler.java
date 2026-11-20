package edu.metrostate.oodi.brewandbyte.Controller;

import edu.metrostate.oodi.brewandbyte.model.Menu;
import edu.metrostate.oodi.brewandbyte.model.MenuItem;
import java.math.BigDecimal;

import java.util.List;

class ShopHandler
{
    private final Menu menu; 
    
    public ShopHandler(Menu menu) 
    {
        this.menu = menu;
    }
    
    
    public void addItem(String name, BigDecimal price, String status)
    {
        menu.addItem(name, price, status);
            
    }
  
    
    public void updateItemPrice(String name, BigDecimal price) 
    {
        menu.changeItemPrice(name, price);
    }
    
    
    public List<MenuItem> getMenuItems() 
    {
        return menu.getMenuItems(); 
    }

}
