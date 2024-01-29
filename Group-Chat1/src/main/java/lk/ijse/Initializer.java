package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Initializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/Login.fxml"))));
        stage.setTitle("Login Form");
        stage.centerOnScreen();
        // stage.setFullScreen(true);

        stage.show();
    }
}
/*
* #DCF2F1
* #7FC7D9
* #365486
* #0F1035
* #7D7C7C
* #F1EFEF
* #776B5D
* #A9A9A9
* #C4DFDF
* #D2E9E9
* #BFCCB5
* #222222
* 7FC8A9
* 00ADB5
* 526D82
* 9DB2BF
* 27374D
* */