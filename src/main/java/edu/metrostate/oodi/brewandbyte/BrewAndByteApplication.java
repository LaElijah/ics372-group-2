package edu.metrostate.oodi.brewandbyte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BrewAndByteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BrewAndByteApplication.class.getResource("brew-and-byte.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Brew & Byte");
        stage.setScene(scene);
        stage.show();
    }
}
