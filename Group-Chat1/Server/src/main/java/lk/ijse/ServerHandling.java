package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerHandling extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/View/Server_Form.fxml"));
        primaryStage.setTitle("Server Form");
        primaryStage.setScene(new Scene(root, 608, 497));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}

