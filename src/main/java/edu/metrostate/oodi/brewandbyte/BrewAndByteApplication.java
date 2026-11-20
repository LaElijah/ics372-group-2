package edu.metrostate.oodi.brewandbyte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import edu.metrostate.oodi.brewandbyte.controller.BrewAndByteController;
import edu.metrostate.oodi.brewandbyte.controller.ManagerController;
import edu.metrostate.oodi.brewandbyte.model.Menu;
import edu.metrostate.oodi.brewandbyte.model.ShopHandler;
import edu.metrostate.oodi.brewandbyte.model.ShopSetup;

public class BrewAndByteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ShopHandler shop = ShopSetup.buildShop();

        FXMLLoader counterLoader = new FXMLLoader(BrewAndByteApplication.class.getResource("brew-and-byte.fxml"));
        Scene counterScene = new Scene(counterLoader.load(), 480, 640);
        BrewAndByteController counter = counterLoader.getController();
        counter.showMenu(shop);
        stage.setTitle("Brew & Byte");
        stage.setScene(counterScene);
        stage.show();

        FXMLLoader managerLoader = new FXMLLoader(BrewAndByteApplication.class.getResource("manager.fxml"));
        Scene managerScene = new Scene(managerLoader.load(), 480, 640);
        ManagerController manager = managerLoader.getController();
        manager.connect(shop);
        Stage managerStage = new Stage();
        managerStage.setTitle("Brew & Byte: Manager");
        managerStage.setScene(managerScene);
        managerStage.show();
    }
}
