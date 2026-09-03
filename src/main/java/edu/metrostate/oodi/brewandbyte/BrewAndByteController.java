package edu.metrostate.oodi.brewandbyte;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BrewAndByteController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onBrewButtonClick() {
        welcomeText.setText("Welcome to Brew & Byte!");
    }
}
