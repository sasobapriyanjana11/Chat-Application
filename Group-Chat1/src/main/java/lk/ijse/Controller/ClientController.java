
package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientController {

    @FXML
    private JFXButton btnSend;

    @FXML
    private ImageView iconCamera;

    @FXML
    private ImageView iconEmoji;

    @FXML
    private VBox idVBox;

    @FXML
    private Label lblClient;

    @FXML
    private AnchorPane paneClient;

    @FXML
    private TextField txtclient;

    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    private String clientName;

     String message="";
     String reply="";


    public  void initialize(){
        lblClient.setText(LoginFormController.name);
        clientName = lblClient.getText();
        new Thread(()-> {
            try {
                socket = new Socket("localhost", 3003);
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                while (!message.equals("finish")) {
                   message = dataInputStream.readUTF();
                    Platform.runLater(()->{ idVBox.getChildren().addAll(new Label("Client :" + message));
                    });

                }

                dataOutputStream.close();
                dataInputStream.close();
                socket.close();

            } catch (Exception e) {
                System.out.println("Error in the client"+e.getMessage());
            }
        }).start();
    }
    @FXML
    void btnSendOnAction(ActionEvent event) {
        reply= txtclient.getText().trim();
        try {
            dataOutputStream.writeUTF(reply);
            dataOutputStream.flush();
        } catch (IOException e) {
            System.out.println("something went wrong"+e.getMessage());
        }

    }

    @FXML
    void txtclientOnAction(ActionEvent event) {

    }

}

