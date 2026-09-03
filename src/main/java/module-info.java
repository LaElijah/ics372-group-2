module edu.metrostate.oodi.brewandbyte {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.metrostate.oodi.brewandbyte to javafx.fxml;
    exports edu.metrostate.oodi.brewandbyte;
}