package edu.metrostate.oodi.brewandbyte.controller;


import edu.metrostate.oodi.brewandbyte.model.Menu;
import edu.metrostate.oodi.brewandbyte.model.MenuItem;
import edu.metrostate.oodi.brewandbyte.model.ShopHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class BrewAndByteController {

    @FXML
    private ListView<String> menuList;

    public void showMenu(ShopHandler shop) {
        for (MenuItem item : shop.getMenuItems()) {
            menuList.getItems().add(item.getName() + "    $" + item.getPrice());
        }
        
    }
}

