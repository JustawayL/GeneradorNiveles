package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class InicioController {
    @FXML
    TextField filas;
    @FXML
    TextField columnas;

    public void test(){
        builderController controller;
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("builder.fxml"));

            //fxmlLoader.setController(controller);
            root = fxmlLoader.load();
            controller = fxmlLoader.getController();
            controller.setX(Integer.parseInt(filas.getText()));
            controller.setY(Integer.parseInt(columnas.getText()));
            Stage stage = new Stage();
            stage.setTitle("Builder");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            filas.getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
