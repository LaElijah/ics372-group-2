package edu.metrostate.oodi.brewandbyte;


import edu.metrostate.oodi.brewandbyte.model.Menu;
import edu.metrostate.oodi.brewandbyte.model.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class BrewAndByteController {
    @FXML
    private ListView<String> menuList;

    @FXML
    public void showMenu(Menu menu) {
        for (MenuItem item : menu.getMenuItems()) {
            menuList.getItems().add(item.getName() + "    $" + item.getPrice());
        }
        
    }
}

