package edu.metrostate.oodi.brewandbyte.controller;

import java.math.BigDecimal;

import edu.metrostate.oodi.brewandbyte.model.MenuItem;
import edu.metrostate.oodi.brewandbyte.model.ShopHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ManagerController {
     @FXML
    private ListView<String> menuList;
    @FXML
    private TextField nameField;
    @FXML
    private TextField statusField;
    @FXML
    private TextField priceField;
    @FXML
    private Label messageLabel;

    private ShopHandler shop;

    public void connect(ShopHandler shop) {
        this.shop = shop;
        showMenu();
    }

    @FXML
    protected void onAddItem() {
        try {
            shop.addItem(nameField.getText(), new BigDecimal(priceField.getText()),statusField.getText());
            messageLabel.setText("Item Added.");
            showMenu();
        } catch (IllegalArgumentException e) {
            messageLabel.setText(e.getMessage());
        }
    }
    @FXML
    protected void onChangePrice() {
        try {
            shop.updateItemPrice(nameField.getText(), new BigDecimal(priceField.getText()));
            messageLabel.setText("Price Changed.");
            showMenu();
        } catch (IllegalArgumentException e) {
            messageLabel.setText(e.getMessage());
        }
    }
    @FXML
    private void showMenu() {
        menuList.getItems().clear();
        for (MenuItem item : shop.getMenuItems()) {
            menuList.getItems().add(item.getName() + "    $" + item.getPrice());
        }
    }
}
