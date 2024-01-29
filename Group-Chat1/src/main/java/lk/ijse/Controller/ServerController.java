package lk.ijse.Controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerController {
    @FXML
    private JFXButton btnSend;

    @FXML
    private AnchorPane paneServer;

    @FXML
    private static TextArea txtAreaServer;

    @FXML
    private TextField txtServer;

   // private static final List<Socket> socketList = new ArrayList<>();

     ServerSocket serverSocket ;
     Socket socket;

     DataOutputStream dataOutputStream;
     DataInputStream dataInputStream;

    static   String reply="";
    static String message="";

    @FXML
    void btnSendOnAction(ActionEvent event) throws IOException {
        reply= txtServer.getText().trim();
        dataOutputStream.writeUTF(reply);
        dataOutputStream.flush();

    }

    @FXML
    void txtServerOnAction(ActionEvent event) {

       // txtServer.appendText(message);

    }
    public void initialize(){
        new Thread(()-> {
            try {
                serverSocket = new ServerSocket(3003);
                socket = serverSocket.accept();
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());


                while (!message.equals("finish")) {
                    message = dataInputStream.readUTF();
                    txtAreaServer.appendText(message);

                }
                dataOutputStream.close();
                dataInputStream.close();
                socket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


}

