package edu.metrostate.oodi.brewandbyte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import edu.metrostate.oodi.brewandbyte.controller.BrewAndByteController;
import edu.metrostate.oodi.brewandbyte.model.Menu;
import edu.metrostate.oodi.brewandbyte.model.ShopSetup;

public class BrewAndByteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Menu menu = ShopSetup.buildMenu();
        FXMLLoader fxmlLoader = new FXMLLoader(BrewAndByteApplication.class.getResource("brew-and-byte.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 640);
        BrewAndByteController controller = fxmlLoader.getController();
        controller.showMenu(menu);
        stage.setTitle("Brew & Byte");
        stage.setScene(scene);
        stage.show();
    }
}
