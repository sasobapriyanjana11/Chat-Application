package lk.ijse.Controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private AnchorPane LoginPane;

    @FXML
    private JFXButton btnJoin;

    @FXML
    private TextField txtLogin;

    @FXML
    private Label lblLogin;


    static  String name="";

    public void initialize(){
        try {
            setServerUI();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//       new Thread(ChatServer::start).start();
    }

    private void setServerUI() throws IOException {
        new Thread(()->{
            new ServerController();
        }).start();

    }

    @FXML
    void btnJoinOnAction(ActionEvent event) {

        String name = txtLogin.getText();

        String[] words = name.split(" ");

        LoginFormController.name =words[0];

        if (txtLogin.getText().equals("stop")){
            System.exit(0);
            return;
        }

        if (txtLogin.getText().equals("") || txtLogin.getText().equals("please enter your name !")){
            txtLogin.setStyle("-fx-border-color: red");
            txtLogin.setText("please enter your name !");
            txtLogin.selectAll();
            return;
        }

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/View/Client.fxml"));
        stage.getIcons().add(new Image("/icons/icons8-send-26.png"));
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setResizable(false);
        stage.setTitle(LoginFormController.name +" in your chat");
        stage.show();
        stage.centerOnScreen();
        stage.setOnCloseRequest(Event::consume);
        txtLogin.clear();

    }

    @FXML
    void txtLoginOnAction(ActionEvent event) {

    }
}
