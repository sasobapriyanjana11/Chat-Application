package lk.ijse;



import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm {

    @FXML
    private AnchorPane LoginPane;

    @FXML
    private JFXButton btnJoin;

    @FXML
    private TextField txtUserName;

    public  static  String name;

    @FXML
    void btnJoinOnAction(ActionEvent event) throws IOException {
        name=txtUserName.getText();
        txtUserName.clear();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/Client1ChatForm.fxml"))));
        stage.setTitle("Chat Room");
        stage.show();

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

}
